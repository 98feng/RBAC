package main.java.day01.com.bjpowernode.homework;

/**
 * @author feng
 * @date 2020/12/17
 * @Description 练习3(选做)
 * 	把一个十进制整数转换为汉字数字
 * 		3456   叁仟肆佰伍拾陆圆
 *         10086  -> 壹万零仟零佰捌拾陆圆
 */
public class Test04 {

    public static void main(String[] args) {
        /*String str = "一,贰,弎,肆,伍,陆,柒,捌,玖,拾,百,千,万,亿";
        String[] str1 = str.split(",");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数：");
        String strNum = scanner.next();
        int[] ints = new int[strNum.length()];
        for (int i = 0; i < strNum.length(); i++) {
            for (int j = 0; j < str1; j++) {

            if(ints[i] == str
            }
        }*/
        System.out.println(formatInteger(123456));
    }
    public static String formatInteger(int num) {
        String[] units = {"","十","百","千","万","十万","百万","千万","亿","十亿","百亿","千亿","万亿" };
        char[] numArray = {'零','一','二','三','四','五','六','七','八','九'};

        char[] val = String.valueOf(num).toCharArray();
        int len = val.length;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {

            String m = val[i] + "";

            int n = Integer.valueOf(m);

            boolean isZero = n == 0;

            String unit = units[(len - 1) - i];

            if (isZero) {

                if ('0' == val[i - 1]) {

                    continue;

                } else {

                    sb.append(numArray[n]);

                }
            } else {

                sb.append(numArray[n]);

                sb.append(unit);

            }
        }

        String str = sb.toString();

        String substring = str.substring(str.length()-1, str.length());

        if(substring.equals("零")){
            str = str.substring(0, str.length()-1);
        }
        return str;
    }
}

