package com.nex_sdcb_admin.sdcb.purchase.mapper;

import com.nex_sdcb_admin.sdcb.purchase.dto.NoticePurchaseProduct;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticePurchaseProductMapper {
    void insertNotiPurchaseProduct(NoticePurchaseProduct noticePurchaseProduct);
}
