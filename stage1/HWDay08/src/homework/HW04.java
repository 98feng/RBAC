package homework;

/**
 * @author feng
 * @date 2020/12/5
 * @Description
 */
public class HW04 {
    public static void main(String[] args) {
        print();
    }

    private static void print() {
        for (int i = 2000; i <= 2020 ; i++) {
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0){
                System.out.println(i);
            }

        }
    }
}
