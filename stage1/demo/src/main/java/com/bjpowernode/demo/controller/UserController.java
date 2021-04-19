package com.bjpowernode.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author feng
 * @date 2020/12/6
 * @Description
 */
@RestController
@Slf4j
public class UserController {

    @RequestMapping
    public String hello(){
        log.info("ok");
        return "Hello!";
    }
}

