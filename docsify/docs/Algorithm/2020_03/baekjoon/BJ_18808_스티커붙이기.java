package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_18808_스티커붙이기 {
	static int R,C,sticker;
	static int[][] map;
	static ArrayList<int[][]> list;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tks = new StringTokenizer(bf.readLine());
		
		R = Integer.parseInt(tks.nextToken());
		C = Integer.parseInt(tks.nextToken());
		sticker = Integer.parseInt(tks.nextToken());
		map = new int[R][C];
		list = new ArrayList<>();
		
		for (int i = 0; i < sticker; i++) {
			tks = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(tks.nextToken());
			int c = Integer.parseInt(tks.nextToken());
			int[][] tem = new int[r][c];
			
			for (int j = 0; j < r; j++) {
				tks = new StringTokenizer(bf.readLine());
				for (int j2 = 0; j2 < c; j2++) {
					tem[j][j2] = Integer.parseInt(tks.nextToken());
				}
			}
			list.add(tem);
		}
		
		dfs(0,0);
		
		System.out.println(result);
	}

	private static void dfs(int index, int dir) {
		if(index==sticker) {
			return ;
		}
		
		if(putSticker(index,dir)) {
			dfs(index+1,0);
		}else {
			if(dir<3) {
				dfs(index,dir+1);
			}else {
				dfs(index+1,0);
			}
		}
	}

	private static boolean putSticker(int index, int dir) {
		if(dir>0) {
			int[][] tem = list.get(index);
			int[][] tem2 = new int[tem[0].length][tem.length];
			
			for (int i = 0; i < tem.length; i++) {
				for (int j = 0; j < tem[0].length; j++) {
					tem2[j][tem.length-1-i] = tem[i][j];
				}
			}
			
			list.add(index, tem2);
			list.remove(index+1);
		}
	
		int r=-1,c=-1;
		int[][] tem = list.get(index);
here:	for (int i = 0; i < R; i++) {
here2:		for (int j = 0; j < C; j++) {
				if(i+tem.length-1>=R || j+tem[0].length-1>=C) continue;
				int nr=i;
				int nc=j;
				
				for (int k = nr; k < nr+tem.length; k++) {
					for (int k2 = nc; k2 < nc+tem[0].length; k2++) {
						if(tem[k-nr][k2-nc]==1 && map[k][k2] == 1) {
							continue here2;
						}
					}
				}
				
				r=i;
				c=j;
				break here;
			}
		}
		
		if(r==-1 && c==-1) return false;
		else {
			
			for (int i = r; i < r+tem.length; i++) {
				for (int j = c; j < c+tem[0].length; j++) {
					if(tem[i-r][j-c]==1) {
						map[i][j] = 1;
						result++;
					}
				}
			}
			
			return true;
		}
	}
}
