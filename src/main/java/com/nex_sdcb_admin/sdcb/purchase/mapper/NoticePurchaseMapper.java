package com.nex_sdcb_admin.sdcb.purchase.mapper;

import com.nex_sdcb_admin.sdcb.purchase.dto.NoticePurchase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticePurchaseMapper {
    void insertNotiPurchase(NoticePurchase noticePurchase);
}
