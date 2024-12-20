package com.nex_sdcb_admin.sdcb.block.ctn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlockCtn {
    private String ctn;
    private String regDt;
    private String regId;
    private Long subNo;

    public void setCtn(String ctn) {
        this.ctn = ctn;
    }
}
