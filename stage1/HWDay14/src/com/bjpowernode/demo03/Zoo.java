package com.bjpowernode.demo03;

/**
 * @author feng
 * @date 2020/12/12
 * @Description 动物园
 */
public class Zoo {

    private Zoo(){}

    private static Zoo instance = null;

    private static ThreadLocal<Zoo> t = new ThreadLocal<>();

    public static Zoo getInstance(){
        instance = t.get();
        if (instance == null) {
            instance = new Zoo();
            t.set(instance);
        }
        return instance;
    }

    public static void myClose(Zoo zoo){

        if (zoo != null){
            t.remove();
        }
    }

    public void getAnimal(Animal animal){
        System.out.println(animal);
        animal.shout();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("等待回收....." + this);
    }
}
