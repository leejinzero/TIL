package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @Author leejinyoung
 * @Date 2020. 5. 14.
 * @Language java
 * @Memory 251084KB
 * @RunningSpeed 880ms
 * @Description bfs+사방탐색 문제.. 시간을 초과하지말자,,
 * 
 */
public class BJ_16932_모양만들기 {
	private static int R;
	private static int C;
	private static int[][] map;
	private static ArrayList<Zero> list;
	private static boolean[][] visited;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	private static ArrayList<Zero> list2;
	private static ArrayList<Zero> list3;

	static class Zero {
		int r, c;
		int cnt;

		public Zero(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Zero [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tks = new StringTokenizer(bf.readLine());

		R = Integer.parseInt(tks.nextToken());
		C = Integer.parseInt(tks.nextToken());

		map = new int[R][C];

		list = new ArrayList<Zero>();
		list2 = new ArrayList<Zero>();

		for (int i = 0; i < R; i++) {
			tks = new StringTokenizer(bf.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(tks.nextToken());
				if (map[i][j] == 0)
					list.add(new Zero(i, j));
				else
					list2.add(new Zero(i, j));
			}
		}

		visited = new boolean[R][C];
		list3 = new ArrayList<Zero>();

		int num = 0;
		int size2 = list2.size();
		for (int i = 0; i < size2; i++) {
			Zero can = list2.get(i);
			if (!visited[can.r][can.c]) {
				visited[can.r][can.c] = true;
				num++;
				list3.add(new Zero(num, bfs2(can.r, can.c, num)));
			}

		}

		int max = 0;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			Zero can = list.get(i);
			map[can.r][can.c] = 1;
			max = Math.max(max, check(can.r, can.c));
			map[can.r][can.c] = 0;
		}

		System.out.println(max);

	}

	private static int check(int i, int j) {
		Set<Integer> cntlist = new HashSet<>();
		for (int k = 0; k < 4; k++) {
			int nr = i + dir[k][0];
			int nc = j + dir[k][1];

			if (isIn(nr, nc) && map[nr][nc] >= 1) {
				cntlist.add(map[nr][nc]);
			}

		}

		int cnt = 1;
		for (int k : cntlist) {
			cnt += list3.get(k - 1).c;
		}
		return cnt;
	}

	private static int bfs2(int i, int j, int num) {
		Queue<Zero> q = new LinkedList<>();
		q.offer(new Zero(i, j));
		int cnt = 1;
		map[i][j] = num;

		while (!q.isEmpty()) {
			Zero f = q.poll();

			for (int k = 0; k < 4; k++) {
				int nr = f.r + dir[k][0];
				int nc = f.c + dir[k][1];

				if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					q.offer(new Zero(nr, nc));
					visited[nr][nc] = true;
					cnt++;
					map[nr][nc] = num;
				}
			}
		}
		return cnt;
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}

}
