package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16236_아기상어 {
	static int[][] map;
	static int time;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static Point shark = null;
	static int fish;

	static class Point implements Comparable<Point> {
		int r, c, s, cnt, eat;

		public Point(int r, int c, int s, int cnt) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", s=" + s + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(Point o) {
			Integer r1 = this.r;
			Integer r2 = o.r;

			if (r1.equals(r2)) {
				Integer c1 = this.c;
				Integer c2 = o.c;

				return c1.compareTo(c2);
			}

			return r1.compareTo(r2);
		}

	}

	public static void bfs() {
		Queue<Point> p = new LinkedList<>();
		p.offer(shark);
		visited = new boolean[map.length][map.length];
		visited[shark.r][shark.c] = true;
		PriorityQueue<Point> pq = new PriorityQueue<>();

		while (!p.isEmpty()) {
			Point f = p.poll();

			if (f.s != 0 && f.s < shark.s) {
				if (!pq.isEmpty()) {
					Point tem = pq.peek();
					if (tem.cnt < f.cnt)
						break;
				}
				pq.offer(f);

			}

			for (int i = 0; i < dir.length; i++) {
				int nx = f.r + dir[i][0];
				int ny = f.c + dir[i][1];

				if (isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] <= shark.s) {
					p.offer(new Point(nx, ny, map[nx][ny], f.cnt + 1));
					visited[nx][ny] = true;
				}
			}
		}

		if(pq.isEmpty()) {
			System.out.println(time);
			System.exit(0);
		}
		
		Point pick = pq.poll();
		shark.eat++;
		shark.r = pick.r;
		shark.c = pick.c;
		shark.cnt = pick.cnt;
		map[pick.r][pick.c] = 0;
		if (shark.eat == shark.s) {
			shark.s++;
			shark.eat = 0;
		}

	}

	private static boolean isIn(int nx, int ny) {
		return nx >= 0 && nx < map.length && ny >= 0 && ny < map.length;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			StringTokenizer tks = new StringTokenizer(bf.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(tks.nextToken());
				if (map[r][c] == 9) {
					shark = new Point(r, c, 2, 0);
					map[r][c] = 0;
					shark.eat = 0;
				}
			}
		}
    
		boolean flag = true;
		while (flag) {
			bfs();
			time += shark.cnt;
			shark.cnt = 0;
		}
		
	}
}
