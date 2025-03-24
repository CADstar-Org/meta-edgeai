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
    file://0001-arm64-dts-ti-j722s-Add-DTB-overlay-for-RTOS-memory-m.patch \
    file://arm64-dts-ti-k3-tda54-vdk-Enable-IPC-with-M55-and-C7.patch \
    file://irqchip-irq-ti-sci-intr-Update-Mailbox-IRQ-input-lin.patch \
    file://remoteproc-k3-dsp-Prevent-TI-SCI-messaging.patch \
    file://remoteproc-k3-m4-Prevent-TI-SCI-messaging.patch \
    file://arm64-defconfig-Enable-TI-K3-M4-Remoteproc-driver.patch \
"

PR:append = "_edgeai_8"
