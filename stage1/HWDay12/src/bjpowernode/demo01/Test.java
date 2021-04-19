package bjpowernode.demo01;

/**
 * @author feng
 * @date 2020/12/10
 * @Description
 */
public class Test {

    /**
     * @Description 判断
     * @date 2020/12/11
     * @param num
     * @return string
     *
     */
    public static String judge(int num){
        return num < 10 ? "0" + num : num + "";
    }
    public static void main(String[] args) {

        Date date = new Date();
        date.setYear(2020);
        date.setMonth(2);
        date.setDay(3);

        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDay();
        System.out.println(year + "年" + judge(month) + "月" + judge(day) + "日");

    }
}
