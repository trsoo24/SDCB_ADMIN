package com.nex_sdcb_admin.sdcb.block.ctn.dto;

public record InsertBlockCtnRequest(
        String ctn,
        String regId,
        Long subNo
){
    public InsertBlockCtnRequest setCtn(String ctn) {
        return new InsertBlockCtnRequest(ctn, regId, subNo);
    }
}
