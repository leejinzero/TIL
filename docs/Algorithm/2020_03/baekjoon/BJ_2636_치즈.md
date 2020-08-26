package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2636_치즈 {
	static int R,C;
	static int[][] map;
	static int total;
	static int origin;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
	private static void dfs(int r, int c) {
		
		for (int i = 0; i < dir.length; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			
			if(isIn(nr,nc) && !visited[nr][nc]) {
				if(map[nr][nc] == 1) {
					map[nr][nc] = 0 ;
					visited[nr][nc] = true;
					total++;
				}
				else {
					visited[nr][nc] = true;
					dfs(nr,nc);
				}
			}
		}
		
	}
	
	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<C;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tks = new StringTokenizer(bf.readLine());
		
		R = Integer.parseInt(tks.nextToken());
		C = Integer.parseInt(tks.nextToken());
		
		map = new int[R][C];
		
		
		for (int i = 0; i < R; i++) {
			tks = new StringTokenizer(bf.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(tks.nextToken());
				if(map[i][j]==1) origin++;
			}
		}
		
		int time = 0;

		while(true) {
			visited = new boolean[R][C];
			total = 0;
			
here:		for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(!visited[i][j] && map[i][j]==0) {
						visited[i][j]=true;
						dfs(i,j);
						break here ;
					}
				}
			}
			time++;
			
			if(origin==total) break;

			origin-=total;
		}
		System.out.println(time);
		System.out.println(origin);

	}

}
