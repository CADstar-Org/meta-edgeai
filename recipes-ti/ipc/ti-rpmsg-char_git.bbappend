FILESEXTRAPATHS:prepend := "${THISDIR}/ti-ipc/:"

SRC_URI:append:tda54 = " \
    file://0001-Revert-lib-Do-not-update-local-endpoint.patch \
    file://0002-Revert-rpmsg_char-Remove-unused-function-and-local-v.patch \
"
PR:append = "_edgeai_1"
