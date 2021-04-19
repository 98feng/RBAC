import java.util.*;
/**
*	判断一个月份是哪个季节
*
*/
public class If03{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个月份：");
		double month = sc.nextInt();
		//先判断月份是否合法
		if(month >= 1 && month <= 12){
			//在判断季节	
			if(month >= 1 && month <= 3){
				System.out.println(month + "是春季");
			}else if(month  >= 4 && month <= 6){
				System.out.println(month + "是夏季");
			}else if(month >= 7 && month <= 9){
				System.out.println(month + "是秋季");
			}else{
				System.out.println(month + "是冬季");
			}

		}else{
			System.out.println("月份输入有误！");
		}
	}
}