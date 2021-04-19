public class DoWhile{
	public static void main(String[] args){
		//5 --- 10中的每个数
		int i = 30;
		do{
			System.out.println(i);
			i ++;
		}while(i <= 50);
		System.out.println("=====================");

		//输出600 ----- 700 中的每个奇数
		i = 601;
		do{
			System.out.println(i);
			i += 2;
		}while(i <= 700);
		System.out.println("==================");
		//输出1234--------5678能被345整除的数
		i = 1234;
		do{
			if(i % 345 == 0){
				System.out.println(i);
			}
			i ++;
		}while(i <= 5678);
	}
}