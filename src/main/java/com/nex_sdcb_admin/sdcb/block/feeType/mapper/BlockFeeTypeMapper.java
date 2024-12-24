package com.nex_sdcb_admin.sdcb.block.feeType.mapper;

import com.nex_sdcb_admin.sdcb.block.feeType.dto.InsertBlockFeeTypeRequest;
import com.nex_sdcb_admin.sdcb.block.feeType.entity.BlockFeeType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlockFeeTypeMapper {
    boolean insertBlockFeeType(InsertBlockFeeTypeRequest request);
    List<BlockFeeType> selectBlockFeeType();
    boolean deleteBlockFeeType(String feeTypeCd);
    boolean existBlockFeeType(String feeTypeCd);
}
