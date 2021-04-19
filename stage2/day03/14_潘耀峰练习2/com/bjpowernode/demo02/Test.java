package com.bjpowernode.demo02;

/**
 * @author feng
 * @date 2020/12/17
 * @Description
 */
public class Test {

    public static void main(String[] args) {
        /*Bird bird = new BlackBird();
        Util util = new Util(bird);
        blackBird.flay();*/

        Util util = new Util();
        util.shot(new BlackBird());
        util.shot(new RedBird());
        util.shot(new BlueBird());

        util.shot(new Flyable() {
            @Override
            public void flay() {
                System.out.println("bianbainabain");
            }
        });
    }
}
