import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_토마토{
	static int[][] box;
	static int minday =0;
	static int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};
	static Queue<Point> q = new LinkedList<>();
	
	static class Point{
		int row,col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}

	}
	
	public static void bfs() {
		
		while(!q.isEmpty()) {
			Point front = q.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int nr = front.row+dir[i][0];
				int nc = front.col+dir[i][1];
				
				if(nr>=0 && nr<box.length && nc>=0 && nc<box[0].length && box[nr][nc]==0) {
					box[nr][nc]=box[front.row][front.col]+1;
					q.offer(new Point(nr,nc));
				}		
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(in.readLine());
		int row =Integer.parseInt(tokens.nextToken());
		int col = Integer.parseInt(tokens.nextToken());
		boolean flag= false;
		
		box = new int[col][row];
		
		for (int r = 0; r < box.length; r++) {
			tokens = new StringTokenizer(in.readLine());
			for (int c = 0; c < box[r].length; c++) {
				box[r][c]=Integer.parseInt(tokens.nextToken());

				if(box[r][c]==0) flag =true;
			}
			
		}
		
		if(!flag) {
			System.out.println(0);
			return ;
		}
		
		for (int r = 0; r < box.length; r++) {
			for (int c = 0; c < box[r].length; c++) {
				if(box[r][c]==1) {
					q.offer(new Point(r,c));
				}
			}
		}
		
		bfs();
		
		for (int r = 0; r < box.length; r++) {
			for (int c = 0; c < box[r].length; c++) {
				if(box[r][c]==0) {
					System.out.println(-1);
					return;
				}
				if(minday<box[r][c]) minday=box[r][c];
			}
		}
		
		System.out.println(minday-1);
		return ;
	}

}
