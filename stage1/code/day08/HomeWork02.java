public class HomeWork02{
	public static void main(String[] args){
		 System.out.println(judge());
	}

	public static String judge(){
		double score = 98;
		if(score > 100 || score < 0){
			return "成绩不合法";
		}
		if(score >= 80 && score <= 100){
			return "A";

		}else if(score < 80 && score >= 60){
			return "B";
		}
		return "C";
	}
}