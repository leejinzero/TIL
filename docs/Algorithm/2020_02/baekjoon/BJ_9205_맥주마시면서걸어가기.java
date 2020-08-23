package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_9205_맥주마시면서걸어가기 {
	static class Point {
		int row, col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}
	}

	static List<Point> list;
	static boolean[] visited;
	static List<Integer>[] graph;

	public static int distance(Point p1, Point p2) {
		return Math.abs(p1.row - p2.row) + Math.abs(p1.col - p2.col);
	}

	public static boolean dfs() {
		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		while (!stack.isEmpty()) {
			int top = stack.pop();

			if (visited[top])
				continue;
			visited[top] = true;

			if (top == list.size() - 1)
				return true;

			List childs = graph[top];

			for (int i = 0; i < childs.size(); i++) {
				int child = (int) childs.get(i);
				if (!visited[child]) {
					stack.push(child);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(bf.readLine());

		here: for (int tc = 1; tc <= T; tc++) {
			int convi = Integer.parseInt(bf.readLine());
			StringTokenizer tokens = new StringTokenizer(bf.readLine());
			int home_row = Integer.parseInt(tokens.nextToken());
			int home_col = Integer.parseInt(tokens.nextToken());
			list = new ArrayList<>();
			list.add(new Point(home_row, home_col));

			for (int i = 0; i < convi; i++) {
				tokens = new StringTokenizer(bf.readLine());
				int convi_row = Integer.parseInt(tokens.nextToken());
				int convi_col = Integer.parseInt(tokens.nextToken());

				list.add(new Point(convi_row, convi_col));
			}

			tokens = new StringTokenizer(bf.readLine());
			int festival_row = Integer.parseInt(tokens.nextToken());
			int festival_col = Integer.parseInt(tokens.nextToken());

			list.add(new Point(festival_row, festival_col));

			int dis = distance(list.get(0), list.get(list.size() - 1));

			if (dis <= 1000) {
				sb.append("happy").append("\n");
			} else {
				graph = new ArrayList[list.size()];
				visited = new boolean[list.size()];
				for (int i = 0; i < graph.length; i++) {
					graph[i] = new ArrayList<>();
				}

				for (int i = 0; i < list.size(); i++) {
					for (int j = i + 1; j < list.size(); j++) {
						if (distance(list.get(i), list.get(j)) <= 1000) {
							graph[i].add(j);
							graph[j].add(i);
						}
					}
				}

				if (dfs())
					sb.append("happy").append("\n");
				else
					sb.append("sad").append("\n");
			}
		}
		System.out.println(sb);
	}

}
