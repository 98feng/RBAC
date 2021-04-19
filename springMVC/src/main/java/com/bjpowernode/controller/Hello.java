package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * @author feng
 * @date 2021/3/9
 * @Description
 */
@Controller
@RequestMapping("/zar")
public class Hello {


    @RequestMapping("/hello")
    public String hello(HttpServletRequest request){
        return "main";

    }
}
