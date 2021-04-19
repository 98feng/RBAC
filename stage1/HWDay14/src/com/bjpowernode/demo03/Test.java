package com.bjpowernode.demo03;

/**
 * @author feng
 * @date 2020/12/12
 * @Description
 */
public class Test {


    public static void main(String[] args) {
        Animal animal = new Lion(null, 7);
        for (int i = 0; i < 100; i++) {
            animal = new Lion(null, 8);

            Zoo zoo = Zoo.getInstance();

            if (animal instanceof Lion) {
                zoo.getAnimal(animal);
            } else if (animal instanceof Tiger) {
                zoo.getAnimal(animal);
            } else {
                zoo.getAnimal(animal);
            }
            System.out.println(i + "=================");
//            Zoo.myClose(zoo);
            System.gc();
        }
    }
}
