DISTROOVERRIDES:append = ":adas"

# Use busybox init to boot quicker in the VDK
INIT_MANAGER := "mdev-busybox"
VIRTUAL-RUNTIME_dev_manager := "busybox-mdev"

# Autoprobe modules
KERNEL_MODULE_AUTOLOAD += "omap-mailbox rpmsg_char rpmsg_ctrl"
KERNEL_MODULE_AUTOLOAD += "ti_k3_m4_remoteproc"
KERNEL_MODULE_AUTOLOAD += "ti_k3_dsp_remoteproc"
KERNEL_MODULE_AUTOLOAD += "ti_k3_r5_remoteproc"
