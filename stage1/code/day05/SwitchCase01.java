import java.util.*;
public class SwitchCase01{

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入张三考试名次：");
		String a = sc.next();

		//第二种方法：使用switch case选择结构switch switch switch switch switch
		switch(a){
			case "第一名":
				System.out.println("奖励100W");
				break;//表示中断，结束挡墙switch case
			
			case "第二名":
				System.out.println("奖励50w");
				break;
			
			case "第三名":
				System.out.println("奖励20W");
				break;
			default:
				System.out.println("对不起没有任何奖励！");
				break;
		}
	}
}
