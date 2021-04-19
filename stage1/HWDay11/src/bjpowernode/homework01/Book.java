package bjpowernode.homework01;

/**
 * @author feng
 * @date 2020/12/8
 * @Description 编写图书类： 	属性：编号，名称，单价，数量, 作者,出版社 	定义方法：显示图书的信息（编号，名称，单价，数量, 作者,出版社名称，出版社地址)
 */
public class Book {

    String bkNo;
    String bkName;
    String bkPrice;
    String bkNum;
    String bkAuthor;
    Press bkPress;

    public Book() {
    }

    public Book(String bkNo, String bkName, String bkPrice, String bkNum, String bkAuthor, Press bkPress) {
        this.bkNo = bkNo;
        this.bkName = bkName;
        this.bkPrice = bkPrice;
        this.bkNum = bkNum;
        this.bkAuthor = bkAuthor;
        this.bkPress = bkPress;
    }


    @Override
    public String toString() {
        return "Book{" +
                "bkNo='" + bkNo + '\'' +
                ", bkName='" + bkName + '\'' +
                ", bkPrice='" + bkPrice + '\'' +
                ", bkNum='" + bkNum + '\'' +
                ", bkAuthor='" + bkAuthor + '\'' +
                ", pressName'" + (bkPress  == null ? null : bkPress.psName)+ '\'' +
                ", pressAddr'" + (bkPress == null ? null : bkPress.psAddr) + '\'' +
                '}';
    }
}
