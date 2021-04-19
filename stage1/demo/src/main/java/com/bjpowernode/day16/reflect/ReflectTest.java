package com.bjpowernode.day16.reflect;

import java.lang.reflect.*;
import java.util.ResourceBundle;

/**
 * @author feng
 * @date 2021/1/8
 * @Description
 */
public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException {
        StringBuilder sb = new StringBuilder();
        //读取配置文件获取完整类名
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
        String classname = resourceBundle.getString("classname");
        System.out.println(classname);
        //根据完整类名创建Class对象
        Class<?> aClass = Class.forName(classname);

        //反射修饰符modifile
        int modifiers = aClass.getModifiers();
        System.out.println(modifiers);//17
        //将整数转换成字符串
        String string = Modifier.toString(modifiers);
        System.out.println(string);

        //类名
        String name = aClass.getName();
        System.out.println(name);
        //简易类名
        String simpleName = aClass.getSimpleName();
        System.out.println(simpleName);

        //superClass
        Class<?> superclass = aClass.getSuperclass();
        //父类的简易类名
        String simpleName1 = superclass.getSimpleName();
        System.out.println(simpleName1);

        //获取接口
        Class<?>[] interfaces = aClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.print(anInterface.getSimpleName());
        }


        //获取字段本类所有的字段“
        //getFields或去public修饰字段，包括从父类继承的字段
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
        }

        //本类中方法
//        Method[] declaredMethods = aClass.getDeclaredMethods();
        //获取锁有的public修饰的包括父类继承的方法
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
//            System.out.println(method);

            //方法修饰符
            modifiers = method.getModifiers();
            sb.append(Modifier.toString(modifiers)).append(" ");
            //返回值类型
            Class<?> returnType = method.getReturnType();
            sb.append(returnType.getSimpleName()).append(" ");
            //方法名
            sb.append(method.getName());
            //参数param的类型
            Class<?>[] parametersTypes = method.getParameterTypes();
            sb.append("(");
            for (int i = 0; i < parametersTypes.length; i++) {
                String simpleName2 = parametersTypes[i].getSimpleName();
                if (i != 0){
                    sb.append(",");
                }
                sb.append(simpleName2);
            }
            sb.append(");\n");
        }

        System.out.println(sb);

        //构造方法
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

    }
}
