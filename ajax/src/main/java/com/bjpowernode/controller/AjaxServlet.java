package com.bjpowernode.controller;

import com.bjpowernode.utils.PrintJson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author feng
 * @date 2021/2/26
 * @Description
 */
@WebServlet("/ajax.do")
public class AjaxServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入ajax.do控制器。。。。。。。。。");

        resp.setContentType("text/html;charset=utf-8");
        /*PrintWriter writer = resp.getWriter();
        writer.write("nihao1");
        writer.flush();
        writer.close();*/

        double height = Double.parseDouble(req.getParameter("height"));
        double weight = Double.parseDouble(req.getParameter("weight"));
        double bmi = weight / (height * height);
        String msg = "";
        if (bmi < 18.50){
            msg = "您太轻了，注意增加点肉";
        }else if(bmi <= 23.9){
            msg = "您太棒了，一切正常，继续保持";
        }else if(bmi <= 27){
            msg = "您有点过重了，注意饮食";
        }else if (bmi <= 32){
            msg = "您有点肥胖，要增强运动";
        }else {
            msg = "..........................";
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("success","true");
        map.put("msg",msg);
        PrintJson.printJsonObj(resp,map);
    }
}
