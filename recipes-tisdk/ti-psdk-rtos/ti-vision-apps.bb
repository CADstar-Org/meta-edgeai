SUMMARY = "OpenVX Middleware library"
DESCRIPTION = "Builds tivision_apps user space library"

PR:append = "_edgeai_16"

PV = "11.02.03"

LICENSE = "TI-TFL & BSD-2-Clause & BSD-3-Clause & BSD-4-Clause & MIT & Apache-2.0 & Apache-2.0-with-LLVM-exception & \
           Khronos & Hewlett-Packard & Patrick-Powell & FTL & Zlib & CC0-1.0 & OpenSSL"

LIC_FILES_CHKSUM = "file://${COREBASE}/../meta-ti/meta-ti-bsp/licenses/TI-TFL;md5=a1b59cb7ba626b9dbbcbf00f3fbc438a \
                    file://${COMMON_LICENSE_DIR}/BSD-2-Clause;md5=cb641bc04cda31daea161b1bc15da69f \
                    file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9 \
                    file://${COMMON_LICENSE_DIR}/BSD-4-Clause;md5=624d9e67e8ac41a78f6b6c2c55a83a2b \
                    file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10 \
                    file://${COMMON_LICENSE_DIR}/Apache-2.0-with-LLVM-exception;md5=0bcd48c3bdfef0c9d9fd17726e4b7dab \
                    file://${UNPACKDIR}/repo/tiovx/include/VX/vx.h;beginline=1;endline=15;md5=37315206223081f32a5b9aaaf912f637 \
                    file://${COREBASE}/../meta-ti/meta-ti-extras/licenses/Hewlett-Packard;md5=a07676ee09f5bfec457eb5ea75921d01 \
                    file://${COREBASE}/../meta-ti/meta-ti-extras/licenses/Patrick-Powell;md5=7e10716f13cff502f3cf6ebf8fe29c1e \
                    file://${COMMON_LICENSE_DIR}/FTL;md5=f0bf6b09ee8b02121ed10709d9e49d8b \
                    file://${COMMON_LICENSE_DIR}/Zlib;md5=87f239f408daca8a157858e192597633 \
                    file://${COMMON_LICENSE_DIR}/CC0-1.0;md5=0ceb3372c9595f0a8067e55da801e4a1 \
                    file://${COREBASE}/meta/files/common-licenses/OpenSSL;md5=4eb1764f3e65fafa1a25057f9082f2ae \
                    "

SRCREV_protobuf = "f0dc78d7e6e331b8c6bb2d5283e06aa26883ca7c"
SRC_URI = "repo://git.ti.com/git/processor-sdk/psdk_repo_manifests.git;protocol=https;branch=refs/tags/REL.PSDK.ANALYTICS.11.02.01.01;manifest=vision_apps_yocto.xml \
           git://github.com/protocolbuffers/protobuf;branch=main;protocol=https;name=protobuf;destsuffix=${UNPACKDIR}/repo/protobuf"

SRC_URI:am62axx = "repo://git.ti.com/git/processor-sdk/psdk_repo_manifests.git;protocol=https;branch=refs/tags/REL.PSDK.ANALYTICS.AM62A.11.02.00.03;manifest=vision_apps_yocto_am62a.xml"
SRC_URI:edgeai = "repo://git.ti.com/git/processor-sdk/psdk_repo_manifests.git;protocol=https;branch=refs/tags/REL.PSDK.ANALYTICS.NONSAFETY.11.01.00.03;manifest=vision_apps_yocto_nonsafety.xml"
FILES:${PN} += "/opt/*"

#PTK needs:
# EGL/egl.h
# glm/glm.hpp
# IL/il.h
# /usr/include/freetype2/ft2build.h
# ti_rpmsg_char.h

DEPENDS = "glm freetype ti-rpmsg-char repo-native virtual/egl libpam"
# nlohmann-json & stb is not needed for AM62A as it doesn't supports SRV demo
# For J7* devices, we build tidl_rt within yocto_build. For AM62A, tidl_rt is still built separately via ti-tidl recipe
DEPENDS:append:adas = " nlohmann-json stb ti-tidl-osrt"

COMPATIBLE_MACHINE = "j721e|j721s2|j784s4|j722s|j742s2|am62axx"

PLAT_SOC = ""
PLAT_SOC:j721e = "j721e"
PLAT_SOC:j721s2 = "j721s2"
PLAT_SOC:j784s4 = "j784s4"
PLAT_SOC:j722s = "j722s"
PLAT_SOC:j742s2 = "j742s2"
PLAT_SOC:am62axx = "am62a"

S = "${UNPACKDIR}/repo/sdk_builder"

export TARGET_FS = "${WORKDIR}/recipe-sysroot"

do_fetch[depends] += "repo-native:do_populate_sysroot"

CLEANBROKEN = "1"

do_compile:am62axx() {
    CROSS_COMPILE_LINARO=aarch64-oe-linux- \
    LINUX_SYSROOT_ARM=${STAGING_DIR_TARGET} \
    TREAT_WARNINGS_AS_ERROR=0 \
    GCC_LINUX_ARM_ROOT= \
    GCC_LINUX_ARM_ROOT_A72= \
    LINUX_FS_PATH=${STAGING_DIR_TARGET} \
    SOC=${PLAT_SOC} \
    oe_runmake yocto_build
}

do_compile() {
    ln -snf ${TARGET_FS} ${UNPACKDIR}/repo/targetfs
    
    # Use ti-tidl-osrt installed headers and protobuf source from recipe-sysroot

    PSDK_INSTALL_PATH=${UNPACKDIR}/repo \
    CROSS_COMPILE_LINARO=aarch64-oe-linux- \
    LINUX_SYSROOT_ARM=${STAGING_DIR_TARGET} \
    TREAT_WARNINGS_AS_ERROR=0 \
    GCC_LINUX_ARM_ROOT= \
    GCC_LINUX_ARM_ROOT_A72= \
    LINUX_FS_PATH=${TARGET_FS} \
    SOC=${PLAT_SOC} \
    TF_REPO_PATH="${TARGET_FS}${includedir}/tensorflow" \
    ONNX_REPO_PATH="${TARGET_FS}${includedir}/onnxruntime" \
    TIDL_PROTOBUF_PATH="${UNPACKDIR}/repo/protobuf" \
    oe_runmake yocto_build
}

do_install() {
    SOC=${PLAT_SOC} LINUX_FS_STAGE_PATH=${D} oe_runmake yocto_install
}

INSANE_SKIP:${PN} += "ldflags buildpaths"
