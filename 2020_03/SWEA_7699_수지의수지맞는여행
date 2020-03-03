import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7699_수지의수지맞는여행 {
	static char[][] map;
	static int max;
	static boolean[] alphabet;

	static class Point {
		int row, col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	
	static void dfs(Point p, int cnt) {
		if(cnt > max) {
			max = cnt;
		}
		if(max==26) return;
		
		for (int i = 0; i < dir.length; i++) {
			int nr = p.row + dir[i][0];
			int nc = p.col + dir[i][1];

			if (isIn(nr, nc) && !alphabet[map[nr][nc]-'A']) {
				alphabet[map[nr][nc]-'A'] = true;
				dfs(new Point(nr,nc), cnt+1);
				alphabet[map[nr][nc]-'A'] = false;
			}
		}

	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer tks = new StringTokenizer(bf.readLine());
			int row = Integer.parseInt(tks.nextToken());
			int col = Integer.parseInt(tks.nextToken());

			map = new char[row][col];
			for (int i = 0; i < map.length; i++) {
				String str = bf.readLine();
				for (int j = 0; j < map[0].length; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			alphabet = new boolean[26];
			max = 0;
			alphabet[map[0][0]-'A'] = true;
			dfs(new Point(0,0), 1);

			System.out.println("#" + tc + " " + max);
		}
	}
}
