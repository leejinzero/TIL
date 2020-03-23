import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_18405_경쟁적전염 {
	static int N,K,S;
	static int[][] map;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visited;
	static PriorityQueue<Point> q = new PriorityQueue<>();
	static class Point implements Comparable<Point>{
		int r,c,cnt,type;

		public Point(int r, int c, int type,int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.type = type;
		}

		@Override
		public int compareTo(Point o) {
			Integer c1 = this.cnt;
			Integer c2 = o.cnt;
			if(c1.equals(c2)) {
				Integer t1 = this.type;
				Integer t2 = o.type;
				return t1.compareTo(t2);
			}
			return c1.compareTo(c2);
		}	
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			Point f = q.poll();
			
			if(f.cnt==S+1) return;
			if(visited[f.r][f.c]) continue;
			visited[f.r][f.c] = true;
			map[f.r][f.c] = f.type;
			
			for (int i = 0; i < dir.length; i++) {
				int nr = f.r +dir[i][0];
				int nc = f.c +dir[i][1];
				
				if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc] == 0) {
					q.offer(new Point(nr,nc,map[f.r][f.c],f.cnt+1));
				}
			}
		}
		
	}
	
	
	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tks = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(tks.nextToken());
		K = Integer.parseInt(tks.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			tks = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tks.nextToken());
				if(map[i][j]!=0) q.offer(new Point(i,j,map[i][j],0));
			}
		}
		
		tks = new StringTokenizer(bf.readLine());
		S = Integer.parseInt(tks.nextToken());
		int X = Integer.parseInt(tks.nextToken())-1;
		int Y = Integer.parseInt(tks.nextToken())-1;
		
		bfs();
		System.out.println(map[X][Y]);
	}

}
