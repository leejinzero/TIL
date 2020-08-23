package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6719_성수의프로그래밍강좌 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer tks = new StringTokenizer(bf.readLine());
			
			int N = Integer.parseInt(tks.nextToken());
			int K = Integer.parseInt(tks.nextToken());
			
			tks = new StringTokenizer(bf.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(tks.nextToken());
			}
			
			Arrays.sort(arr);
			
			double tem = 0.0;
			
			for (int i = K-1; i>=0; i--) {
				tem = (double)(tem+arr[N-1-i])/2;
			}
			sb.append(tem).append("\n");
		}
		
		System.out.println(sb);

	}

}
