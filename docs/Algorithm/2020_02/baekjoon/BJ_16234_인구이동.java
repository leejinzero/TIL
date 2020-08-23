package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16234_인구이동 {
	
	static class Point{
		int row,col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}		
	}
	
	static int[][] city;
	static int diff_min;
	static int diff_max;
	static int mapsize ;
	static int move;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static boolean go() {
		visited = new boolean[mapsize][mapsize];
		boolean flag =false;
		for (int r = 0; r < city.length; r++) {
			for (int c = 0; c < city.length; c++) {
				if(!visited[r][c] && bfs(new Point(r,c))) {
					flag =true;
				}
			}
		}
		
		return flag;
	}
	
	public static boolean bfs(Point start) {
		Queue<Point> q = new LinkedList<>();		
		ArrayList<Point> list = new ArrayList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			Point front = q.poll();
			
			if(visited[front.row][front.col]) continue;
			
			visited[front.row][front.col] = true;
			list.add(front);
			
			for (int i = 0; i < dir.length; i++) {
				int nr = front.row+dir[i][0];
				int nc = front.col+dir[i][1];
				
				if(isIn(nr,nc)) {
					int tem = Math.abs(city[front.row][front.col]-city[nr][nc]);
					
					if(tem>=diff_min && tem<=diff_max) {
						q.offer(new Point(nr,nc));
					}
				}
			}
			
		}
		
		if(list.size()>1) {
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				sum+=city[list.get(i).row][list.get(i).col];
			}
			
			for (int i = 0; i < list.size(); i++) {
				city[list.get(i).row][list.get(i).col] = sum/list.size();
			}
			return true;
		}else {
			return false;
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<mapsize && nc>=0 && nc<mapsize;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(bf.readLine());
		
		mapsize = Integer.parseInt(tokens.nextToken());
		city = new int[mapsize][mapsize];
		diff_min = Integer.parseInt(tokens.nextToken());
		diff_max = Integer.parseInt(tokens.nextToken());
		
		for (int r = 0; r < city.length; r++) {
			tokens = new StringTokenizer(bf.readLine());
			for (int c = 0; c < city.length; c++) {
				city[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		while(go()) {
			move++;
		}
		
		System.out.println(move);
	}

}
