FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:tda54 = " \
    file://0001-Add-TDA54-IPC-support-for-M55-and-C76-remotecores.patch \
    file://0002-HACK-hardcode-SoC-name-as-TDA54.patch \
"

PATCHTOOL = "git"

PR:append = "_edgeai_0"
