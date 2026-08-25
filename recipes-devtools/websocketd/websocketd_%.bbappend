SRC_URI = "\
    git://${GO_IMPORT}.git;protocol=https;branch=main;destsuffix=src/${GO_IMPORT} \
    git://${GO_IMPORT_websocket}.git;protocol=https;branch=main;name=websocket;destsuffix=src/${GO_IMPORT_websocket} \
    file://0001-examples-Move-to-python3.patch \
"

PR:append = "_edgeai_0"
