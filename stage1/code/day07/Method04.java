public class Method04{

	public static void main(String[] args){
		
		//System.out.println(judge());
		print1();
	}

	/**
	*	123 > 0 return 1;< 0 -1 ;否则得到0
	*/
	/*public static int judge(){
		int num = 123;
		//return num > 0 ? 1 : (num == 0 ? 0 : -1);
		if(num > 0){
			return 1;
		}else if(num < 0){
			return -1;
		}
		return 0;
	}*/

	/**
	*		100 98 96 94 ---- 0 
	*/
	public static void print(){
		for(int i = 100;i >= 0;i -= 2){
			System.out.println(i);
		}
	} 

	/**
	*	a --- z 的每个字符
	*/
	public static void print1(){
		for(int x = 97;x <= 122;x ++){
			char y = (char)x;
			System.out.println(y);
		}
	}

	

}