package com.bjpowernode.crm.workbench.service;

import com.bjpowernode.crm.workbench.domain.FunnelVO;
import com.bjpowernode.crm.workbench.domain.Tran;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 动力节点
 * 2021/4/9
 */
public interface TranService {

    //保存交易
    int saveCreateTran(Map<String,Object> map);

    Tran queryTranForDetailById(String id);

    List<FunnelVO> queryCountOFTranGroupByStage();
}
