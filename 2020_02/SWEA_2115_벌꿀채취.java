import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2115_벌꿀채취 {
	static int max;
	static int[][] honey;
	static int cnt;
	static int limit;
	static int mapsize;
	static boolean[][] visited;

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

	public static void find_max() {
		List<Point> max_list = new ArrayList<>();
		for (int r = 0; r < mapsize; r++) {
here: for (int c = 0; c < mapsize; c++) {
				List<Point> candidate = new ArrayList<>();
				int nc = c;
				int sum = 0;
				for (int i = 0; i < cnt; i++) {
					nc = c+ i;
					if (nc >= mapsize || visited[r][nc])
						continue here;
					sum += honey[r][nc];
					candidate.add(new Point(r, nc));
					
				}

				if(sum<=limit) {
					int result = 0;
					for (int i = 0; i < candidate.size(); i++) {
						int tem = honey[candidate.get(i).row][candidate.get(i).col];
						result += tem * tem;
					}
					if(max<result) {
						max_list = candidate;
						max =result;
					}
				}else {
here2:	for (int i = 0; i < (1<<candidate.size()); i++) {
						List<Integer> subset = new ArrayList<>();
						int max_sum=0;
						for (int j = 0; j < candidate.size(); j++) {
							if((i&1<<j)>0) {
								max_sum +=honey[candidate.get(j).row][candidate.get(j).col];
								if(max_sum>limit) continue here2;
								subset.add(honey[candidate.get(j).row][candidate.get(j).col]);
							}
						}
						
						int result=0;
						for (int j = 0; j < subset.size(); j++) {
							int tem = subset.get(j);
							result += tem * tem;
						}
						if(max<result) {
							max_list = candidate;
							max =result;
						}
					}	
				}	
			}
		}
			
		for (int i = 0; i < max_list.size(); i++) {
			visited[max_list.get(i).row][max_list.get(i).col] = true;
		}	
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer tokens = new StringTokenizer(bf.readLine());

			mapsize = Integer.parseInt(tokens.nextToken());
			honey = new int[mapsize][mapsize];
			visited = new boolean[mapsize][mapsize];
			cnt = Integer.parseInt(tokens.nextToken());
			limit = Integer.parseInt(tokens.nextToken());

			for (int i = 0; i < honey.length; i++) {
				tokens = new StringTokenizer(bf.readLine());
				for (int j = 0; j < honey.length; j++) {
					honey[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}

			int result = 0;
			for (int i = 0; i < 2; i++) {
				max =0;
				find_max();
				result+=max;
			}	
			System.out.println("#" + tc + " " + result);
		}
	}
}
