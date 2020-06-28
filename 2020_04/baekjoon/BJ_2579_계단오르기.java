package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2579_계단오르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		// 계단 점수 저장
		int[] stairs = new int[N+1];
		for (int i = 1; i<=N; i++) {
			stairs[i] = Integer.parseInt(bf.readLine());
		}
		
		// DP : 각 계단의 최고 점수 저장
		int[] memo = new int[N+1];
		
		// 케이스별 초기 값 저장
		if(N>=3) {
			memo[1]=stairs[1];
			memo[2]=stairs[1]+stairs[2];
			memo[3]=Math.max(stairs[1]+stairs[3],stairs[2]+stairs[3]);
		}else {
			if(N==1) {
				memo[1]=stairs[1];
			}else if(N==2) {
				memo[1]=stairs[1];
				memo[2]=stairs[1]+stairs[2];
			}
		}
		
		//연속 3번이 불가능하므로 2가지 케이스가 가능
		for (int i = 4; i <= N; i++) {
			int a = stairs[i]+stairs[i-1]+memo[i-3];
			int b = stairs[i]+memo[i-2];
			memo[i]=Math.max(a, b);
		}
		
		System.out.println(memo[N]);
	}

}
