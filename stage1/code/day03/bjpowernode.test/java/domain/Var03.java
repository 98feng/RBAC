package domain;

class Var03{
	public static void main(String[] args){
		/*
		北京市 深圳 上海 广州 12000 2021.5 11.24
		*/
		/*
		继续优化变量的操作步骤：
		当有多个变量，并且数据类型相同时，则就可以一次声明多个相同类型的变量，之间用英文逗号隔开
		语法格式：数据类型 变量名称1,变量名称2,变量名称3;
		*/
		//String aa,bb,cc,dd;//表示声明多个字符串类型的变量
		//System.out.println(aa);
		System.out.println();
		System.out.println("====================");
		
		String a = "北京市", b = "深圳", c = "上海", d = "广州";
		int e = 12000;
		double f = 2021.5,g = 11.24;
		//实现编写一条输出语句，并且在7行输出结果
		System.out.println("总部：" + a 
			+ "\n分校1：" + b + "\n分校2：" + c 
			+ "\n分校3：" + d + "\n薪资：" + e
			+ "\n毕业时间：" + f
			+ "\n开班时间：" + g);
	}
}