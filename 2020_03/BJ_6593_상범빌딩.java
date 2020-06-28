import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6593_상범빌딩 {

	static char[][][] map;
	static boolean[][][] visited;
	static int[][] dir = { { 0, 0, 1 }, { 0, 0, -1 }, { 0, 1, 0 }, { 0, -1, 0 }, { 1, 0, 0 }, { -1, 0, 0 } };
	static Point start;
	static StringBuilder sb = new StringBuilder();

	static class Point {
		int row, col, floor, time;

		public Point(int row, int col, int floor, int time) {
			this.row = row;
			this.col = col;
			this.floor = floor;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", floor=" + floor + "]";
		}
	}

	public static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.offer(start);
		visited[start.floor][start.row][start.col] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(map[p.floor][p.row][p.col] == 'E') {
				sb.append("Escaped in "+p.time+" minute(s).").append("\n");
				return ;
			}
			
			for (int i = 0; i < dir.length; i++) {
				int nf = p.floor + dir[i][0];
				int nr = p.row + dir[i][1];
				int nc = p.col + dir[i][2];
				
				if (isIn(nf, nr, nc) && !visited[nf][nr][nc]) {
					if(map[nf][nr][nc] == '.' || map[nf][nr][nc] == 'E') {
						q.offer(new Point(nr,nc,nf, p.time+1));
						visited[nf][nr][nc] = true;
					}
					
				}

			}
		}
		sb.append("Trapped!").append("\n");
	}

	private static boolean isIn(int nf, int nr, int nc) {
		return nf >= 0 && nr >= 0 && nc >= 0 && nf < map.length && nr < map[0].length && nc < map[0][0].length;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer tks = new StringTokenizer(bf.readLine());

			int floor = Integer.parseInt(tks.nextToken());
			int row = Integer.parseInt(tks.nextToken());
			int col = Integer.parseInt(tks.nextToken());

			if (floor == 0 && row == 0 && col == 0)
				break;

			map = new char[floor][row][col];
			visited = new boolean[floor][row][col];

			for (int i = 0; i < floor; i++) {
				for (int r = 0; r < row; r++) {
					String str = bf.readLine();
					for (int c = 0; c < col; c++) {
						map[i][r][c] = str.charAt(c);
						if (map[i][r][c] == 'S') {
							start = new Point(r, c, i,0);
						}
					}
				}
				bf.readLine();
			}
			bfs(start);
		}
		System.out.println(sb);
	}
}
