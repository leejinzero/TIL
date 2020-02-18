import java.util.Scanner;

public class BJ_2503_숫자야구 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] score = new String[N];
		int[] strike = new int[N];
		int[] ball = new int[N];
		int prob =0;
		
		for (int i = 0; i < N; i++) {
			score[i]=sc.next();
			strike[i]=sc.nextInt();
			ball[i]=sc.nextInt();
		}
		
		
here:	for (int i = 123; i <= 987; i++) {
			String test = i+"";
			int strikeCnt=0, ballCnt=0;
			if(test.charAt(0)==test.charAt(1) || test.charAt(2)==test.charAt(1) ||test.charAt(0)==test.charAt(2)) continue;
			else if  (test.charAt(2)=='0'|| test.charAt(1)=='0') continue; 
			
			for (int j = 0; j < N; j++) {
				strikeCnt=0; ballCnt=0;
				String score1 = score[j];
				for (int k = 0; k < 3; k++) {
					for (int k2 = 0; k2 < 3; k2++) {
						if(score1.charAt(k)==test.charAt(k2) && (k==k2)) strikeCnt++;
						if(score1.charAt(k)==test.charAt(k2) && (k!=k2)) ballCnt++;
					}
				}
				if(strike[j]!=strikeCnt || ball[j]!= ballCnt) continue here;
			}
			prob++;
		}
		
		System.out.println(prob);

	}

}
