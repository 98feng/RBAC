package bjpowernode.demo03;

/**
 * @author feng
 * @date 2020/12/10
 * @Description
 */
public class Book {

    private String bId;
    private String bName;
    private int bPrice;
    private int bNum;

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public int getbPrice() {
        return bPrice;
    }

    public void setbPrice(int bPrice) {
        if (bPrice > 0)
        this.bPrice = bPrice;
    }

    public int getbNum() {
        return bNum;
    }

    public void setbNum(int bNum) {
        if (bNum > 0)
        this.bNum = bNum;
    }
}
