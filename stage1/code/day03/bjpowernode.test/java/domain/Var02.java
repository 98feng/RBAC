package domain;

class Var02
{
	public static void main(String[] args){
		
		/*
		练习1：将以下数据存放在变量中，
		张三 男 1.78 76.4 北京市
		*/
		//第一步：声明变量
		String a;
		String b;
		double c;
		double d;
		String e;
		//第二步：赋值
		a = "张三";//注意在java中，字符串的值必须用英文双引号引起来
		b = "男";
		c = 1.780;
		d = 76.4;
		e = "北京市";
		//第三步：使用
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);

		/*
		练习2：将以下数据存放到变量中，并输出变量中的值
		java基础  3楼2教室 第三课 11.26 3
		*/
		String clazz = "java基础";
		String addr = "3楼2教室";
		String progress = "第三课";
		double date = 11.26;
		int  temp = 3;
		System.out.println(clazz);
		System.out.println(addr);
		System.out.println(progress);
		System.out.println(date);
		System.out.println(temp);
		System.out.println("===========================");
		System.out.println();
		//输出：clazz = Java基础
		System.out.println("clazz = " + clazz);
		System.out.println("addr =" + addr);
		System.out.println("progress = " + progress);
		System.out.println("date = " + date);
		System.out.println("temp = " + temp);
		System.out.println("===========================");
		System.out.println();

		/*
		北京市 深圳 上海 广州 12000 2021.5 11.24
		*/
		String school1 = "北京市";
		String school2 = "深圳";
		String school3 = "上海";
		String school4 = "广州";
		int wages = 12000;
		String startDate = "11.24";
		String endDate = "2021.5";

		System.out.println("school1 = " + school1);
		System.out.println("school2 = " + school2);
		System.out.println("school3 = " + school3);
		System.out.println("school4 = " + school4);
		System.out.println("wages = " + wages);
		System.out.println("startDate = " + startDate);
		System.out.println("endDate = " + endDate);
		System.out.println("===========================");
		System.out.println();
	}
}