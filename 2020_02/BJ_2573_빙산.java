import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2573_빙산 {

	static int[][] bing;
	static int[][] bingCopy;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
	static boolean[][] visited;
	static int year;
	
	static class Point{
		int row,col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}		
		
	}
	
	public static boolean go() {
		visited = new boolean[bing.length][bing[0].length];

		copy(bing, bingCopy);
		for (int r = 1; r < bing.length-1; r++) {
			for (int c = 1; c < bing[0].length-1; c++) {	
				if(bing[r][c]!=0) {
					for (int i = 0; i < dir.length; i++) {
						int nr = r + dir[i][0];
						int nc = c + dir[i][1];
						
						if(isIn(nr,nc) && bing[nr][nc]==0) {
							bingCopy[r][c]-=1;
							if(bingCopy[r][c]<0) bingCopy[r][c]=0;
						}
					}
				}
			}
		}
		copy(bingCopy,bing);
		
		int cnt = 0;
		for (int r = 1; r < bing.length-1; r++) {
			for (int c = 1; c < bing[r].length-1; c++) {
				if(!visited[r][c] && bing[r][c]!=0) {
					cnt+=dfs(new Point(r,c), visited);
				}
				
			}
		}
		year++;
		
		if(cnt>=2) {
			return true;
		}
		else{
			return false;
		}
	}
	
	public static int dfs(Point start, boolean[][] visited) {
		Stack<Point> stack = new Stack<>();
		stack.push(start);
		
		while(!stack.isEmpty()) {
			Point top = stack.pop();
			
			if(visited[top.row][top.col]) continue;
			
			visited[top.row][top.col] = true;
			
			for (int i = 0; i < dir.length; i++) {
				int nr = top.row + dir[i][0];
				int nc = top.col + dir[i][1];
				
				if(isIn(nr,nc) && bing[nr][nc]!=0) {
					stack.push(new Point(nr,nc));
				}
			}
		}
		
		return 1;
	}
	
	public static void copy(int[][] map , int[][] mapCopy){
		for (int r = 1; r < mapCopy.length-1; r++) {
			for (int c = 1; c < mapCopy[0].length-1; c++) {
				mapCopy[r][c] =map[r][c];
			}
		}
	}
	
	
	public static boolean zero() {
		
		for (int r = 1; r < bing.length-1; r++) {
			for (int c = 1; c < bing[0].length-1; c++) {
				if(bing[r][c]!=0) return false;
			}
		}
		
		return true;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(bf.readLine());
		
		int row = Integer.parseInt(tokens.nextToken());
		int col = Integer.parseInt(tokens.nextToken());
		
		bing = new int[row][col];
		visited = new boolean[row][col];
		bingCopy = new int[row][col];
		
		for (int r = 0; r < row; r++) {
			tokens = new StringTokenizer(bf.readLine());
			for (int c = 0; c < col; c++) {
				bing[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		int cnt = 0;
		for (int r = 1; r < bing.length-1; r++) {
			for (int c = 1; c < bing[r].length-1; c++) {
				if(!visited[r][c] && bing[r][c]!=0) {
					cnt+=dfs(new Point(r,c), visited);
				}
				
			}
		}
		
		if(cnt>=2) {
			System.out.println(0);
			return ;
		}
		
		while(!go()) {
			if(zero()) {
				System.out.println(0);
				return ;
			}
		}
		
		System.out.println(year);		
	}

	private static boolean isIn(int nr, int nc) {
		return nr >=0 && nr<bing.length && nc>=0 && nc<bing[0].length;
	}

}
