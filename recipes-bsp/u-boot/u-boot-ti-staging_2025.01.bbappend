FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV_uboot = "78bb8cc8a12687f810e5be4ac633ef3fd88bb00f"

UBOOT_GIT_URI = "git://git@bitbucket.itg.ti.com/~a0501904/ti-u-boot.git"

UBOOT_GIT_PROTOCOL = "ssh"

DM_FIRMWARE:am62axx = "dm_adas_mcu1_0_release_strip.out"

SRC_URI:append:j721e = " \
    file://0001-Optimal-QoS-Settings.patch \
    file://0001-arch-arm-dts-k3-j721e-Update-memory-map-for-PSDK-RTO.patch \
"

SRC_URI:append:j721s2 = " \
    file://0001-arch-arm-dts-k3-j721s2-k3-am68-Update-memory-map-for.patch \
"

SRC_URI:append:j784s4 = " \
    file://0001-arch-arm-dts-k3-j784s4-k3-am69-Update-memory-map-for.patch \
"

SRC_URI:append:j742s2 = " \
    file://0001-arch-arm-dts-k3-j742s2-Update-memory-map-for-PSDK-RT.patch \
"

SRC_URI:append:j722s = " \
    file://0001-arch-arm-dts-k3-j722s-Update-memory-map-for-PSDK-RTO.patch \
"

PR:append = "_edgeai_5"
