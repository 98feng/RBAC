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
public class Admin implements Serializable {

   private static final long serialVersionUID = 6046676331796199181L;
   private String loginAct;
   private String loginPwd;
}
