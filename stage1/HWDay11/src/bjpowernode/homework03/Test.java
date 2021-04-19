package bjpowernode.homework03;

/**
 * @author feng
 * @date 2020/12/8
 * @Description 3.输出如下效果的前20个数 1	1	2	3	5	8	13	......
 * 斐波那契数列
 */
public class Test {


    /**
     * O(1)
     */
    public static int fib2(int n) {
        double c = Math.sqrt(5);
        return (int) ((Math.pow((1 + c) / 2, n) - Math.pow((1 - c) / 2, n)) / c);
    }

    /**
     * O(n)
     *
     * @param n
     * @return
     */

    public static int fib(int n) {
        if (n <= 1) return n;

        int first = 0;
        int second = 1;
        while (n-- > 1) {
            second += first;
            first = second - first;
        }
        return second;
    }

    /**
     * O(2^n)
     *
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n <= 1) return n;
        return fib1(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        int num = 20;
        for (int i = 0; i < num; i++) {
            System.out.println(fib(i));
        }

    }


}
