package homework4;

/**
 * @author feng
 * @date 2020/12/5
 * @Description
 */
public class HW01 {
    public static void main(String[] args) {
        print1();
    }
    /**
     * @Description 100 -- 200 能被19整除的数
     * @author feng
     * @date 2020/12/5
     * @param
     * @return
     *
     */
    private static void print1() {
        for (int i = 100; i <= 200; i++) {
            if (i % 19 == 0) {
                System.out.println(i);
            }

        }
    }
}
