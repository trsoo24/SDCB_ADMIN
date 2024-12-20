package com.nex_sdcb_admin.sdcb.block.ctn.mapper;

import com.nex_sdcb_admin.sdcb.block.ctn.dto.InsertBlockCtnRequest;
import com.nex_sdcb_admin.sdcb.block.ctn.entity.BlockCtn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlockCtnMapper {
    int insertBlockCtn(InsertBlockCtnRequest request);
    List<BlockCtn> selectBlockCtnList();
    int deleteBlockCtn(List<String> ctnList);
    boolean existBlockCtn(String ctn);
}
