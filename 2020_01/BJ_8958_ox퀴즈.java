import java.util.Scanner;

public class BJ_8958_ox퀴즈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		
		for (int i = 0; i <cnt; i++) {
			String str = sc.next();
			int score=0;
			int ocount=0;
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j)=='O') {
					ocount++;
					score+=ocount;
				}else {
					ocount=0;
				}
			}
			System.out.println(score);
			
		}

	}

}
