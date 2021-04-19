package com.bjpowernode.crm.workbench.service;

import com.bjpowernode.crm.workbench.domain.Clue;

import java.util.Map;

/**
 * 动力节点
 * 2021/3/31
 */
public interface ClueService {

    //保存线索
    int saveCreateClue(Clue clue);

    //查询线索的详情
    Clue queryClueFOrDetailById(String id);

    //转换线索
    void saveConvert(Map<String,Object> map);
}
