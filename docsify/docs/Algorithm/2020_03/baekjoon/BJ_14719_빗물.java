package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14719_빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tks = new StringTokenizer(bf.readLine());
		
		int R = Integer.parseInt(tks.nextToken());
		int C = Integer.parseInt(tks.nextToken());
		
		int[][] map = new int[R][C];
		
		tks = new StringTokenizer(bf.readLine());
		for (int i = 0; i < C; i++) {
			int r = Integer.parseInt(tks.nextToken());
			for (int j = R-1; j > R-1-r; j--) {
				map[j][i] = 1;
			}
		}

		int total = 0;
		
		for (int i = R-1; i >=0; i--) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] >0) {
					j++;
					int tem = 0;
					while(j<C &&map[i][j]==0) {
						tem++;
						j++;
					}
					
					if(j<C && map[i][j]==1) {
						total+=tem;
						j--;
					}
				}
			}
		}
		
		
		System.out.println(total);
	}

}
