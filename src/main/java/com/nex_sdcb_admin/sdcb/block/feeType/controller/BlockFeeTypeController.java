package com.nex_sdcb_admin.sdcb.block.feeType.controller;

import com.nex_sdcb_admin.sdcb.block.feeType.dto.DeleteBlockFeeTypeRequest;
import com.nex_sdcb_admin.sdcb.block.feeType.dto.InsertBlockFeeTypeRequest;
import com.nex_sdcb_admin.sdcb.block.feeType.entity.BlockFeeType;
import com.nex_sdcb_admin.sdcb.block.feeType.service.BlockFeeTypeService;
import com.nex_sdcb_admin.sdcb.common.response.ListResult;
import com.nex_sdcb_admin.sdcb.common.response.StatusResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/block/fee-types")
@RequiredArgsConstructor
public class BlockFeeTypeController {
    private final BlockFeeTypeService blockFeeTypeService;

    @PostMapping
    public StatusResult insertBlockFeeType(@RequestBody InsertBlockFeeTypeRequest request) {
         boolean result = blockFeeTypeService.insertBlockFeeType(request);

         return new StatusResult(result);
    }

    @GetMapping
    public ListResult<BlockFeeType> selectBlockFeeTypes() {
        List<BlockFeeType> blockFeeTypeList = blockFeeTypeService.getBlockFeeTypeList();

        return new ListResult<>(true, blockFeeTypeList);
    }

    @GetMapping("/check")
    public StatusResult checkBlockFeeType(@RequestParam("/blockFeeTypeCd") String blockFeeTypeCd) {
        boolean result = blockFeeTypeService.existBlockFeeType(blockFeeTypeCd);

        return new StatusResult(result);
    }

    @DeleteMapping
    public StatusResult deleteBlockFeeType(@RequestBody DeleteBlockFeeTypeRequest request) {
        boolean result = blockFeeTypeService.deleteBlockFeeType(request);

        return new StatusResult(result);
    }
}
