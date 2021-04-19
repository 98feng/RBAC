package com.bjpowernode.crm.settings.service;

import com.bjpowernode.crm.settings.domain.DicType;

import java.util.List;

/**
 * 动力节点
 * 2021/3/23
 */
public interface DicTypeService {

    List<DicType> queryAllDicTypes();

    DicType queryDicTypeByCode(String code);

    int saveCreateDicType(DicType dicType);

    int deleteDicTypeByCodes(String[] codes);

    int saveEditType(DicType dicType);
}
