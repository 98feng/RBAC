import java.util.*;
import code.day07.*;

public class Method03{


	/**
	*	输出所有三位数的水仙花数
	*/
	public static void print(){
		for(int i = 100;i < 1000;i ++){
			boolean isFlag = Method03.isFlower(i);
			if(isFlag){
				System.out.println(i);
			}
		}
	}
		
	public static void mian(String[] args){
		
		
	}
}