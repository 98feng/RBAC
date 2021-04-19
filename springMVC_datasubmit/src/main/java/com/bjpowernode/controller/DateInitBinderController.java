package com.bjpowernode.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author feng
 * @date 2021/3/11
 * @Description
 */
@Controller
public class DateInitBinderController {

    @InitBinder
    public void mydate(WebDataBinder dataBinder){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dataBinder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
    }

    @RequestMapping("/mydate1")
    public String mydate(Date mydate1){
        System.out.println(mydate1);
        return "main";
    }
}
