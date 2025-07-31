PR:append = "_edgeai_1"

TARGET_IMAGE_TYPES:edgeai = "tar.xz"
TARGET_IMAGE_TYPES:adas = "tar.xz"
TARGET_IMAGES:edgeai = "tisdk-edgeai-image"
TARGET_IMAGES:adas = "tisdk-adas-image"

TARGET_IMAGES:am62axx:append = " tisdk-tiny-initramfs"
TARGET_IMAGE_TYPES:am62axx:append = " cpio"

tisdk_image_build:append:tda54() {
    # Add ti-vision-apps fw for VDK EA
    if [ -d "${DEPLOY_DIR_IMAGE}/ti-vision-apps" ]
    then
        cp -rf ${DEPLOY_DIR_IMAGE}/ti-vision-apps ${PREBUILT_DIR}/
    fi
}
