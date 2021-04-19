import java.util.*;
package day07;
public class Method03{

	public static void main(String[] args){
		
		/*Scanner sc = new Scanner(System.in);

		System.out.println("请输入一个整数：");
		int num = sc.nextInt();

		if(100 > num || num > 999){
			System.out.println("不是三位整数");
			return;
		}

		int gw = num % 10,sw = num / 10 % 10,bw = num / 100;
		int sum = gw * gw * gw + sw * sw * sw + bw * bw * bw;
		if(sum == num){
			System.out.println("是水仙花数");
		}else{
			System.out.println("不是水仙花数");
		}*/
	}

	public static Boolean isFlower(int num){
		

		if(100 > num || num > 999){
			
			return false;
		}

		int gw = num % 10,sw = num / 10 % 10,bw = num / 100;
		int sum = gw * gw * gw + sw * sw * sw + bw * bw * bw;
		if(sum == num){
			return true;
		}
		return false;
	}

	
}