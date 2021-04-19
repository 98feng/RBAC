package domain;

class Operator03
{
	public static void main(String[] args){
		
		//计算123各个位之和
		int  a = 21474;

		//获取变量a中各个位，建议：先从一个正整数的最后一位获取
		//获取个位
		int b = a % 10;
		//获取十位
		int c = a / 10 % 10;
		//获取百位
		int d = a / 100 % 10;

		//获取千位
		int e = a / 1000 % 10;
		//获取万位
		int f = a / 10000;
		int sum = b + c + d + e + f;

		System.out.println(a + "的各个位之和：" + sum);//18
	}
}