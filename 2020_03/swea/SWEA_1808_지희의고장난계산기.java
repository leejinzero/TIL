package swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1808_지희의고장난계산기 {
	static boolean[] numRate;
	static int min;
	static int target;
	static int[] dp;
	
	private static int solve(int target) {
		if(dp[target]!=0) return dp[target];
		
		dp[target] =count(target);
		
		for (int i = 1; i <=(int)Math.sqrt(target); i++) {
			if(target%i==0) {
				int n1 = solve(i);
				int n2 = solve(target/i);
				int decide = n1==Integer.MAX_VALUE || n2 ==Integer.MAX_VALUE ? Integer.MAX_VALUE: n1+n2+1;

				dp[target] = Math.min(dp[target],decide);	
			}
		}		
		return dp[target];
	}
	
	private static int count(int num) {
		int cnt = 0;
		
		while(num>0) {
			if(numRate[num%10]) {
				cnt++;
				num/=10;
			}
			else return Integer.MAX_VALUE;
		}
	
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer tks = new StringTokenizer(bf.readLine());

			numRate = new boolean[10];
			for (int i = 0; i < 10; i++) {
				numRate[i] = Integer.parseInt(tks.nextToken()) == 1 ? true : false;
			}
			target = Integer.parseInt(bf.readLine().trim());
			
			dp = new int[target+10];
			
			for (int i = 0; i < 10; i++) {
				if(numRate[i]) {
					dp[i]=1;
				}
			}
			
			int result = solve(target);
			if(result == Integer.MAX_VALUE) {
				result = -2;
			}
			sb.append("#" + tc + " " + (result+1) + "\n");
		}
		System.out.println(sb);
	}
}
