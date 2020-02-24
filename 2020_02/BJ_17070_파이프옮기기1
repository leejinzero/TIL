package adv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_17070_파이프옮기기1 {
	static class Point {
		int row, col, dir;

		public Point(int row, int col, int dir) {
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
	}

	static int[][] map;
	static int mapsize;
	static int[][][] d = { { { 0, 1 }, {100,100} ,{ 1, 1 } }, {{100,100}, { 1, 0 }, { 1, 1 } }, { { 0, 1 }, { 1, 0 }, { 1, 1 } } };

	public static boolean isIn(int x, int y) {
		return x > 0 && x < mapsize + 1 && y > 0 && y < mapsize + 1;
	}

	public static int pipe() {
		Stack<Point> s = new Stack<>();
		s.push(new Point(1, 2, 0));
		int cnt = 0;

here: while (!s.isEmpty()) {
			Point top = s.pop();

			if (top.row == mapsize && top.col == mapsize) {
				cnt++;
				continue;
			}
			
			for (int i = 0; i<=2 ; i++) {
				int nx = top.row + d[top.dir][i][0];
				int ny = top.col + d[top.dir][i][1];

				if (isIn(nx, ny) && map[nx][ny] == 0) {
					if (i < 2) {
						s.push(new Point(nx, ny, i));
					}else {
						if(map[top.row][top.col+1]==1) continue here;
						if(map[top.row+1][top.col]==1) continue here;
						s.push(new Point(nx, ny, i));
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		mapsize = Integer.parseInt(bf.readLine());
		map = new int[mapsize + 1][mapsize + 1];

		for (int i = 1; i <= mapsize; i++) {
			StringTokenizer tokens = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= mapsize; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		System.out.println(pipe());
	}
}
