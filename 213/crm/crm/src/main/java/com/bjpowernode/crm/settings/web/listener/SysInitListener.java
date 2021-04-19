package com.bjpowernode.crm.settings.web.listener;

import com.bjpowernode.crm.settings.domain.DicValue;
import com.bjpowernode.crm.settings.service.DicValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 动力节点
 * 2021/3/31
 */
public class SysInitListener implements ServletContextListener {

//    @Autowired
//    private DicValueService dicValueService;


    @Override
    public void contextInitialized(ServletContextEvent event) {

        ServletContext application=event.getServletContext();

        DicValueService dicValueService=WebApplicationContextUtils.getWebApplicationContext(application).getBean(DicValueService.class);

        Map<String, List<DicValue>> map=dicValueService.getAll();
        //key=>字典类型
        Set<String> set= map.keySet();
        for(String key:set){
            application.setAttribute(key,map.get(key));
        }


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
