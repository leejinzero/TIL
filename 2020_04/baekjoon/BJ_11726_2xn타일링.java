package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//피보나치 수열 - 점화식, DP(상향식)
public class BJ_11726_2xn타일링 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
    //n+1사이즈로하면 n=1일때 런타임에러..
		int[] memo = new int[n+2];
		memo[1]=1;
		memo[2]=2;
		
		for (int i = 3; i <= n; i++) {
			memo[i] = (memo[i-1]+memo[i-2])%10007;
		}

		System.out.println(memo[n]);
	}
}
