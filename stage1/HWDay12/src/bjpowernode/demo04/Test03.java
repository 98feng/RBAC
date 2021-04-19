package bjpowernode.demo04;

/**
 * @author feng
 * @date 2020/12/11
 * @Description
 */
public class Test03 {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        Double aDouble = 0.0;
        for (int i = 0; i < 20; i++) {

            sb.append("2");
            String str = sb.toString();
            aDouble = Double.valueOf(str);
            System.out.printf("%.0f",aDouble);
            System.out.print("\t");

            aDouble += aDouble;

        }

        System.out.println(aDouble);
    }
}
