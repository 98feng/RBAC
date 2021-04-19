public class HomeWork04{
	public static void main(String[] args){
		System.out.println(judge());
	}

	/**
	*	
	*	4.根据输入的年龄(比如：23)，输出是老年、中年、青年还是少年
	*/

	public static String judge(){
		int age = 23;
		
		if(age > 0 && age < 18){
			return "少年";
		}else if(18 <= age && age <= 23){
			return "青年";
		}else if(23 < age && age < 40){
			return "中年";
		}else if(40 <= age){
			return "老年";
		}
		return "年龄不合法！";

	}

}