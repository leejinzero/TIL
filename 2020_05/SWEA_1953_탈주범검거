package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author leejinyoung
 * @Date  May 28, 2020
 * @Language java
 * @Memory 26,096 kb
 * @RunningSpeed 137ms
 * @Description 조건+bfs
 * 
 */
public class SWEA_1953_탈주범검거 {

	private static int[][] map;
	private static int N, M, L;
	private static int[][][] dir = { {},
			{{-1,0},{1,0},{0,-1},{0,1}}, //상하좌우.1
			{{-1,0},{1,0},{0,0},{0,0}}, //상하2
			{{0,0},{0,0},{0,-1},{0,1}}, //좌우3
			{{-1,0},{0,0},{0,0},{0,1}}, //상우4
			{{0,0},{1,0},{0,0},{0,1}},  //하우5
			{{0,0},{1,0},{0,-1},{0,0}}, //하좌6
			{{-1,0},{0,0},{0,-1},{0,0}} //상좌7		
	};
		
	private static ArrayList[] good= new ArrayList[5];
	private static int pos;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 5; i++) {
			good[i] = new ArrayList<Integer>();
		}
		good[0].add(1);
		good[0].add(2);
		good[0].add(5);
		good[0].add(6);
		good[1].add(1);
		good[1].add(2);
		good[1].add(4);
		good[1].add(7);
		good[2].add(1);
		good[2].add(3);
		good[2].add(4);
		good[2].add(5);
		good[3].add(1);
		good[3].add(3);
		good[3].add(6);
		good[3].add(7);
		

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer tks = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(tks.nextToken());
			M = Integer.parseInt(tks.nextToken());
			int R = Integer.parseInt(tks.nextToken());
			int C = Integer.parseInt(tks.nextToken());
			L = Integer.parseInt(tks.nextToken());

			map = new int[N][M];

			for (int i = 0; i < N; i++) {
				tks = new StringTokenizer(bf.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(tks.nextToken());
				}
			}
			pos=1;
			
			bfs(R,C);

			sb.append(pos).append("\n");
		}
		System.out.println(sb);

	}
	
	static class Exit{
		int r,c,cnt;

		public Exit(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}

	private static void bfs(int r, int c) {
		Queue<Exit> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		q.offer(new Exit(r, c, 1));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Exit f = q.poll();
			
			if(f.cnt>=L) return;
			int stand = map[f.r][f.c];
			for (int i = 0; i < 4; i++) {
				int nr = f.r + dir[stand][i][0];
				int nc = f.c + dir[stand][i][1];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && map[nr][nc]>0) {
					if(good[i].contains(map[nr][nc])) {
						pos++;
						q.offer(new Exit(nr, nc, f.cnt+1));
						visited[nr][nc] = true;
					}
				}
				
			}
		}	
	}

}
