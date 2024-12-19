package com.nex_sdcb_admin.sdcb.purchase.mapper;

import com.nex_sdcb_admin.sdcb.purchase.dto.NoticePurchaseType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticePurchaseTypeMapper {
    void insertNotiPurchaseType(NoticePurchaseType noticePurchaseType);
}
