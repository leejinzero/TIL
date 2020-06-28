package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2174_로봇시뮬레이션 {
	static int[][] map ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tks = new StringTokenizer(bf.readLine());
		
		int col = Integer.parseInt(tks.nextToken());
		int row = Integer.parseInt(tks.nextToken());
		
		map = new int[row][col];
		tks = new StringTokenizer(bf.readLine());
		
		int robot = Integer.parseInt(tks.nextToken());
		int order = Integer.parseInt(tks.nextToken());
		
		int[][] robots = new int[robot][3];
		int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
		
		for (int i = 0; i < robot; i++) {
			tks = new StringTokenizer(bf.readLine());
			robots[i][1] = Integer.parseInt(tks.nextToken())-1;
			robots[i][0] = row-Integer.parseInt(tks.nextToken());
			map[robots[i][0]][robots[i][1]]=i+1;
			
			char tem = tks.nextToken().charAt(0);
			if(tem == 'N') robots[i][2] =0;
			else if(tem == 'E') robots[i][2]=1;
			else if(tem == 'S') robots[i][2]=2;
			else robots[i][2]=3;
			
		}
		
		int[] nums = new int[order];
		int[] cnts = new int[order];
		char[] dir = new char[order];
		
		for (int i = 0; i < order; i++) {
			tks = new StringTokenizer(bf.readLine());
			nums[i] = Integer.parseInt(tks.nextToken());
			dir[i] = tks.nextToken().charAt(0);
			cnts[i] = Integer.parseInt(tks.nextToken());
			
		}
		
		for (int i = 0; i < order; i++) {
			int d = robots[nums[i]-1][2];
			
			if(dir[i] == 'F') {
				int nx = robots[nums[i]-1][0];
				int ny = robots[nums[i]-1][1];
				
				for (int j = 0; j < cnts[i]; j++) {
					map[nx][ny]= 0;
					nx+=dirs[d][0];
					ny+=dirs[d][1];
					
					if(!isIn(nx,ny)) {
						System.out.println("Robot "+ nums[i] +" crashes into the wall");
						return ;
					}else if(map[nx][ny]!=0) {
						System.out.println("Robot "+nums[i]+" crashes into robot "+ map[nx][ny]);
						return ;
					}
					map[nx][ny] = nums[i];
					
					if(j==cnts[i]-1) {
						robots[nums[i]-1][0]= nx;
						robots[nums[i]-1][1]= ny;
					}
				}
				
			}
			else if(dir[i] == 'L') {
				for (int j = 0; j < cnts[i]; j++) {
					d--;
					if(d==-1) d=3;
				}
				robots[nums[i]-1][2]=d;
			}
			else if(dir[i] == 'R') {
				for (int j = 0; j < cnts[i]; j++) {
					d++;
					if(d==4) d=0;
				}
			}
			robots[nums[i]-1][2]=d;
		}
		
		System.out.println("OK");
	}

	private static boolean isIn(int nx, int ny) {
		return nx>=0 && nx<map.length && ny>=0 && ny<map[0].length;
	}
}
