import java.util.*;
public class Test01{
	
		/**
		*		练习一：根据输入的星期得到每天干的事
		*		星期一-----> 星期六 学习
		*		星期日------> 休息
		*/
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
//		System.out.println("请输入一个数字表示星期几（一 ---->日）：");


		//键盘接收字符时，先接收字符串类型的值,比如abc，然后在字符串中得知获取滴0个下标的值a,我们是用charAt(0);
		//
//		char week = sc.next().charAt(0);
		//根据输入的值进行判断
		/*switch(week){
			case '一':
			case '二':
			case '三':
			case '四':
			case '五':
			case '六':
				System.out.println("学习");
				break;
			case '日':
				System.out.println("休息");
				break;
		}*/


		/*
		if('日' == week){
			System.out.println("休息");
		}else{
			System.out.println("学习");
		}
*/

		System.out.println("请输入星期（数字1 ----> 7）：");
		int week = sc.nextInt();
		if(1 <= week && week <= 7){

			if(week == 7){
				System.out.println("休息");
			}else{
				System.out.println("学习");
			}

		}else{
			System.out.println("请输入合法的星期");
		}


	}
}