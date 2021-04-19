package com.bjpowernode.controller;

import com.bjpowernode.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author feng
 * @date 2021/3/11
 * @Description
 *
 *
 */
@Controller
public class DataController {
    @RequestMapping("/mydata")
    public String mydata(HttpServletRequest request, HttpSession session, Model model, ModelMap modelMap, Map<String, Users> map){
        Users u = new Users("123", 123);
        request.setAttribute("requestObj",u);
        session.setAttribute("sessionObj",u);
        model.addAttribute("modelObj",u);
        modelMap.addAttribute("modelMapObj",u);
        map.put("mapObj",u);
        return "main";
    }
}
