import java.util.*;

public class If04{
	
	/**
	*	判断一个数是奇数还是偶数
	*/
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数：");
		double num = sc.nextDouble();
	
	/*	if(num > 0){
			
			if(!(num % 2 == 0)){
				System.out.println("是奇数");			
			}else{
				System.out.println("是偶数");
			}

		}else{
			System.out.println(num + "既不是奇数也不是偶数");
		}*/

		//判断一个数是否是三位的正数，使用逻辑非
		if(!(100 <= num && num < 1000)){
			System.out.println(num + "不是三位正数");
		}else{
			System.out.println(num + "是三位正数");
		}
	}
}