package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13460_구슬탈출2 {
	static char[][] map;
	static Queue<Ball> q = new LinkedList<>();
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][][][] visited;
	static int time = -1;
	static Ball start, next;
	static boolean red, blue;

	static class Ball {
		int rx, ry, bx, by, cnt, dir;

		public Ball(int rx, int ry, int bx, int by, int cnt, int dir) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return rx + " , " + ry + " , " + bx + " , " + by + " , " + cnt + " , " + dir;
		}

	}

	private static void move(Ball cur) {
		int nextRedr = cur.rx;
		int nextRedc = cur.ry;
		int nextBluer = cur.bx;
		int nextBluec = cur.by;

		while (true) {
			nextBluer += dir[cur.dir][0];
			nextBluec += dir[cur.dir][1];

			if (nextBluer < 0 || nextBluer >= map.length || nextBluec < 0 || nextBluec >= map[0].length) {
				return;
			}

			if (map[nextBluer][nextBluec] == 'O') {
				blue = true;
				return;
			}

			if (map[nextBluer][nextBluec] == '#') {
				nextBluer -= dir[cur.dir][0];
				nextBluec -= dir[cur.dir][1];
				break;
			}
		}

		while (true) {
			nextRedr += dir[cur.dir][0];
			nextRedc += dir[cur.dir][1];

			if (nextRedr < 0 || nextRedr >= map.length || nextRedc < 0 || nextRedc >= map[0].length) {
				return;
			}

			if (map[nextRedr][nextRedc] == 'O') {
				red = true;
				return;
			}

			if (map[nextRedr][nextRedc] == '#') {
				nextRedr -= dir[cur.dir][0];
				nextRedc -= dir[cur.dir][1];
				break;
			}
		}

		if (nextRedr == nextBluer && nextRedc == nextBluec) {
			int dis1 = Math.abs(cur.rx - nextRedr + cur.ry - nextRedc);
			int dis2 = Math.abs(cur.bx - nextBluer + cur.by - nextBluec);

			if (dis1 > dis2) {
				nextRedr -= dir[cur.dir][0];
				nextRedc -= dir[cur.dir][1];
			} else {
				nextBluer -= dir[cur.dir][0];
				nextBluec -= dir[cur.dir][1];
			}
		}

		next.rx = nextRedr;
		next.ry = nextRedc;
		next.bx = nextBluer;
		next.by = nextBluec;

	}

	private static void bfs() {

		while (!q.isEmpty()) {
			Ball f = q.poll();

			if (f.cnt > 9) {
				return;
			}

			red = false;
			blue = false;

			for (int i = 0; i < dir.length; i++) {
				move(new Ball(f.rx, f.ry, f.bx, f.by, f.cnt + 1, i));

				if (red) {
					time = f.cnt + 1;
					return;
				}

				if (blue) {
					time = -1;
				}

				if (next.rx < 0 || next.ry < 0 || next.bx < 0 || next.by < 0 || next.rx >= map.length
						|| next.ry >= map[0].length || next.bx >= map.length || next.by >= map[0].length)
					continue;

				if (!visited[next.rx][next.ry][next.bx][next.by]) {
					visited[next.rx][next.ry][next.bx][next.by] = true;
					next.cnt = f.cnt + 1;
					next.dir = i;
					q.offer(new Ball(next.rx, next.ry, next.bx, next.by, next.cnt, next.dir));
				}
			}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tks = new StringTokenizer(bf.readLine());

		int r = Integer.parseInt(tks.nextToken());
		int c = Integer.parseInt(tks.nextToken());

		map = new char[r][c];
		visited = new boolean[r][c][r][c];

		start = new Ball(0, 0, 0, 0, 0, -1);
		next = new Ball(0, 0, 0, 0, 0, 0);

		for (int i = 0; i < r; i++) {
			String str = bf.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					start.rx = i;
					start.ry = j;
				} else if (map[i][j] == 'B') {
					start.bx = i;
					start.by = j;
				}
			}
		}

		q.offer(start);
		visited[start.rx][start.ry][start.bx][start.by] = true;
		bfs();
		System.out.println(time);
	}
}
