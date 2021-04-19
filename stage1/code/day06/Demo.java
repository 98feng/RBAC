public class Demo{
	public static void main(String[] args){
		String s = "*";
		/*循环输出***********
		*         ***********
				  ***********
				  ***********
			分析：知道循环40次，优先使用for
		*/
		int i = 1;
		for (;i <= 40;){
			System.out.print(s);
			if(i % 10 == 0) System.out.println();
		}
	}
}