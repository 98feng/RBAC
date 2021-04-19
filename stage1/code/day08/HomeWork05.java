public class HomeWork05{

	public static void main(String[] args){
		print();

		print1();

		method();

		method01();
	}
	/**
	*	5.输出Z---A中所有的字符
	*/
	public static void print(){
		for (char x = 'Z';x >= 'A';x --){
			System.out.println(x);
		}
	}

	public static void print1(){
		for (int x = 90;x >= 65;x --){
			char y = (char)x;
			System.out.println(y);
		}
	}

	public static void method(){
		for(double x = 12.1;x <= 13.1;x += 0.1){
			System.out.println(x);
		}
	}

	public static void method01(){
		for(Integer x = 0;x <= 10;x ++){
			System.out.println(x);
		}
	}
}