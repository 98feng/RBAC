import java.util.*;
public class Method01{
	public static void main(String[] args){
		
		/*
		输入的数
		*/
		int num;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		for (;;){
			System.out.println("请输入一个数：");
			num = sc.nextInt();

			if(num == 0) {
				System.out.println(sum);
				break;
			}
			sum += num;
		}
		
	}
}