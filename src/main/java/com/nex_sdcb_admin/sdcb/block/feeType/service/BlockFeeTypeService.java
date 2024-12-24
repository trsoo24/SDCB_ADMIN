package com.nex_sdcb_admin.sdcb.block.feeType.service;

import com.nex_sdcb_admin.sdcb.block.feeType.dto.DeleteBlockFeeTypeRequest;
import com.nex_sdcb_admin.sdcb.block.feeType.dto.InsertBlockFeeTypeRequest;
import com.nex_sdcb_admin.sdcb.block.feeType.entity.BlockFeeType;
import com.nex_sdcb_admin.sdcb.block.feeType.mapper.BlockFeeTypeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BlockFeeTypeService {
    private final BlockFeeTypeMapper blockFeeTypeMapper;

    // 차단 요금제 생성
    public boolean insertBlockFeeType(InsertBlockFeeTypeRequest request) {
        String trxNo = MDC.get("trxNo");
        log.info("[{}] 요청 = 차단 요금제 생성 ", trxNo);

        boolean result = blockFeeTypeMapper.insertBlockFeeType(request);

        if (result) {
            log.info("[{}] 응답 : {} 요금제 차단 완료", trxNo, request.feeTypeName());
        } else {
            log.info("[{}] 응답 : {} 요금제 차단 실패", trxNo, request.feeTypeName());
        }

        return result;
    }

    // 차단 요금제 조회
    public List<BlockFeeType> getBlockFeeTypeList() {
        String trxNo = MDC.get("trxNo");
        log.info("[{}] 요청 = 차단 요금제 전체 조회 ", trxNo);

        List<BlockFeeType> blockFeeTypeList = blockFeeTypeMapper.selectBlockFeeType();

        log.info("[{}] 응답 = 차단 요금제 {} 건 조회 완료", trxNo, blockFeeTypeList.size());

        return blockFeeTypeList;
    }

    // 차단 요금제 중복 조회
    public boolean existBlockFeeType(String feeTypeCd) {
        String trxNo = MDC.get("trxNo");
        log.info("[{}] 요청 = 차단 CTN 중복 조회", trxNo);

        boolean result = blockFeeTypeMapper.existBlockFeeType(feeTypeCd);

        if (result) {
            log.info("[{}] 응답 = {} 는 이미 존재하는 중복된 요금제 코드 입니다", trxNo, feeTypeCd);
        } else {
            log.info("[{}] 응답 = {} 는 중복되지 않은 요금제 코드 입니다.", trxNo, feeTypeCd);
        }

        return result;
    }

    // 차단 요금제 삭제
    public boolean deleteBlockFeeType(DeleteBlockFeeTypeRequest request) {
        String trxNo = MDC.get("trxNo");
        log.info("[{}] 요청 = 차단 요금제 {} 건 차단 해제", trxNo, request.feeTypeCds().size());

        List<String> feeTypeList = request.feeTypeCds();

        boolean deleteResponse = false;
        for (String feeTypeCd : feeTypeList) {
            deleteResponse = blockFeeTypeMapper.deleteBlockFeeType(feeTypeCd);

            if (!deleteResponse) {
                break;
            }
        }

        if(deleteResponse) {
            log.info("[{}] 응답 = 차단 요금제 {} 건 차단 해제 완료", trxNo, feeTypeList.size());
        } else {
            log.info("[{}] 응답 = 차단 요금제 차단 해제 실패", trxNo);
        }
        return deleteResponse;
    }
}
