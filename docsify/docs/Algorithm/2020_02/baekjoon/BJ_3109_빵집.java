package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class BJ_3109_빵집 {
	static class Point {
		int row, col;
		int call = 0;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static char[][] map;
	static int row, col;
	static boolean[][] visited;
	static int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
	static int size = 0;

	static void dfs(Point start) {
		Stack<Point> stack = new Stack<>();
		stack.push(start);

		while (!stack.isEmpty()) {
			Point top = stack.peek();

			if (top.col == map[0].length - 1) {
				size++;
				return;
			}

			if (top.call < dir.length) {
				int nr = top.row + dir[top.call][0];
				int nc = top.col + dir[top.call++][1];

				if (nr >= 0 && nr < row && nc >= 0 && nc < col && visited[nr][nc] == false) {
					if (map[nr][nc] == '.') {
						visited[nr][nc] = true;
						stack.push(new Point(nr, nc));
					}
				}
			} else {
				stack.pop();
			}

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		row = sc.nextInt();
		col = sc.nextInt();

		map = new char[row][col];
		visited = new boolean[row][col];

		for (int r = 0; r < row; r++) {
			String str = sc.next();
			for (int c = 0; c < col; c++) {
				map[r][c] = str.charAt(c);
			}
		}

		for (int r = 0; r < row; r++) {
			dfs(new Point(r, 0));
		}

		System.out.println(size);
	}
}
