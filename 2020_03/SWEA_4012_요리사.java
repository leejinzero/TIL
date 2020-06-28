import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
	static int N;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	
	private static void pick() {
		
		for (int i = 1; i < (1<<N)/2; i++) {
			ArrayList<Integer> subset1 = new ArrayList<>();
			ArrayList<Integer> subset2 = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				if((i&1<<j)>0) {
					subset1.add(j);
				}else {
					subset2.add(j);
				}
			}
			
			if(subset1.size()==N/2) {
				int sum1=0, sum2=0;
				
				for (int j = 0; j < subset1.size(); j++) {
					for (int j2 = 0; j2 < subset1.size(); j2++) {
						sum1+=map[subset1.get(j)][subset1.get(j2)];
					}
				}
				
				for (int j = 0; j < subset2.size(); j++) {
					for (int j2 = 0; j2 < subset2.size(); j2++) {
						sum2+=map[subset2.get(j)][subset2.get(j2)];
					}
				}
				
				min = Math.min(min, Math.abs(sum1-sum2));
			}
		}

		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#"+tc+" ");
			N = Integer.parseInt(bf.readLine());
			map = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				StringTokenizer tks = new StringTokenizer(bf.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(tks.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			pick();
			sb.append(min).append("\n");
		}
		
		System.out.println(sb);

	}

}
