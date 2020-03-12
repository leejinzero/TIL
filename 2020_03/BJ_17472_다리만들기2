import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_17472_다리만들기2 {
	static class Point implements Comparable<Point> {
		int r, c;
		int cnt;

		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Point o) {
			Integer c1 =this.cnt;
			Integer c2 = o.cnt;
			
			return c1.compareTo(c2);
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
		

	}

	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int count;
	static List<Point>[] graph;
	static PriorityQueue<Point> bridges;
	static int[] parent;

	private static void dfs(int r, int c) {
		if (visited[r][c]) {
			return;
		}
		visited[r][c] = true;
		graph[count].add(new Point(r, c, 0));

		for (int i = 0; i < dir.length; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];

			if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
				dfs(nr, nc);
				map[nr][nc] = count;
			}

		}
	}
	
	private static void dfs2(List<Point> land) {
		int stand = map[land.get(0).r][land.get(0).c];
		
		for (int i = 0; i < land.size(); i++) {
			Point p = land.get(i);
			
			for (int j = 0; j < dir.length; j++) {
				int nr = p.r+dir[j][0];
				int nc = p.c+dir[j][1];
				int cnt = 0;
				
				while(isIn(nr,nc) && map[nr][nc]==0) {
					cnt++;
					nr+=dir[j][0];
					nc+=dir[j][1];
				}
				
				if(isIn(nr,nc) && cnt>=2) {
					Point br = new Point(stand,map[nr][nc],cnt);
					bridges.add(new Point(stand,map[nr][nc],cnt));
				}				
			}
		}

	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tks = new StringTokenizer(bf.readLine());

		int r = Integer.parseInt(tks.nextToken());
		int c = Integer.parseInt(tks.nextToken());
		map = new int[r][c];
		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			tks = new StringTokenizer(bf.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(tks.nextToken());
			}
		}

		graph = new List[7];

		count =1;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					graph[count] = new ArrayList<>();
					map[i][j] =count;
					dfs(i, j);
					count++;
				}
			}
		}
		
		count--;
		bridges = new PriorityQueue<>();
		for (int i = 1; i <= count; i++) {
			dfs2(graph[i]);
		}
	
		int result =0 ;
		parent = new int[count+1];
		
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		
		int check =0;
		while(!bridges.isEmpty()) {
			Point f = bridges.poll();
			
			if(!find(f.r,f.c)) {
				result += f.cnt;
				check++;
				unionParent(f.r,f.c);
			}
		}
		if(result ==0 || check != count-1) result = -1;
		System.out.println(result);
	}

	private static void unionParent(int r, int c) {
		r = getParent(r);
		c = getParent(c);
		
		if(r<c) parent[r]=c;
		else parent[c]=r;
		
	}
	
	private static boolean find(int r, int c) {
		r = getParent(r);
		c = getParent(c);
	
		if(r==c) return true;
		else return false;
	}

	private static int getParent(int r) {
		if(parent[r]==r) return r;
		else return parent[r] = getParent(parent[r]);
	}
}
