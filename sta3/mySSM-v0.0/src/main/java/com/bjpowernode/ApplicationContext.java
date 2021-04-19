package com.bjpowernode;


import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author feng
 * @date 2021/1/8
 * @Description
 */
@SuppressWarnings("unchecked")
public class ApplicationContext<E> {

    private static HashMap<Class<?>, Object> beanFactory = new HashMap<>();
    private static String filePath;

    public ApplicationContext() {
    }

    //获取容器的bean
    public E getBean(Class<?> clazz) {
        return (E) beanFactory.get(clazz);
    }

    //加载全部的类的实例
    public static void initContextByAnnotation() {
        // 获取资源文件路径,Objects.requireNonNull getFile()可能为空
        filePath = Objects.requireNonNull(ApplicationContext.class.getClassLoader().getResource("")).getFile();
        loadOne(new File(filePath));
        assebleObject();
    }

    /*单纯的向map中存值没必要把class加入集合在遍历集合了*/
    /*private static void loadOne(File fileParent) {
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
                                        System.out.println("接口：" + aClass.getInterfaces()[0] + " 接口的实例对象：" + instance);
                                    } else {
                                        //如果该类没有接口把自己的class当成key，实例对象当成value
                                        beanFactory.put(aClass, instance);
                                        System.out.println("被实例化的对象：" + aClass + " 实例对象：" + instance);
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
    }*/
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
                                        System.out.println("接口：" + aClass.getInterfaces()[0] + " 接口的实例对象：" + instance);
                                    } else {
                                        //如果该类没有接口把自己的class当成key，实例对象当成value
                                        beanFactory.put(aClass, instance);
                                        System.out.println("被实例化的对象：" + aClass + " 实例对象：" + instance);
                                    }
                                }
                                //为接口创建一个实现类对象
                            }/*else if (aClass.isInterface()){
                                Method[] methods = aClass.getDeclaredMethods();
                                for (Method method : methods) {
                                    method.getAnno
                                }
                                select annotation = aClass.getAnnotation()
                                if (annotation != null) {

                                }
                            }*/
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * 给属性赋值
     */
    private static void assebleObject() {
        for (Map.Entry<Class<?>, Object> entry : beanFactory.entrySet()) {
            Object obj = entry.getValue();
            Class<?> aClass = obj.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields) {
                AutoWrite annotation = field.getAnnotation(AutoWrite.class);
                //判断该属性上是否有AutoWrite注解
                if (annotation != null) {
                    field.setAccessible(true);
                    try {
                        field.set(obj, beanFactory.get(field.getType()));
                        System.out.println("给(" + obj.getClass().getSimpleName() + ")属性(" + field.getName() + ")注入值(" + beanFactory.get(field.getType()).getClass().getSimpleName() + ")");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    /**
     * 资源文件路径下的所有类(不包含jar包）
     *
     * @param fileParent
     * */
    /*static List<Class<?>> list = new ArrayList<>();
    private static List<Class<?>> loadOne(File fileParent) {
        if (fileParent.isDirectory()) {
            File[] childrenFiles = fileParent.listFiles();
            if (childrenFiles == null || childrenFiles.length == 0) {
                return null;
            }
            for (File child : childrenFiles) {
                if (child.isDirectory()) {
                    //判断是否是一个文件夹
                    loadOne(child);
                } else {
                    //通过文件路径转变成全类名,第一步把绝对路径部分去掉
                    String pathWithClass = child.getAbsolutePath().substring(filePath.length() - 1);
                    if (pathWithClass.contains(".class")) {
                        //去掉.class后缀，并且把 \ 替换成 .
                        String fullName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");
                        try {
                            Class<?> aClass = Class.forName(fullName);
                            list.add(aClass);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return list;
    }
*/

    /**
     * 把非接口的类实例化放在map中
     */
    /*private static void setClass(File fileParent) {

        List<Class<?>> list = loadOne(fileParent);
        assert list != null;
        for (Class<?> aClass : list) {
            if (!aClass.isInterface()) {
                Bean annotation = aClass.getAnnotation(Bean.class);
                if (annotation != null) {
                    Object instance = null;
                    try {
                        instance = aClass.newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //判断一下该类有没有接口
                    if (aClass.getInterfaces().length > 0) {
                        //如果该类有接口把第一个接口的class当成key，实例对象当成value
                        beanFactory.put(aClass.getInterfaces()[0], instance);
                        System.out.println("接口：" + aClass.getInterfaces()[0] + " 接口的实例对象：" + instance);
                    } else {
                        //如果该类没有接口把自己的class当成key，实例对象当成value
                        beanFactory.put(aClass, instance);
                        System.out.println("被实例化的对象：" + aClass + " 实例对象：" + instance);
                    }
                }
            }
        }
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
    }*/


}

