package bjpowernode.demo01;

/**
 * @author feng
 * @date 2020/12/10
 * @Description 日期类
 */
public class Date {

    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 0) {

            this.year = year;
        }else{
            this.year = 2020;
        }

    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month > 0 && month < 13 ? month : 11;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 0 && day <= 31){
                    this.day = day;
                }else {
                    this.day = 11;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 0 && day <= 30){
                    this.day = day;
                }else{
                    this.day = 11;
                }
                break;
            default:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
                    if (day > 0 && day <= 29){
                        this.day = day;
                    }else{
                        this.day = 11;
                    }
                }else {
                    if (day > 0 && day <= 28){
                        this.day = day;
                    }else {
                        this.day = 11;
                    }
                }
                break;
        }
    }


}
