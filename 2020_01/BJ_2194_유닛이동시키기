import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2194_유닛이동시키기 {
	
	static int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[][] visited;
	static int[][] map;
	static int[][] depth;

	static class Point{
		int row,col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	static void bfs(Point start, Point end,int row2, int col2) {
		Queue<Point> q = new LinkedList<>();
		
		for (int i = 0; i < depth.length; i++) {
			Arrays.fill(depth[i], Integer.MAX_VALUE);
		}
		depth[start.row][start.col]=0;
		
		q.offer(start);
		
		while(!q.isEmpty()) {
			Point top =q.poll();
			
			if(visited[top.row][top.col]) continue;
			
			visited[top.row][top.col]=true;
						
here:		for (int i = 0; i < dir.length; i++) {
				int nx = top.row+dir[i][0];
				int ny = top.col+dir[i][1];	

				for (int j = nx; j < nx+row2; j++) {
					for (int k = ny; k < ny+col2; k++) {
						if(!isIn(j,k) || map[j][k]!=0) {
							continue here;
						}
					}
				}
				
				if(depth[nx][ny]>depth[top.row][top.col]+1) {
					depth[nx][ny]=depth[top.row][top.col]+1;
				}
				q.offer(new Point(nx,ny));		
				if(nx==end.row && ny == end.col) {
					if(depth[nx][ny]>depth[top.row][top.col]+1) {
						depth[nx][ny]=depth[top.row][top.col]+1;
					}
				}			
			}		
			
		}	
		
	}
	
	private static boolean isIn(int nx, int ny) {

		return nx>=1 && nx<map.length && ny>=1 && ny<map[0].length;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		int row2 =sc.nextInt();
		int col2 = sc.nextInt();
		
		
		map = new int[row+1][col+1];
		visited = new boolean[row+1][col+1];
		depth= new int[row+1][col+1];
		
		int trapCnt =sc.nextInt();
		
		for (int i = 0; i < trapCnt; i++) {
			int trapRow = sc.nextInt();
			int trapCol = sc.nextInt();
			
			map[trapRow][trapCol]=1;
			
		}
		
		int start_row =sc.nextInt();
		int start_col =sc.nextInt();
		int end_row =sc.nextInt();
		int end_col =sc.nextInt();
		Point start = new Point(start_row,start_col);
		Point end = new Point(end_row,end_col);
	
		bfs(start,end,row2,col2);
				
		if(depth[end_row][end_col]==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(depth[end_row][end_col]);
		
	}
}
