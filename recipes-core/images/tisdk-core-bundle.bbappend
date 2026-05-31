PR:append = "_edgeai_1"

TARGET_IMAGE_TYPES = "tar.xz"

TARGET_IMAGES = "tisdk-edgeai-image"
TARGET_IMAGES:adas = "tisdk-adas-image"

DTB_FILTER:tda54 = "k3-tda54"

# Needed pre-builts to run linux on VDK OOB
DEPLOY_IMAGES_NAME:append:tda54 = " trusted-firmware-a/* optee/bl32.bin optee/bl32.elf u-boot* xen-tda54-vdk lpddr5-firmware.bin ti-snps-lpddr-fw/* vmlinux "
