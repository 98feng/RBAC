package com.bjpowernode.demo02;

/**
 * @author feng
 * @date 2020/12/12
 * @Description 主人
 */
public class Master {
    /*
    public void feed(Cat cat) {
    }

    public void feed(Dog dog) {
    }*/

    /**
     * @Description 喂养宠物
     * @param pet
     * @return
     * @date 2020/12/12
     */
    public void feed(Pet pet) {
        pet.eat();
    }
}
