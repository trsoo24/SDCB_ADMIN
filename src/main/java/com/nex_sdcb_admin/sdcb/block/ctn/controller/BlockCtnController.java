package com.nex_sdcb_admin.sdcb.block.ctn.controller;

import com.nex_sdcb_admin.sdcb.block.ctn.dto.DeleteBlockCtnRequest;
import com.nex_sdcb_admin.sdcb.block.ctn.dto.InsertBlockCtnRequest;
import com.nex_sdcb_admin.sdcb.block.ctn.entity.BlockCtn;
import com.nex_sdcb_admin.sdcb.block.ctn.service.BlockCtnService;
import com.nex_sdcb_admin.sdcb.common.response.ListResult;
import com.nex_sdcb_admin.sdcb.common.response.StatusResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/block/ctns")
@RequiredArgsConstructor
public class BlockCtnController {
    private final BlockCtnService blockCtnService;

    @GetMapping
    public ListResult<BlockCtn> getBlockCtnList() {
        return new ListResult<>(true, blockCtnService.getBlockCtnList());
    }

    @PostMapping
    public StatusResult insertBlockCtn(@RequestBody InsertBlockCtnRequest request) {
        blockCtnService.insertBlockCtn(request);

        return new StatusResult(true);
    }

    @DeleteMapping
    public StatusResult deleteBlockCtn(@RequestBody DeleteBlockCtnRequest request) {
        blockCtnService.deleteBlockCtn(request);

        return new StatusResult(true);
    }

    @GetMapping("/check")
    public StatusResult checkExistsBlockCtn(@RequestParam("ctn") String ctn) {
        return new StatusResult(blockCtnService.existBlockCtn(ctn));
    }
}
