package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @Author leejinyoung
 * @Date 2020. 5. 16.
 * @Language java
 * @Memory 23,164KB
 * @RunningSpeed 129ms
 * @Description 시간별로 각각 다 따져줘야하는 시뮬레이션,, 복잡,,
 * 
 */
public class SWEA_5644_무선충전 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader bf = new BufferedReader(new StringReader(str));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer tks = new StringTokenizer(bf.readLine());

			int M = Integer.parseInt(tks.nextToken());
			int A = Integer.parseInt(tks.nextToken());

			int[][] move = new int[2][M + 1];

			for (int i = 0; i < 2; i++) {
				tks = new StringTokenizer(bf.readLine());
				move[i][0] = 0;
				for (int j = 1; j <= M; j++) {
					move[i][j] = Integer.parseInt(tks.nextToken());
				}
			}

			ArrayList<BC> bclist = new ArrayList<>();
			for (int i = 0; i < A; i++) {
				tks = new StringTokenizer(bf.readLine());
				int r = Integer.parseInt(tks.nextToken());
				int c = Integer.parseInt(tks.nextToken());
				int cnt = Integer.parseInt(tks.nextToken());
				int p = Integer.parseInt(tks.nextToken());
				bclist.add(new BC(c, r, p, cnt));

			}

			int cnt = 0;
			int nr1 = 1;
			int nc1 = 1;
			int nr2 = 10;
			int nc2 = 10;
			int size = bclist.size();

			for (int k = 0; k <= M; k++) {
				nr1 += dir[move[0][k]][0];
				nc1 += dir[move[0][k]][1];
				nr2 += dir[move[1][k]][0];
				nc2 += dir[move[1][k]][1];
				ArrayList<Integer> a = new ArrayList<>();
				ArrayList<Integer> b = new ArrayList<>();

				for (int i = 0; i < size; i++) {
					BC bc = bclist.get(i);
					if (Math.abs(bc.r - nr1) + Math.abs(bc.c - nc1) <= bc.cnt) {
						a.add(i);
					}
					
					if (Math.abs(bc.r - nr2) + Math.abs(bc.c - nc2) <= bc.cnt) {
						b.add(i);
					}
				}
				
				
				int maxa = 0;
				int maxb = 0;
				int res = 0;

				if (!a.isEmpty() && b.isEmpty()) {
					for (int j = 0; j < a.size(); j++) {
						maxa = Math.max(maxa, bclist.get(a.get(j)).p);
					}
					res=maxa;
				} 
				
				else if (a.isEmpty() && !b.isEmpty()) {
					for (int j = 0; j < b.size(); j++) {
						maxb = Math.max(maxb, bclist.get(b.get(j)).p);
					}
					res=maxb;

				} else {
					for (int j = 0; j < a.size(); j++) {
						for (int l = 0; l < b.size(); l++) {
							maxa = bclist.get(a.get(j)).p;
							maxb = bclist.get(b.get(l)).p;
							
							if (a.get(j) == b.get(l)) {
								maxa /= 2;
								maxb /= 2;
							}

							if (maxa + maxb > res) {
								res = maxa + maxb;
							}

						}
					}
				}

				cnt += res;
			}
			sb.append(cnt).append("\n");

		}

		System.out.println(sb);
	}

	static int[][] dir = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static class BC {
		int r, c, p, cnt;

		public BC(int r, int c, int p, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.p = p;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "BC [r=" + r + ", c=" + c + ", p=" + p + ", cnt=" + cnt + "]";
		}

	}

	private static String str = "5\r\n" + "20 3\r\n" + "2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3\r\n"
			+ "4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3\r\n" + "4 4 1 100\r\n" + "7 10 3 40\r\n" + "6 3 2 70\r\n"
			+ "40 2\r\n" + "0 3 0 3 3 2 2 1 0 4 1 3 3 3 0 3 4 1 1 3 2 2 2 2 2 0 2 3 2 2 3 4 4 3 3 3 2 0 4 4 \r\n"
			+ "0 1 0 3 4 0 4 0 0 1 1 1 0 1 4 4 4 4 4 3 3 3 0 1 0 4 3 2 1 4 4 3 2 3 2 2 0 4 2 1 \r\n" + "5 2 4 140\r\n"
			+ "8 3 3 490\r\n" + "60 4\r\n"
			+ "0 3 3 3 0 1 2 2 2 1 2 2 3 3 4 4 0 3 0 1 1 2 2 3 2 2 3 2 2 0 3 0 1 1 1 4 1 2 3 3 3 3 3 1 1 4 3 2 0 4 4 4 3 4 0 3 3 0 3 4 \r\n"
			+ "1 1 4 1 1 1 1 1 1 4 4 1 2 2 3 2 4 0 0 0 4 3 3 4 3 3 0 1 0 4 3 0 4 3 2 3 2 1 2 2 3 4 0 2 2 1 0 0 1 3 3 1 4 4 3 0 1 1 1 1 \r\n"
			+ "6 9 1 180\r\n" + "9 3 4 260\r\n" + "1 4 1 500\r\n" + "1 3 1 230\r\n" + "80 7\r\n"
			+ "2 2 2 2 2 2 0 2 2 0 4 0 2 3 3 2 3 3 0 3 3 3 4 3 3 2 1 1 1 0 4 4 4 1 0 2 2 2 1 1 4 1 2 3 4 4 3 0 1 1 0 3 4 0 1 2 2 2 1 1 3 4 4 4 4 4 4 3 2 1 4 4 4 4 3 3 3 0 3 3 \r\n"
			+ "4 4 1 1 2 1 2 3 3 3 4 4 4 4 4 1 1 1 1 1 1 1 1 0 3 3 2 0 4 0 1 3 3 3 2 2 1 0 3 2 3 4 1 0 1 2 2 3 2 0 4 0 3 4 1 1 0 0 3 2 0 0 4 3 3 4 0 4 4 4 4 0 3 0 1 1 4 4 3 0 \r\n"
			+ "4 3 1 170\r\n" + "10 1 3 240\r\n" + "10 5 3 360\r\n" + "10 9 3 350\r\n" + "9 6 2 10\r\n"
			+ "5 1 4 350\r\n" + "1 8 2 450\r\n" + "100 8\r\n"
			+ "2 2 3 2 0 2 0 3 3 1 2 2 2 2 3 3 0 4 4 3 2 3 4 3 3 2 3 4 4 4 2 2 2 0 2 2 4 4 4 4 1 1 1 2 2 2 4 3 0 2 3 3 4 0 0 1 1 4 1 1 1 1 2 2 1 1 3 3 3 0 3 2 3 3 0 1 3 3 0 1 1 3 3 4 0 4 1 1 2 2 4 0 4 1 1 2 2 1 1 1 \r\n"
			+ "4 4 4 0 4 1 1 4 1 1 1 1 3 2 1 2 1 1 4 4 1 0 2 3 4 4 4 4 4 0 1 0 2 2 2 0 2 2 2 2 2 2 3 0 0 1 4 3 3 2 0 0 4 4 4 0 2 0 4 1 1 2 2 0 4 4 0 0 2 0 2 3 3 0 2 3 0 3 4 0 4 3 4 4 3 4 1 1 2 2 2 0 0 1 0 4 1 1 1 4 \r\n"
			+ "3 4 2 340\r\n" + "10 1 1 430\r\n" + "3 10 4 10\r\n" + "6 3 4 400\r\n" + "7 4 1 80\r\n" + "4 5 1 420\r\n"
			+ "4 1 2 350\r\n" + "8 4 4 300\r\n" + "";
}
