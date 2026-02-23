PR:append = "_edgeai_1"

TARGET_IMAGE_TYPES = "tar.xz"

TARGET_IMAGES = "tisdk-edgeai-image"
TARGET_IMAGES:adas = "tisdk-adas-image"

tisdk_image_build:append:tda54() {
    # Add ti-vision-apps fw for VDK
    if [ -d "${DEPLOY_DIR_IMAGE}/ti-vision-apps" ]
    then
        cp -rf ${DEPLOY_DIR_IMAGE}/ti-vision-apps ${PREBUILT_DIR}/
    fi
}
