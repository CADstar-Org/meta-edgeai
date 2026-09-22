SUMMARY = "EdgeAI TVM model artifacts"
DESCRIPTION = "Precompiled TVM model artifacts for the yamnet, vggish11, and gcrn EVM models"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${UNPACKDIR}/src"
PR = "_edgeai_0"

MODELZOO_URI = "https://software-dl.ti.com/jacinto7/esd/modelzoo/11_02_18_00/modelartifacts/AM62D"

SRC_URI = " \
    ${MODELZOO_URI}/ac-0201_tvmrt_audio_classification_urbansound8k_yamnet_onnx.tar.gz;name=yamnet;subdir=${S}/yamnet \
    ${MODELZOO_URI}/ac-0101_tvmrt_audio_classification_urbansound8k_vggish11_onnx.tar.gz;name=vggish;subdir=${S}/vggish \
    ${MODELZOO_URI}/ase-0201_tvmrt_speech_enhancement_voicebank_demand_16k_gcrn_fixed_4sec_onnx.tar.gz;name=gcrn;subdir=${S}/gcrn \
"

SRC_URI[yamnet.sha256sum] = "8a5a41f3db649fa0b94c1431a404474d70f9d8b4aab4636704f947d3b35d4a4d"
SRC_URI[vggish.sha256sum] = "c62f4f1b6af7d8525ab555aaada61388965ab3a12ffabd07365cc2a48169f0d7"
SRC_URI[gcrn.sha256sum] = "7121c81715291ba7ef0c12c81ab056c03e0cad5ff65d19ab4afb8544438522aa"

COMPATIBLE_MACHINE = "am62dxx"

FILES:${PN} += "${datadir}/tvm_inference/"

do_install() {
    # Install only the EVM-specific TVM artifacts for each model, keyed by
    # short model name, dropping the .evm suffix on install
    for model in yamnet vggish gcrn; do
        artifacts_dir=${D}${datadir}/tvm_inference/artifacts/${model}
        install -d ${artifacts_dir}
        install -m 0644 ${S}/${model}/*/artifacts/deploy_graph.json.evm ${artifacts_dir}/deploy_graph.json
        install -m 0755 ${S}/${model}/*/artifacts/deploy_lib.so.evm ${artifacts_dir}/deploy_lib.so
        install -m 0644 ${S}/${model}/*/artifacts/deploy_param.params.evm ${artifacts_dir}/deploy_param.params
    done
}
