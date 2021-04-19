import java.util.*;
public class If02{

	public static void main(String[] args){
		//判断一个年份是否是闰年
		Scanner sc = new Scanner(System.in);
		System.out.println("q请输入一个年份：");
		int year = sc.nextInt();

		//使用if嵌套完成
		if(year % 4 == 0 && year % 100 != 0){
			System.out.println(year + "是闰年");
		}else{
			if(year % 400 == 0){
				System.out.println(year + "是闰年");
			}else{
				System.out.println(year + "不是闰年");
			}
		}

	}
}