package com.bjpowernode.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * @author feng
 * @date 2021/3/11
 * @Description
 */
@Controller
public class myDateController {
    @RequestMapping("/mydate")
    public String myDate(
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            Date mydate, Map<String,Date> map){
        map.put("mydate",mydate);
        System.out.println(mydate);
        return "main";
    }
}
