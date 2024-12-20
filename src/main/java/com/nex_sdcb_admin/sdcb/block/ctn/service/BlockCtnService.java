package com.nex_sdcb_admin.sdcb.block.ctn.service;

import com.nex_sdcb_admin.sdcb.block.ctn.dto.DeleteBlockCtnRequest;
import com.nex_sdcb_admin.sdcb.block.ctn.dto.InsertBlockCtnRequest;
import com.nex_sdcb_admin.sdcb.block.ctn.entity.BlockCtn;
import com.nex_sdcb_admin.sdcb.block.ctn.mapper.BlockCtnMapper;
import com.nex_sdcb_admin.sdcb.common.service.FunctionUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BlockCtnService {
    private final BlockCtnMapper blockCtnMapper;

    // 차단 CTN 생성
    public void insertBlockCtn(InsertBlockCtnRequest request) {
        String trxNo = MDC.get("trxNo");
        log.info("[{}] 요청 = 차단 CTN 생성 ", trxNo);

        String transCtn = FunctionUtil.trans12Ctn(request.ctn());

        InsertBlockCtnRequest newRequest = request.setCtn(transCtn);

        int result = blockCtnMapper.insertBlockCtn(newRequest);

        if (result > 0) {
            log.info("[{}] 응답 : {} ctn 차단 완료", trxNo, request.ctn());
        }
    }

    // 차단 CTN 조회
    public List<BlockCtn> getBlockCtnList() {
        String trxNo = MDC.get("trxNo");
        log.info("[{}] 요청 = 차단 CTN 전체 조회 ", trxNo);

        List<BlockCtn> dtoList = blockCtnMapper.selectBlockCtnList();
        transListDto(dtoList);

        log.info("[{}] 응답 = 차단 CTN {} 건 조회 완료", trxNo, dtoList.size());

        return dtoList;
    }

    // 차단 CTN 삭제
    public void deleteBlockCtn(DeleteBlockCtnRequest request) {
        String trxNo = MDC.get("trxNo");
        log.info("[{}] 요청 = 차단 CTN {} 건 차단 해제", trxNo, request.ctns().size());

        List<String> ctnList = transListCtn(request);

        int deleteResponse = blockCtnMapper.deleteBlockCtn(ctnList);

        if(deleteResponse > 0) {
            log.info("[{}] 응답 = 차단 CTN {} 건 차단 해제 완료", trxNo, ctnList.size());
        } else {
            log.info("[{}] 응답 = 차단 CTN  차단 해제 실패", trxNo);
        }
    }

    // 이미 존재하는 차단 CTN 인지 조회한다.
    public boolean existBlockCtn(String ctn) {
        String trxNo = MDC.get("trxNo");
        log.info("[{}] 요청 = 차단 CTN 중복 조회", trxNo);

        boolean result = blockCtnMapper.existBlockCtn(ctn);

        if (result) {
            log.info("[{}] 응답 = {} 는 이미 존재하는 중복된 CTN 입니다", trxNo, ctn);
        } else {
            log.info("[{}] 응답 = {} 는 중복되지 않은 CTN 입니다.", trxNo, ctn);
        }

        return result;
    }

    private void transListDto(List<BlockCtn> dtoList) {
        for (BlockCtn dto : dtoList) {
            dto.setCtn(FunctionUtil.transCtn(dto.getCtn()));
        }
    }

    private List<String> transListCtn(DeleteBlockCtnRequest request) {
        List<String> ctnList = new ArrayList<>();

        for (String ctn : request.ctns()) {
            String newCtn = FunctionUtil.trans12Ctn(ctn);
            ctnList.add(newCtn);
        }

        return ctnList;
    }
}
