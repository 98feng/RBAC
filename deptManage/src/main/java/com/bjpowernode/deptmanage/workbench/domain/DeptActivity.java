package com.bjpowernode.deptmanage.workbench.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author feng
 * @date 2020/10/12 - 19:58
 * @Description
 */
@Data
@NoArgsConstructor
public class DeptActivity implements Serializable {
    private String id;

    private String owner;

    private String deptno;

    private String dname;

    private String loc;

    private String startDate;

    private String endDate;

    private String description;

    private String createTime;

    private String createBy;

    private String editTime;

    private String editBy;

    private static final long serialVersionUID = 1L;
}

