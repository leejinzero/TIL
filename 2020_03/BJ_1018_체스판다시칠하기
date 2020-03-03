import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1018_체스판다시칠하기 {
	static char[][] map;

	static int draw(int r, int c) {
		int cnt = 0;
		int cnt2 = 0;
		
		char tem = map[r][c];
		char tem2 = tem=='B'? 'W' : 'B';
		for (int i = r; i < r + 8; i++) {
			for (int j = c; j < c + 8; j+=2) {
				if(tem!=map[i][j]) cnt++;
				if(tem2!=map[i][j]) cnt2++;
			}

			for (int j = c+1; j < c + 8; j+=2) {
				if(tem2!=map[i][j]) cnt++;
				if(tem!=map[i][j]) cnt2++;
			}
			char tem3 =tem;
			tem = tem2;
			tem2 =tem3;
		}
		
		cnt = Math.min(cnt, cnt2);
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tks = new StringTokenizer(bf.readLine());

		int row = Integer.parseInt(tks.nextToken());
		int col = Integer.parseInt(tks.nextToken());

		map = new char[row][col];

		for (int r = 0; r < row; r++) {
			String str = bf.readLine();
			for (int c = 0; c < col; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		int min=Integer.MAX_VALUE;
		
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if(r+8<=row && c+8 <=col) {
					min = Math.min(min, draw(r,c));
				}
			}
		}
		System.out.println(min);

	}

}
