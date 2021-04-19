package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author feng
 * @date 2021/3/11
 * @Description
 */
@Controller
public class One {
    @RequestMapping("/one")
    public String one(){
        System.out.println("one.action");
        return "main";
    }
}
