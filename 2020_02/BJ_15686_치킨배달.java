import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BJ_15686_치킨배달 {
	static int[][] city;
	static int chickenNum;
	static List<Point> chicken = new ArrayList<>();
	static int[] pick;
	static Queue<Point> q;
	static int home;
	static int dap;
	static boolean[][] visited;
	static int min =Integer.MAX_VALUE;
	static int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
	
	static class Point{
		int row, col,cnt;

		public Point(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	
	public static void combi(int index,int start) {
		q= new LinkedList<>();
		
		if(index == chickenNum) {
			for (int i = 0; i < pick.length; i++) {
				q.offer(chicken.get(pick[i]));
			}
			
			int tem = bfs();
			if(tem < min) {
				min=tem;
			}		
			return ;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			pick[index] =i;
			combi(index+1,i+1);
		}		
	}
	
	public static int bfs() {
		int cnt=0;
		visited = new boolean[city.length][city.length];
		dap=0;
		
		while(!q.isEmpty()) {
			Point front = q.poll();
			
			if(city[front.row][front.col]==1) {
				cnt++;
				dap+=front.cnt;
				if(dap>min) return dap;
			}
			
			if(cnt==home) return dap;
			
			for (int i = 0; i < dir.length; i++) {
				int nr = front.row+dir[i][0];
				int nc = front.col+dir[i][1];
				
				int tem = front.cnt+1;
				if(nr>=0 && nr<city.length && nc>=0 && nc<city.length &&!visited[nr][nc]) {
					visited[nr][nc]=true;
					q.offer(new Point(nr,nc,tem));
				}
			}
		}		
		return Integer.MAX_VALUE;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);		
		int N = sc.nextInt();
		city = new int[N][N];
		chickenNum = sc.nextInt();
		pick = new int[chickenNum];		
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				city[r][c] =sc.nextInt();
				if(city[r][c]==2) {
					chicken.add(new Point(r,c,0));
				}
				if(city[r][c]==1) home++;
			}
		}
		combi(0,0);		
		System.out.println(min);			
	}
}
