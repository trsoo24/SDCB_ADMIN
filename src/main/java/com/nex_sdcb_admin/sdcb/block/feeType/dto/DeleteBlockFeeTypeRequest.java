package com.nex_sdcb_admin.sdcb.block.feeType.dto;

import java.util.List;

public record DeleteBlockFeeTypeRequest(
        List<String> feeTypeCds
) {
}
