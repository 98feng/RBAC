package bjpowernode.demo03;

/**
 * @author feng
 * @date 2020/12/11
 * @Description
 */
public class Bus extends Vehicel {

    /**
     * 座位数
     */
    int bSeat;

    public Bus() {}

    public Bus(int bSeat) {
        this.bSeat = bSeat;
    }

    public Bus(String vBrand, String vId, int bSeat) {
        super(vBrand, vId);
        this.bSeat = bSeat;
    }

    /**
     * @param 租的天数
     * @return 总租金
     * @Description 计算总租金日租金 * 天数日租金根据车型得到，因此必须进行判断
     * @date 2020/12/11
     */
    @Override
    public double getSumRent(int days) {

        return bSeat <= 16 ? 400 * days : 600 * days;

    }
}
