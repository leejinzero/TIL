package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_등산로조성 {
	static int N,K;
	private static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer tks = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(tks.nextToken());
			K = Integer.parseInt(tks.nextToken());
			
			map = new int[N][N];
			int top = 0;
			
			for (int i = 0; i < N; i++) {
				tks = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tks.nextToken());
					if(top<map[i][j]) top = map[i][j];
				}
			}
			
			max=0;
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(top == map[i][j]) {
						visited[i][j] = true;
						dfs(i,j,map[i][j],1,false);
						visited[i][j] = false;
					}
				}
			}
			sb.append(max).append("\n");
			
		}
		System.out.println(sb);

	}
	static int max;

	private static void dfs(int i, int j,int before,int total, boolean check) {
		
		for (int k = 0; k < 4; k++) {
			int nr = i+dir[k][0];
			int nc = j+dir[k][1];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]) {				
				if(map[nr][nc] < before) {
					visited[nr][nc] = true;
					dfs(nr,nc,map[nr][nc],total+1,check);
				}
				else if(!check && map[nr][nc]-K < before) {
					visited[nr][nc] = true;
					dfs(nr,nc,before-1,total+1,true);
				}else {
					max= Math.max(max,total);
				}
				
				visited[nr][nc] = false;
			}else {
				max = Math.max(max, total);
			}
			
		}
		
		
	}

}
