PR:append = "_edgeai_1"

TARGET_IMAGE_TYPES = "tar.xz"

TARGET_IMAGES = "tisdk-edgeai-image"
TARGET_IMAGES:adas = "tisdk-adas-image"

DTB_FILTER:tda54 = "k3-tda54"
BOOT_PART:append:tda54 = "u-boot* bl31.elf bl32.elf vmlinux"

tisdk_image_build:append:tda54() {
    # Add ti-vision-apps fw for VDK
    if [ -d "${DEPLOY_DIR_IMAGE}/ti-vision-apps" ]
    then
        cp -rf ${DEPLOY_DIR_IMAGE}/ti-vision-apps ${PREBUILT_DIR}/
    fi
}
