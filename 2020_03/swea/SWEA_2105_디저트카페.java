package swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2105_디저트카페 {

	static int max = -1;
	static int[][] map;
	static int[][] dir = { { 1, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 } };
	static boolean[][] visited;
	static boolean[] dessert = new boolean[101];

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	private static boolean dfs(Point start, int w, int h) {
		int nr = start.r;
		int nc = start.c;
		int d = 0;
		dessert = new boolean[101];

		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < w; i++) {
				nr += dir[d][0];
				nc += dir[d][1];
				if (!isIn(nr, nc) || dessert[map[nr][nc]])
					return false;
				dessert[map[nr][nc]] = true;
			}
			d++;
			for (int i = 0; i < h; i++) {
				nr += dir[d][0];
				nc += dir[d][1];
				if (!isIn(nr, nc) || dessert[map[nr][nc]])
					return false;
				dessert[map[nr][nc]] = true;
			}
			d++;
		}
		return true;
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < map.length && nc >= 0 && nc < map.length;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bf.readLine().trim());
			map = new int[N][N];
			visited = new boolean[N][N];
			int stand = N -2;
			
			for (int r = 0; r < N; r++) {
				StringTokenizer tks = new StringTokenizer(bf.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(tks.nextToken());
				}
			}

			max = -1;
here:		for (int i = stand; i >= 1; i--) {
				for (int j = stand; j >= 1; j--) {
					if(max< (i+j)*2) {
						for (int r = 0; r < N - 2; r++) {
							for (int c = 1; c < N - 1; c++) {
								visited = new boolean[N][N];
								if (dfs(new Point(r, c), i, j)) {
									max = Math.max(max, (i + j) * 2);
									continue here;
								}
							}
						}
					}
				}
			}

			System.out.println("#" + tc + " " + max);
		}

	}

}
