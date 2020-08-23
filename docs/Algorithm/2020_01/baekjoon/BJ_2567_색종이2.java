package baekjoon;

import java.util.Scanner;

public class BJ_2567_색종이2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[][] map = new int[102][102];
		int[] dirx = {1,-1,0,0};
		int[] diry = {0,0,-1,1};
		
		for (int i = 0; i < cnt; i++) {
			int x= sc.nextInt()+1;
			int y = sc.nextInt()+1;
			
			for (int r = x; r < x+10; r++) {
				for (int c = y; c < y+10 ; c++) {
					map[r][c]=1;
				}
			}
		}
		
		int round = 0;
		
		for (int r = 1; r <= 100; r++) {
			for (int c = 1; c <= 100; c++) {
				if(map[r][c]==1) {
					for (int i = 0; i < 4; i++) {
						int nx= r+dirx[i];
						int ny = c+diry[i];
						
						if(nx>=0 && nx<=101 && ny>=0 && ny<=101 && map[nx][ny]==0) round++;
					}
				}
			}
		}
		
		System.out.println(round);

	}

}
