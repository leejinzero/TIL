import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17406_배열돌리기4 {

	static int[][] map ;
	static int[][] mapCopy ;
	
	
	static class Orders{
		int row,col,diff;

		public Orders(int row, int col, int diff) {
			this.row = row;
			this.col = col;
			this.diff = diff;
		}
		
	}
	
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static Orders arr[];
	static int[] tem;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	static void permu(int index) {
		if(index== tem.length) {
			
			copy();
			for (int i = 0; i < tem.length; i++) {
				swap(tem[i]);
			}
			
			find();
			return ;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				tem[index] = i;
				permu(index+1);
				visited[i] = false;
			}
			
		}
	}
	
	static void copy() {
		
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[0].length; j++) {
				mapCopy[i][j] = map[i][j];
			}
		}
		
	}
	
	static void swap(int index) {
		int diff = arr[index].diff;
		
		for (int i = 1; i <= diff; i++) {
			int r = arr[index].row-i;
			int c = arr[index].col -i;
			int nr = r;
			int nc = c;
			
			for (int d = 0; d < 4; d++) {
				for (int j = 0; j < 2*i; j++) {
					nr += dir[d][0];
					nc += dir[d][1];
					
					int tem = mapCopy[r][c];
					mapCopy[r][c] = mapCopy[nr][nc];
					mapCopy[nr][nc] = tem;
					
					r = nr;
					c = nc;
					if(d==3 && j==2*i-2) break;
				}
			}
		
		}
		
	}
	

	static void find() {
		for (int i = 1; i < map.length; i++) {
			int sum_r = 0;
			for (int j = 1; j < map[0].length; j++) {
				sum_r += mapCopy[i][j];
			}
			min = Math.min(min, sum_r);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tks = new StringTokenizer(bf.readLine());
		
		int row = Integer.parseInt(tks.nextToken());
		int col = Integer.parseInt(tks.nextToken());
		int order = Integer.parseInt(tks.nextToken());
		
		map = new int[row+1][col+1];
		mapCopy = new int[row+1][col+1];
		
		for (int r = 1; r <= row; r++) {
			tks = new StringTokenizer(bf.readLine());
			for (int c = 1; c <= col; c++) {
				map[r][c] = Integer.parseInt(tks.nextToken());
			}
		}
		
		arr = new Orders[order];
		for (int i = 0; i < order; i++) {
			tks = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(tks.nextToken());
			int c = Integer.parseInt(tks.nextToken());
			int diff = Integer.parseInt(tks.nextToken());
			
			arr[i] = new Orders(r,c,diff);
		}
		
		tem = new int[order];
		visited = new boolean[order];
		permu(0);
		
		System.out.println(min);
	}

}
