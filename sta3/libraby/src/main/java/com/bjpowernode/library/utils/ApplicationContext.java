package com.bjpowernode.library.utils;

import com.bjpowernode.library.annotation.AuthoWrite;
import com.bjpowernode.library.annotation.Bean;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author feng
 * @date 2021/1/8
 * @Description
 */
@SuppressWarnings("unchecked")
public class ApplicationContext<E> {

    private static HashMap<Class, Object> beanFactory = new HashMap<>();
    private static String filePath;

    public ApplicationContext() {
    }

    //初始化容器
    @Deprecated
    public void initContext() {
        InputStream resource = ApplicationContext.class.getClassLoader()
                .getResourceAsStream("bean.properties");
        Properties properties = new Properties();
        try {
            properties.load(resource);
            Set<Object> keys = properties.keySet();
            for (Object key : keys) {
                beanFactory.put(Class.forName(key.toString()),
                        Class.forName(properties.getProperty(key.toString())).newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        assebleObject();
        for (Map.Entry<Class, Object> entry : beanFactory.entrySet()) {
            System.out.println("entry.getValue() = " + entry.getValue().toString());
        }
    }

    //获取容器的bean
    public E getBean(Class clazz) {
        return (E) beanFactory.get(clazz);
    }

    //加载全部的类的实例
    public static void initContextByAnnotation() {
        // 类的绝对路径,Objects.requireNonNull getFile()可能为空
        filePath = Objects.requireNonNull(ApplicationContext.class.getClassLoader().getResource("")).getFile();
        loadOne(new File(filePath));
        assebleObject();
    }

    /**
     * 给属性赋值
     */
    private static void assebleObject() {
        for (Map.Entry<Class, Object> entry : beanFactory.entrySet()) {
            Object obj = entry.getValue();
            Class<?> aClass = obj.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields) {
                AuthoWrite annotation = field.getAnnotation(AuthoWrite.class);
                //判断该属性上是否有AuthorWrite注解
                if (annotation != null) {
                    field.setAccessible(true);
                    try {
                        System.out.println("正在给【" + obj.getClass().getSimpleName() + "】属性【" + field.getName() + "】注入值【" + beanFactory.get(field.getType()).getClass().getSimpleName() + "】");
                        field.set(obj, beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }


    /**
     * 加载一个文件夹的类
     *
     * @param fileParent
     */
    private static void loadOne(File fileParent) {
        if (fileParent.isDirectory()) {
            File[] childrenFiles = fileParent.listFiles();
            if (childrenFiles == null || childrenFiles.length == 0) {
                return;
            }
            for (File child : childrenFiles) {
                if (child.isDirectory()) {
                    //递归判断是否是一个文件夹
                    loadOne(child);
                } else {
                    //通过文件路径转变成全类名,第一步把绝对路径部分去掉
                    String pathWithClass = child.getAbsolutePath().substring(filePath.length() - 1);
                    if (pathWithClass.contains(".class")) {
                        //去掉.class后缀，并且把 \ 替换成 .
                        String fullName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");
                        try {
                            Class<?> aClass = Class.forName(fullName);

                            //把非接口的类实例化放在map中
                            if (!aClass.isInterface()) {
                                Bean annotation = aClass.getAnnotation(Bean.class);
                                if (annotation != null) {
                                    Object instance = aClass.newInstance();
                                    //判断一下该类有没有接口
                                    if (aClass.getInterfaces().length > 0) {
                                        //如果该类有接口把第一个接口的class当成key，实例对象当成value
                                        beanFactory.put(aClass.getInterfaces()[0], instance);
                                        System.out.println("接口：" + aClass.getInterfaces()[0].getSimpleName() + " 接口的实例对象：" + instance);
                                    } else {
                                        //如果该类没有接口把自己的class当成key，实例对象当成value
                                        beanFactory.put(aClass, instance);
                                        System.out.println("被实例化的对象：" + aClass.getSimpleName() + " 实例对象：" + instance);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

