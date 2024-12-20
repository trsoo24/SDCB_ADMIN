package com.nex_sdcb_admin.sdcb.block.ctn.dto;

import java.util.List;

public record DeleteBlockCtnRequest(
        List<String> ctns
) {
}
