import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_15683_감시 {
	static int R,C;
	static int zero;
	static int max;
	static int[][] map;
	static ArrayList<Camera> list = new ArrayList<>();
	static int[][] dir = { {1,0},{-1,0},{0,-1},{0,1} };
	static class Camera{
		int r,c,cnt;

		public Camera(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	private static void copy(boolean[][] visited2, boolean[][] visited) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				visited2[i][j] = visited[i][j];
			}
		}
	}
	
	private static void pick(int start, int total, boolean[][] visited) {
		if(start==list.size()) {
			max = Math.max(max, total);
			return ;
		}
		
		switch(list.get(start).cnt) {
			case 1:
				int[] dirNum = new int[1];
				
				for (int i = 0; i < 4; i++) {
					boolean[][] visited2 = new boolean[R][C];
					dirNum[0] = i;
					copy(visited2,visited);
					int tem =go(list.get(start), dirNum, visited);
					pick(start+1, total+tem, visited);
					copy(visited,visited2);
				}
				
				break;
			case 2:
				dirNum = new int[2];
				
				for (int i = 0; i < 4; i+=2) {
					boolean[][] visited2 = new boolean[R][C];
					dirNum[0] = i;
					dirNum[1] = i+1;
					copy(visited2,visited);
					int tem =go(list.get(start), dirNum, visited);
					pick(start+1, total+tem, visited);
					copy(visited,visited2);
				}
				break;
			case 3:
				dirNum = new int[2];
				for (int i = 0; i < 4; i++) {
					for (int j = i+1; j < 4; j++) {
						if( (i==0 && j==1) || (i==2 && j==3)) continue;
						dirNum[0]=i;
						dirNum[1]=j;
						boolean[][] visited2 = new boolean[R][C];
						copy(visited2,visited);
						int tem =go(list.get(start), dirNum, visited);
						pick(start+1, total+tem, visited);
						copy(visited,visited2);
					}
				}
				break;
			case 4:
				dirNum = new int[3];
				for (int i = 0; i < 4; i++) {
					for (int j = i+1; j < 4; j++) {
						for (int k = j+1; k < 4; k++) {
							dirNum[0]=i;
							dirNum[1]=j;
							dirNum[2]=k;
							boolean[][] visited2 = new boolean[R][C];
							copy(visited2,visited);
							int tem =go(list.get(start), dirNum, visited);
							pick(start+1, total+tem, visited);
							copy(visited,visited2);
						}
					}
				}
				break;
			case 5:
				dirNum= new int[4];
				for (int i = 0; i < 4; i++) {
					dirNum[i]=i;
				}
				int tem =go(list.get(start), dirNum, visited);
				pick(start+1, total+tem, visited);
				break;
		}
	}
	
	private static int go(Camera c,int[] dirNum, boolean[][] visited) {
		int look = 0;
			for (int i = 0; i < dirNum.length; i++) {
				int nr = c.r;
				int nc = c.c;
				nr+=dir[dirNum[i]][0];
				nc+=dir[dirNum[i]][1];
				while(isIn(nr,nc) && map[nr][nc]!=6) {
					if(!visited[nr][nc] && map[nr][nc] ==0) {
						look++;
						visited[nr][nc] =true;
					}
					nr+=dir[dirNum[i]][0];
					nc+=dir[dirNum[i]][1];
				}
			}
		return look;
	}
	
	
	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<C;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tks = new StringTokenizer(bf.readLine());
		
		R = Integer.parseInt(tks.nextToken());
		C = Integer.parseInt(tks.nextToken());
		
		map = new int[R][C];
		boolean[][] visited = new boolean[R][C];
		
		for (int r = 0; r < R; r++) {
			tks = new StringTokenizer(bf.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(tks.nextToken());
				if(map[r][c] !=0 && map[r][c]!=6) {
					list.add(new Camera(r,c,map[r][c]));
				}
				if(map[r][c] == 0) zero++;
			}
		}
		
		pick(0,0,visited);
		
		System.out.println(zero-max);

	}

}
