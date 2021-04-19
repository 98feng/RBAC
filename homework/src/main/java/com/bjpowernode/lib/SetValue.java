package com.bjpowernode.lib;

import com.bjpowernode.dao.UserMapper;
import com.bjpowernode.service.UserService;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author feng
 * @date 2021/3/5
 * @Description
 */
@Deprecated
public class SetValue {
    /**
     * 初始化类数据
     *
     * @param cls
     * @return
     * @throws Exception
     */
    public static<E> E initClassInfo(Class<E> cls) {
        E bean = null;
        try {
            bean = ApplicationContext.getBean(UserService.class);
            Method[] methods = cls.getDeclaredMethods();
            Field[] fields = cls.getDeclaredFields();

            for (Field field : fields) {
                String fieldSetName = parSetName(field.getName());
                if (!checkSetMet(methods, fieldSetName)) {
                    continue;
                }
                Method fieldSetMet = cls.getMethod(fieldSetName,
                        field.getType());

                fieldSet(bean, fieldSetMet, field);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("initClassInfo调用异常");
        }
        return bean;
    }



    /**
     * 拼接在某属性的 set方法
     *
     * @param fieldName
     * @return String
     */
    private static String parSetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        int startIndex = 0;
        if (fieldName.charAt(0) == '_') {
            startIndex = 1;
        }
        return "set"
                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
                + fieldName.substring(startIndex + 1);
        //String methodName = "set" + filedName.substring(0,1).toUpperCase()+filedName.substring(1);

    }

    /**
     * 判断是否存在某属性的 set方法
     *
     * @param methods
     * @param fieldSetMet
     * @return boolean
     */
    private static boolean checkSetMet(Method[] methods, String fieldSetMet) {
        for (Method met : methods) {
            if (fieldSetMet.equals(met.getName())) {
//                System.out.println(fieldSetMet+" true");
                return true;
            }
        }
//        System.out.println(fieldSetMet+" false");
        return false;
    }


    /**
     * 调用某个set方法set数据
     *
     * @param bean
     * @param fieldSetMet
     * @param field
     * @throws Exception
     */
    private static void fieldSet(Object bean, Method fieldSetMet, Field field) throws Exception {
        Object value = ApplicationContext.getBean(UserMapper.class);
        fieldSetMet.invoke(bean,value);
    }
}
