package com.nex_sdcb_admin.sdcb.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StatusResult {
    private Boolean success;

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

