package com.bjpowernode.day09.hw.login.domain;

import lombok.*;

/**
 * @author feng
 * @date 2020/12/27
 * @Description
 */
@ToString
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
//@AllArgsConstructor
public class User {

    private String loginAct;
    private String loginPwd;
    private String userName;
}
