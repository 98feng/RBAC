package bjpowernode.homework01;

/**
 * @author feng
 * @date 2020/12/7
 * @Description
 * 1、
 * 班级类：
 * 属性：编号，名称，地址
 * 定义方法：显示班级的信息。
 * 测试类：
 * 1）创建班级对象 ，调用方法显示班级的信息
 * 2）创建班级对象 ，完成对所有属性赋值，调用方法显示班级的信息
 */
public class Class {

    private String cNo;
    private String cName;
    private String cAddr;

    public Class() {
    }

    public Class(String cNo, String cName, String cAddr) {
        this.cNo = cNo;
        this.cName = cName;
        this.cAddr = cAddr;
    }

    @Override
    public String toString() {
        return "Class{" +
                "cNo='" + cNo + '\'' +
                ", cName='" + cName + '\'' +
                ", cAddr='" + cAddr + '\'' +
                '}';
    }
}
