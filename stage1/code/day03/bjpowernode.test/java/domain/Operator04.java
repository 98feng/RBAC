package domain;

class Operator04
{
	public static void main(String[] args){
		//++a
		int a = 10;
		int b = 2*++a*2;//
		System.out.println(b);
		//a++
		int x = 3;
		int y = 2*x++*2;//12
		System.out.println(y);
		System.out.println(x);//4
	}
}