public class Method02{

	public static void main(String[] args){
		
		/*chengJi();
		int c = Method02.chengJi();

		System.out.println(c);//144
		System.out.println(chengJi());//144*/
		System.out.println(judge());
		
	}
	
	



	/**
	*		判断123是否是三位正整数
	*/
	public static String judge(){
		int num = 123123;
		/*if(100 <= num && num < 1000){
			return num + "是三位正整数";	
		}else{
			return num + "不是三位正整数";
		}*/
		//return 100 <= num && num < 1000?num + "是三位正整数":num + "不是三位正整数";

		if(num % 2 == 0){
			return num + "是偶数";
		}
		return num + "是奇数";
	}
}