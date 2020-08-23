package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17142_연구소3 {
	static class Point{
		int row, col, cnt;

		public Point(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", cnt=" + cnt + "]";
		}
		
	}
	static int[][] map ;
	static int[][] mapCopy ;
	static ArrayList<Point> brlist = new ArrayList<>();
	static Point[] brArr;
	static Queue<Point> q;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visited;
	static int minday = Integer.MAX_VALUE;
	static int size;
	static int br;
	static int zero=0;
	
	public static void combi(int index, int start) {
		if(index == br) {
			copy();
			q = new LinkedList<>();
			visited = new boolean[size][size];
			for (int i = 0; i < brArr.length; i++) {
				q.add(brArr[i]);
				mapCopy[brArr[i].row][brArr[i].col]=2;
				visited[brArr[i].row][brArr[i].col]=true;
			}
			
			int tem = bfs();
			if(tem!=-1) {
				minday = Math.min(minday, tem);
			}
			return ;
		}
		else {
			for (int i = start; i < brlist.size(); i++) {
				brArr[index] = brlist.get(i);
				combi(index+1,i+1);
			}
			
		}
	}
	
	private static int bfs() {	
		int day = 0;
		int zero_c = zero;
		
here:	while(!q.isEmpty()) {
			Point front = q.poll();
			
			day = front.cnt;
			
			if(front.cnt > minday) return -1;
			
			for (int i = 0; i < dir.length; i++) {
				int nx = front.row + dir[i][0];
				int ny = front.col + dir[i][1];
					
				if(isIn(nx,ny) && !visited[nx][ny]) {
					if(mapCopy[nx][ny]==0) {
						mapCopy[nx][ny]=2;
						q.offer(new Point(nx,ny,front.cnt+1));
						visited[nx][ny] =true;
						zero_c--;
						if(zero_c==0) {
							day = front.cnt+1;
							break here;
						}
					}
					else if (mapCopy[nx][ny]==-1){
						visited[nx][ny] =true;
						q.offer(new Point(nx,ny,front.cnt+1));
					}
				}
			}
		}

		if(zero_c==0) {
			return day;
		}else {
			return -1;
		}
	}

	public static boolean isIn(int nx, int ny) {
		return nx >=0 && nx < size && ny>=0 && ny< size;
	}
	
	public static boolean check(int[][] mapCopy) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(mapCopy[i][j]==0)
					return false;
			}
		}
		return true;
	}
	public static void copy() {
		mapCopy = new int[size][size];
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if(map[r][c]!=2) {
					mapCopy[r][c] = map[r][c];
				}else {
					mapCopy[r][c]=-1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(bf.readLine());
		
		size = Integer.parseInt(tokens.nextToken());
		br = Integer.parseInt(tokens.nextToken());
		
		brArr = new Point[br];		
		map = new int[size][size];
		mapCopy = new int[size][size];
		visited = new boolean[size][size];
		
		for (int r = 0; r < size; r++) {
			tokens = new StringTokenizer(bf.readLine());
			for (int c = 0; c < size; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c]==2) {
					brlist.add(new Point(r,c,0));
				}else if(map[r][c] ==0) {
					zero++;
				}
			}
		}
		if(check(map)) {
			System.out.println(0);
		}else {
			combi(0,0);
			if(minday!=Integer.MAX_VALUE) {
				System.out.println(minday);
			}else {
				System.out.println(-1);
			}
		}
		

	}

}
