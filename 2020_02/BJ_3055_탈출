import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3055_탈출 {
	static char[][] map;
	static boolean[][] visited;
	static Point start;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static Queue<Point> q = new LinkedList<>();
	
	static class Point{
		int row, col, cnt;
		boolean beber = false;

		public Point(int row, int col, int cnt, boolean beber) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
			this.beber = beber;
		}
	}
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			Point front = q.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int nr = front.row + dir[i][0];
				int nc = front.col + dir[i][1];
				
				if(isIn(nr,nc) && !visited[nr][nc]) {
					if(front.beber) {
						if(map[nr][nc] == '.') {
							q.offer(new Point(nr,nc,front.cnt+1,true));
							visited[nr][nc] = true;
						}else if(map[nr][nc]=='D'){
							System.out.println(front.cnt+1);
							return ;
						}
					}else {
						if(map[nr][nc] == '.') {
							q.offer(new Point(nr,nc,front.cnt+1,false));
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
		
		System.out.println("KAKTUS");
	}
	
	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<map.length && nc>=0 && nc<map[0].length;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tks = new StringTokenizer(bf.readLine());
		
		int row = Integer.parseInt(tks.nextToken());
		int col = Integer.parseInt(tks.nextToken());
		
		map = new char[row][col];
		visited = new boolean[row][col];
		for (int r = 0; r < row; r++) {
			String str =bf.readLine();
			for (int c = 0; c < col; c++) {
				map[r][c] = str.charAt(c);
				if(map[r][c]=='*') {
					q.offer(new Point(r,c,0, false));
					visited[r][c] = true;
				}
			}
		}
		
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if(map[r][c]=='S') {
					q.offer(new Point(r,c,0, true));
				}
			}
		}
		
		bfs();
	}
}
