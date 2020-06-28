package swea;

import java.util.Scanner;

public class SWEA_1220_Magnetic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 10; i++) {
			int N=sc.nextInt();
			int[][] map = new int[N][N];
			int answer=0;
			for (int j = 0; j < map.length; j++) {
				for (int j2 = 0; j2 < map.length; j2++) {
					map[j][j2] =sc.nextInt();
				}
			}
			
			for (int j = 0; j <N; j++) {
				StringBuilder sb = new StringBuilder();
				for (int k = 0; k < N; k++) {
					if(map[k][j]!=0) {
						sb.append(map[k][j]);
					}
				}
				for (int k = 0; k < sb.length()-1; k++) {
					if(sb.substring(k,k+2).equals("12")) answer++;
				}

			}
			
			
			System.out.println("#"+i+" "+ answer );
		}

	}

}
