package com.bjpowernode;

import static org.junit.Assert.assertTrue;

import com.bjpowernode.ioc.domain01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testStudent(){
        Student student = new Student();
        System.out.println("student = " + student);
    }

    @Test
    public void testStudent1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }
}
