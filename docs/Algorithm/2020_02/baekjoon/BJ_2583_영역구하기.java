package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2583_영역구하기 {
	static class Point {
		int row, col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}

	}

	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean[][] visited;

	public static int dfs(Point start) {
		Stack<Point> stack = new Stack<>();
		stack.push(start);
		int zerocnt = 0;

		while (!stack.isEmpty()) {
			Point top = stack.pop();

			if (visited[top.row][top.col])
				continue;

			visited[top.row][top.col] = true;
			zerocnt++;

			for (int i = 0; i < dir.length; i++) {
				int nx = top.row + dir[i][0];
				int ny = top.col + dir[i][1];

				if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && map[nx][ny] == 0) {
					stack.push(new Point(nx, ny));
				}
			}

		}
		return zerocnt;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(bf.readLine());

		int row = Integer.parseInt(tokens.nextToken());
		int col = Integer.parseInt(tokens.nextToken());
		int cnt = Integer.parseInt(tokens.nextToken());

		map = new int[row][col];
		visited = new boolean[row][col];

		for (int i = 0; i < cnt; i++) {
			tokens = new StringTokenizer(bf.readLine());
			int left_row = Integer.parseInt(tokens.nextToken());
			int left_col = Integer.parseInt(tokens.nextToken());
			int right_row = Integer.parseInt(tokens.nextToken());
			int right_col = Integer.parseInt(tokens.nextToken());

			for (int j = left_row; j < right_row; j++) {
				for (int j2 = left_col; j2 < right_col; j2++) {
					map[j2][j] = 1;
				}
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		int zero = 0;
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (!visited[r][c] && map[r][c] == 0) {
					zero++;
					list.add(dfs(new Point(r, c)));
				}
			}
		}

		list.sort(null);
		System.out.println(zero);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
