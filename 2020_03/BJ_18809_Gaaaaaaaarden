import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_18809_Gaaaaaaaarden {
	static int R,C,green,red;
	static int[][] map, mapCopy;
	static int[][] type;
	static int[] tem1, tem2;
	static int max;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static ArrayList<Point> list = new ArrayList<>();
	static Queue<Point> q = new LinkedList<>();
	static class Point{
		int r,c,cnt;
		int flag;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, int cnt, int flag) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.flag = flag;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + ", flag=" + flag + "]";
		}
		
	}
	
	private static void pick2(int index, int start) {
		if(index==green) {
			copy();
			type = new int[R][C];
			boolean[] visited = new boolean[list.size()];
			
			for (int i = 0; i < tem2.length; i++) {
				Point p = list.get(tem2[i]);
				q.offer(new Point(p.r,p.c,2,1));
				type[p.r][p.c] = 1;
				mapCopy[p.r][p.c] = 0;
				visited[tem2[i]]=true;
			}

			
			for (int i = 0; i < tem1.length; i++) {
				if(!visited[tem1[i]]) {
					Point p = list.get(tem1[i]);
					q.offer(new Point(p.r,p.c,2,2));
					mapCopy[p.r][p.c] = 0;
					type[p.r][p.c] = 2;
				}
			}
			
			max = Math.max(bfs(),max);
			
			return ;
		}
		
		for (int i = start; i < green+red; i++) {
			tem2[index] = tem1[i];
			pick2(index+1,i+1);
		}
	}
	
	private static int bfs() {
		int cnt=0;
		
		while(!q.isEmpty()) {
			Point f= q.poll();
			
			if(mapCopy[f.r][f.c]==-1) continue;
			
			for (int i = 0; i < dir.length; i++) {
				int nr = f.r + dir[i][0];
				int nc = f.c + dir[i][1];
				
				if(isIn(nr,nc) && mapCopy[nr][nc]!=0 && mapCopy[nr][nc]!=-1) {
					if(type[nr][nc]!=0 && type[nr][nc]!=f.flag && mapCopy[nr][nc]==f.cnt+1) {
						cnt++;
						mapCopy[nr][nc] = -1;
						continue;
					}
					
					if(type[nr][nc]==0) {
						mapCopy[nr][nc] = f.cnt+1;
						type[nr][nc] = f.flag;
						q.offer(new Point(nr,nc,f.cnt+1,f.flag));
					}
				}
			}
		}
		
		return cnt;
		
	}

	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<C;
	}

	private static void pick1(int index,int start) {
		if(index==green+red) {
			tem2 = new int[green];
			pick2(0,0);
			
			return ;
		}
		
		for (int i = start; i < list.size(); i++) {
			tem1[index]=i;
			pick1(index+1,i+1);
		}
		
	}
	
	
	private static void copy() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				mapCopy[i][j] = map[i][j];
			}
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tks = new StringTokenizer(bf.readLine());
		
		R = Integer.parseInt(tks.nextToken());
		C = Integer.parseInt(tks.nextToken());
		green = Integer.parseInt(tks.nextToken());
		red = Integer.parseInt(tks.nextToken());
		
		map = new int[R][C];
		mapCopy = new int[R][C];
		type = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			tks = new StringTokenizer(bf.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(tks.nextToken());
				if(map[i][j]==2) list.add(new Point(i,j));
			}
		}
		
		tem1 = new int[green+red];
		pick1(0,0);
		System.out.println(max);
	}

}
