package com.bjpowernode.aspectj.aop.aspect;

import com.bjpowernode.ioc.domain.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author feng
 * @date 2021/3/6
 * @Description
 */
@Aspect
public class MyAspect {
    @Before(value = "execution (* com.bjpowernode.aspectj.aop.impl.UserServiceImpl.doSome(..))")
    public void before() {
        System.out.println("前置通知");
    }

    @Around(value = "execution (* com.bjpowernode.aspectj.aop.impl.UserServiceImpl.doOther(..))")
    public Object myAround(ProceedingJoinPoint pjp) {
        Object obj = null;
        String name = "";
        Object[] args = pjp.getArgs();
        if (args != null && args.length > 1) {
            name = (String) args[0];
            if ("name".equals(name)) {
                System.out.println("前置通知");
                try {
                    obj = pjp.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                System.out.println("后置通知");
            } else {
                System.out.println("业务不符");
            }
        }


        return obj;
    }

    @AfterReturning(value = "execution (* com.bjpowernode.aspectj.aop.impl.UserServiceImpl.doFirst(..))", returning = "stu")
    public void after(Student stu) {
        if (stu != null) {

            /*String str = (String) obj;
            obj = str.toUpperCase();*/
//            Student stu = (Student)obj;

            stu.setAge(12);
            stu.setName("name");

            //虽然AfterReturning增强处理可以访问到方法的返回值，但它不可以改变目标方法的返回值。
        }

        System.out.println("后置通知" + stu);
    }
}
