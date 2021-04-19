package domain;

/*
 * 1)编写Java程序，输出如下效果
 *
 * 2) 编写Java程序，输出如下效果
 */
public class HomeWork001 {
    private String name = "张三";
    private String age = "19";
    private String addr = "北京";
    private String description = "在动力节点学习java课程";//描述


    @Override
    public String toString() {
        return "我的名字叫'" + name + '\'' + "\n" +
                "今年'" + age +"岁" + '\'' + "\n" +
                "来自'" + addr + '\'' + "\n" +
                "'" + description + '\'';
    }

    public static void main(String[] args) {
        HomeWork001 hw = new HomeWork001();
        System.out.println(hw);
    }
}
