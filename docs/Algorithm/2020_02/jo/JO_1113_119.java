package jo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JO_1113_119 {
	static int[][] map;
	static int[][] dirmap ;
	static int[] dir[] = {{0,1},{1,0},{-1,0},{0,-1}};

	static class Point{
		int row, col,dir,cnt;

		public Point(int row, int col, int dir, int cnt) {
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.cnt = cnt;
		}	
	}
	
	public static void bfs(int end_row, int end_col) {
		Queue<Point> q = new LinkedList<>();		
		q.offer(new Point(0,0,-1,-1));	
		dirmap[0][0]=-1;

		while(!q.isEmpty()) {
			Point front = q.poll();
			
			if(front.row == end_row && front.col== end_col) {
				continue;
			}
			
			int tem = front.dir;
			for (int i = 0; i < dir.length; i++) {
				int nxr = front.row+dir[i][0];
				int nxc = front.col+dir[i][1];
	
				if(isIn(nxr,nxc) && map[nxr][nxc]==1) {
					Point next;
					if(tem == i) {
						next =new Point(nxr,nxc,i,front.cnt);
					}else {
						next = new Point(nxr,nxc,i,front.cnt+1);
					}
					
					if(dirmap[nxr][nxc] > next.cnt) {
						q.offer(next);
						dirmap[nxr][nxc] = next.cnt;
					}	
				}
				
			}
		}
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && r<map.length && c>=0 && c<map[0].length;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		map = new int[row][col];
		
		int end_row = sc.nextInt();
		int end_col=sc.nextInt();
		
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				map[r][c]=sc.nextInt();
			}
		}
		dirmap = new int[row][col];
		
		for (int r = 0; r < dirmap.length; r++) {
			Arrays.fill(dirmap[r], Integer.MAX_VALUE);
		}
		
		bfs(end_row,end_col);
		System.out.println(dirmap[end_row][end_col]);
	}

}
