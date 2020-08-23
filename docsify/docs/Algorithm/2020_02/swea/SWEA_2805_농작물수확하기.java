package swea;
import java.util.Scanner;

public class SWEA_2805_농작물수확하기{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			int answer=0;
			int N = sc.nextInt();
			int start = N/2+1;
			int end = N/2-1;
			int[][] map = new int[N][N];
			
			
			for (int j = 0; j < N; j++) {
				String str = sc.next();
				for (int j2 = 0; j2 < N; j2++) {
					map[j][j2]=str.substring(j2).charAt(0)-48;
				}
			}
			
			for (int j = 0; j < map.length; j++) {
				if(j <= N/2) {
					start--;
					end++;
					for (int k= start; k <= end; k++) {
						answer+=map[j][k];
					}
				}else {
					start++;
					end--;
					for (int k= start; k <= end; k++) {
						answer+=map[j][k];
					}
				}
				
			}
			System.out.println("#"+i+" "+ answer);
		}

	}

}
