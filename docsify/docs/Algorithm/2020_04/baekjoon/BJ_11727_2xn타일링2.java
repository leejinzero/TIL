package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 점화식, DP(상향식)
public class BJ_11727_2xn타일링2 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		int[] memo = new int[n+2];
		memo[1]=1;
		memo[2]=3;
		
		for (int i = 3; i <= n; i++) {
			memo[i] = (memo[i-1]+2*memo[i-2]%10007)%10007;
		}

		System.out.println(memo[n]);
	}
}
