package com.bjpowernode.library.settings.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author feng
 * @date 2021/1/2
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author implements Serializable {

    private static final long serialVersionUID = -4690617500823090451L;
    private String authorLoginId;
    private String authorLoginPwd;


}
