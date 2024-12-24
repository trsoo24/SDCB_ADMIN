package com.nex_sdcb_admin.sdcb.block.feeType.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlockFeeType {
    private String feeTypeCode;
    private String feeTypeName;
    private String blockYn;
    private String regDt;
    private String mbrId;
    private String updDt;
    private String updId;
    private final String dcb = "SDCB";
}
