package domain;


public class HomeWork003 {
    public static void main(String[] args) {

        String str = "*";
        //顶部空格
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
        }
        //顶部*
        for (int i = 0; i < 12; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.print("  ");

        System.out.print("*");
        for (int j = 0; j < 10; j++) {
            System.out.print(" ");
        }
        System.out.print("*");
        System.out.println();

        System.out.print(" ");
        System.out.print("*");
        for (int j = 0; j < 10; j++) {
            System.out.print(" ");
        }
        System.out.print("*");
        System.out.println();



        //底部*
        for (int i = 0; i < 12; i++) {
            System.out.print("*");
        }
    }
}
