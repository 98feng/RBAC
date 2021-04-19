package com.bjpowernode.deptmanage.workbench.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class EmpActivity implements Serializable {
    /**
     *
     */
    private String id;

    /**
     *
     */
    private String ename;

    /**
     *
     */
    private String owner;

    /**
     *
     */
    private String sal;

    /**
     *
     */
    private String comm;

    /**
     *
     */
    private String startDate;

    /**
     *
     */
    private String endDate;

    /**
     *
     */
    private String description;

    /**
     *
     */
    private String createTime;

    /**
     *
     */
    private String createBy;

    /**
     *
     */
    private String editTime;

    /**
     *
     */
    private String editBy;

    /**
     *
     */
    private String job;

    /**
     *
     */
    private String mgr;

    private static final long serialVersionUID = 1L;
}

