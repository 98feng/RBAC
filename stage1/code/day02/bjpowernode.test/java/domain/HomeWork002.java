package domain;


public class HomeWork002 {
    private String goodsName;
    private String goodsPrice;
    private String goodsNum;

    public HomeWork002(String goodsName, String goodsPrice, String goodsNum) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsNum = goodsNum;
    }


    @Override
    public String toString() {
        return goodsName + "       " +
                goodsPrice + "       " +
                goodsNum;
    }

    public static void main(String[] args) {
        HomeWork002 hw1 = new HomeWork002("电脑", "5700", "1");
        HomeWork002 hw2 = new HomeWork002("手机", "3290", "2");
        System.out.println("商品名称" + "  商品单价" + "  商品数量");
        System.out.println(hw1);
        System.out.println(hw2);
    }

}
