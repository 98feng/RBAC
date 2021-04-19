package com.bjpowernode.deptmanage.workbench.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class EmpActivityRemark implements Serializable {
    /**
     *
     */
    private String id;

    /**
     *
     */
    private String noteContent;

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
     * 0±íÊ¾Î´ÐÞ¸Ä£¬1±íÊ¾ÒÑÐÞ¸Ä
     */
    private String editFlag;

    /**
     *
     */
    private String activityId;

    private static final long serialVersionUID = 1L;
}

