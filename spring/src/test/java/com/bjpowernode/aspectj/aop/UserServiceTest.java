package com.bjpowernode.aspectj.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author feng
 * @date 2021/3/6
 * @Description
 */
public class UserServiceTest {


    @Test
    public void doSome() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        userService.doSome();
        System.out.println(":=====================");

        String name = userService.doOther("name1", 12);
        System.out.println(name);
        System.out.println("=========================");
        Object o = userService.doFirst("123", 12);
        System.out.println(o);
    }
}
