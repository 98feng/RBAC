package com.bjpowernode.crm.workbench.service;

import com.bjpowernode.crm.workbench.domain.ClueActivityRelation;

import java.util.List;

/**
 * 动力节点
 * 2021/4/2
 */
public interface ClueActivityRelationService {

    int deleteClueActivityRelationByClueIdAndActivityId(ClueActivityRelation relation);

    //批量添加
    int saveCreateClueActivityRelationByList(List<ClueActivityRelation> relationList);
}
