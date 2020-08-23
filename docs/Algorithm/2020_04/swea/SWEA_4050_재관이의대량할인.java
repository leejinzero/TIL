package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4050_재관이의대량할인 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(bf.readLine());
			
			StringTokenizer tks = new StringTokenizer(bf.readLine());
			int[] list = new int[N];
			
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(tks.nextToken());
			}
			
			Arrays.sort(list);
			
			int stand = 0;
			int min = 0;
			
			for (int i = N-1; i>=0; i--) {
				stand++;
				if(stand==3) {
					stand=0;
					continue;
				}
				min+=list[i];
			}
		
			sb.append(min).append("\n");
			
		}
		
		System.out.println(sb);

	}

}
