import java.util.*;
public class Method02{

	/**
	*	输出一个范围内的所有偶数
	*/
	public static void print(int a,int b){
			for(int i = a;i <= b;i ++){
				if(i % 2 == 0)
				System.out.println(i);
			}

	}

	/**
	*	判断一个数是否是4位的正数
	*/
	public static String judge01(double num){
		if(1000 <= num && num < 10000){
			return num + "是4位正数";
		}
		return num + "不是4位正数";
	}

	/**
	*	是否是9的倍数
	*/
	public static String judge(double num){

		return num % 9 == 0 ? num + "是9的倍数" : num + "不是9的倍数";
	}
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		/*System.out.println("请输入一个数：");

		double num = sc.nextDouble();*/

		//System.out.println(judge(num));

		System.out.println("请输入从第一个开始的偶数：");
		int a = sc.nextInt();

		System.out.println("请输入最后结束的数：");
		int b = sc.nextInt();

		System.out.println("===================");

		print(a,b);
	}
}