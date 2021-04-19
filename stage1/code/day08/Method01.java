import java.util.*;
public class Method01{


	/**
	*	计算两个数乘积
	*/
	public static int method(int a,int b){
		int c = a * b;
		return c;
	}

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入第一个值：");
		int num1 = sc.nextInt();
		System.out.println("请输入第二个值：");
		int num2 = sc.nextInt();
		System.out.println(num1 + " * " + num2 + " 乘积为" + method(num1,num2));

	}
}