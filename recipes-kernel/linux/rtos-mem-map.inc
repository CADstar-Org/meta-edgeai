FILESEXTRAPATHS:prepend := "${THISDIR}/linux-ti-staging/:${THISDIR}/linux-ti-staging/${MACHINE}:"

SRC_URI:append:j721e = " \
    file://0001-arm64-dts-ti-Add-DTB-overlays-for-vision-apps-and-ed.patch \
"

SRC_URI:append:j721s2 = " \
    file://0001-arm64-dts-ti-Add-DTB-overlay-for-vision-apps.patch \
    file://0002-arm64-dts-ti-k3-j721s2-Add-overlay-for-edge-ai.patch \
"

SRC_URI:append:j784s4 = " \
    file://0001-arm64-dts-ti-Add-DTB-overlay-for-vision-apps.patch \
    file://0002-arm64-dts-ti-k3-j784s4-Add-overlay-for-edge-ai.patch \
"

SRC_URI:append:j742s2 = " \
    file://0001-arm64-dts-ti-Add-DTB-overlay-for-vision-apps.patch \
"

SRC_URI:append:j722s = " \
    file://0001-arm64-dts-ti-j722s-Add-DTB-overlay-for-RTOS-memory-m.patch \
"

SRC_URI:append:tda54 = " \
    file://0001-TDA54-remoteproc-k3-r5-Add-support-to-boot-R52-MCUs.patch \
    file://0002-TDA54-irqchip-irq-ti-sci-intr-Add-support-to-map-mul.patch \
    file://0003-TDA54-arm64-dts-ti-k3-tda54-mcu-wakeup-Add-R52-clust.patch \
    file://0004-TDA54-arm64-dts-ti-k3-tda54-Add-R52-Cluster-ranges.patch \
    file://0005-TDA54-arm64-dts-ti-k3-tda54-vdk-Enable-IPC-with-R52-.patch \
    file://0006-arch-k3-tda54-vdk.dts-Add-shared-memory-sections-for.patch \
"

PR:append = "_edgeai_8"
