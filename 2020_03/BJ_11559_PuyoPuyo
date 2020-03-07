import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_11559_PuyoPuyo {
	static char[][] map;
	static boolean[][] visited;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static List<Point> dfs_list;

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

	private static void dfs(int r, int c) {

		for (int i = 0; i < dir.length; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];

			if (nr >= 0 && nr < 12 && nc >= 0 && nc < 6 && !visited[nr][nc] && map[nr][nc] == map[r][c]) {
				visited[nr][nc] = true;
				dfs_list.add(new Point(nr, nc));
				dfs(nr, nc);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];

		for (int i = 0; i < 12; i++) {
			String str = bf.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int popCnt = 0;
		List<List<Point>> pop;

		do {
			visited = new boolean[12][6];
			// 터지는 리스트
			pop = new ArrayList<>();
			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (!visited[i][j] && map[i][j] != '.') {
						dfs_list = new ArrayList<>();
						dfs_list.add(new Point(i, j));
						visited[i][j] = true;
						dfs(i, j);

						// 4개이상이면 터지는 리스트에 추가
						if (dfs_list.size() >= 4) {
							pop.add(dfs_list);
						}

					}
				}
			}
      
      			//바뀌는 열 리스트
			List<Integer> col = new ArrayList<>();
			//터진거 점으로 바꾸기
     			if (pop.size() > 0) {
				popCnt++;
				for (int j = 0; j < pop.size(); j++) {
					List<Point> dfs_list2 = pop.get(j);

					for (int k = 0; k < dfs_list2.size(); k++) {
						Point tem = dfs_list2.get(k);
						map[tem.row][tem.col] = '.';
						if (!col.contains(tem.col)) {
							col.add(tem.col);
						}
					}					
				}
				
				// 내려주기
				for (int c = 0; c < col.size(); c++) {
					int c1 = col.get(c);

					while (true) {
						int r = 11;
						for (int k = 11; k >= 0; k--) {
							if (map[k][c1] == '.') {
								r = k;
								break;
							}
						}
            
						for (int l = r - 1; l >= 0; l--) {
							if (map[l][c1] != '.') {
								for (int j2 = l; j2 >= 0; j2--) {
									map[r--][c1] = map[j2][c1];
									map[j2][c1] = '.';
								}
								break;
							}
						}
            
            					//중간에 점 끼여있는지 검사 (다 내려갔는지?)
						boolean flag = false;
						for (int k = 0; k < 12; k++) {
							if (map[k][c1] != '.') {
								for (int i = k + 1; i < 12; i++) {
									if (map[i][c1] == '.') {
										flag = true;
									}
								}
							}
						}
            
            					//다 내려갔다면 통과
						if (!flag) break;
					}
				}
			}
		} while (pop.size() > 0);

		System.out.println(popCnt);
	}
}
