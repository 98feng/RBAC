package bjpowernode.homework01;

/**
 * @author feng
 * @date 2020/12/8
 * @Description 出版社
 * 1.
 * 编写出版社类：
 * 属性：出版社编号，出版社名称，出版社地址
 * 定义：无参构造方法、有参构造方法
 * 方法：显示出版社的信息
 */
public class Press {

    String psNo;
    String psName;
    String psAddr;

    public Press() {
    }

    public Press(String psNo, String psName, String psAddr) {
        this.psNo = psNo;
        this.psName = psName;
        this.psAddr = psAddr;
    }

    @Override
    public String toString() {
        return "Press{" +
                "psNo='" + psNo + '\'' +
                ", psName='" + psName + '\'' +
                ", psAddr='" + psAddr + '\'' +
                '}';
    }
}
