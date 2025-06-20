FILESEXTRAPATHS:prepend := "${THISDIR}/ti-rpmsg-char:"

SRC_URI:append:tda54 = " \
    file://0001-TDA54-Add-TDA54-IPC-support-for-R52-remoteproc.patch \
"

PATCHTOOL = "git"

PR:append = "_edgeai_0"
