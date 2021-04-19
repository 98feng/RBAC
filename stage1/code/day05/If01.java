import java.util.*;
public class If01{
		public static void main(String[] args){
			/**
				两位数奇数偶数
			
			*/
			Scanner sc = new Scanner(System.in);
			System.out.print("请输入一个两位正整数：");
			double num = sc.nextInt();

			if(10 <= num && num <= 99){

				if(num % 2 == 0){
					System.out.println(num + "偶数");
				}else{
					System.out.println(num + "奇数");
				}

			}else{
				System.out.println(num + "不是两位正整数");
			}
		}
}
