package com.nex_sdcb_admin.sdcb.block.feeType.dto;

public record InsertBlockFeeTypeRequest(
        String feeTypeCode,
        String feeTypeName,
        String regId
) {
}
