package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class BJ_14502_연구소 {
	
	static class Point{
		int row,col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
	}
	static boolean[][] visited;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	
	private static void dfs(Point start,int[][] mapCopy) {
		Stack<Point> stack = new Stack<>();
		visited = new boolean[row][col];
		stack.push(start);
		
		while(!stack.isEmpty()) {
			Point top = stack.pop();
			
			if(visited[top.row][top.col]) continue;
			
			visited[top.row][top.col]=true;
			
			for (int i = 0; i < dir.length; i++) {
				int nx = top.row+dir[i][0];
				int ny = top.col+dir[i][1];
				
				if(nx>=0 && nx<row && ny>=0 && ny<col && visited[nx][ny]==false && mapCopy[nx][ny]==0) {
					stack.push(new Point(nx,ny));
					mapCopy[nx][ny]=2;
				}
			}		
		}
			
}	
	static int[][] map;
	
	private static int spreadNum(int i1, int i2, int i3) {
		int cnt=0;
		
		int[][] mapCopy = new int[map.length][map[0].length];
		
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				mapCopy[r][c]=map[r][c];
			}
		}

		mapCopy[i1/col][i1%col]=1;
		mapCopy[i2/col][i2%col]=1;
		mapCopy[i3/col][i3%col]=1;
		
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if(mapCopy[r][c]==2) {
					dfs(new Point(r,c),mapCopy);
				}
			}
		}
		
		for (int j = 0; j < map.length; j++) {
			for (int i = 0; i < map[j].length; i++) {
				if(mapCopy[j][i]==0) cnt++;
			}
		}
		return cnt;
	}
	static int[] tem = new int[3];
	static Scanner sc = new Scanner(System.in);
	static int row = sc.nextInt();
	static int col = sc.nextInt();
	static int max = 0;
	
	public static void combi(int idx, int start) {
		if(idx==3) {
			if (isTrue(tem)) {
				int num = spreadNum(tem[0],tem[1],tem[2]);	
				if(max<num) max = num;
			}
			return ;
		}
		
		for (int i = start; i < row*col; i++) {
			tem[idx]=i;
			combi(idx+1,i+1);
		}
	}

	public static void main(String[] args) {
		
		map = new int[row][col];
		int[][] mapCopy = new int[row][col];
		visited = new boolean[row][col];
		
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				map[r][c]=sc.nextInt();
				mapCopy[r][c]=map[r][c];
			}
		}
		combi(0,0);

		System.out.println(max);
	}

	public static boolean isTrue(int[] tem) {
		return map[tem[0]/col][tem[0]%col]==0 &&map[tem[1]/col][tem[1]%col]==0 &&map[tem[2]/col][tem[2]%col]==0 ;
	}
}
