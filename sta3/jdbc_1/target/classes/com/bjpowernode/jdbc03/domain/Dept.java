package com.bjpowernode.jdbc03.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author feng
 * @date 2021/1/21
 * @Description 部门表
 */
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Dept {
    Integer deptno;
    String dname;
    String loc;
}
