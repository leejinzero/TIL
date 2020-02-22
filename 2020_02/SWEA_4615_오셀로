import java.util.Scanner;

public class SWEA_4615_오셀로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dx = {0,0,-1,1,1,-1,1,-1};
		int[] dy = {-1,1,0,0,1,-1,-1,1};
		
		for (int tc = 1; tc <=T; tc++) {
			int answer1 =0;
			int answer2 =0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map =new int[N+1][N+1];
			
			map[N/2][N/2]=2;
			map[N/2+1][N/2+1]=2;
			map[N/2][N/2+1]=1;
			map[N/2+1][N/2]=1;
			
			for (int i = 0; i < M; i++) {
				int row = sc.nextInt();
				int col = sc.nextInt();
				int type = sc.nextInt();
				
				map[row][col]=type;
				
				for (int j = 0; j < 8; j++) {
					boolean flag = false;
					int nx = row+dx[j];
					int ny = col+dy[j];
					while(isIn(nx,ny,N) && map[nx][ny]!=type) {
						if(map[nx][ny]==0) {
							flag=false;
							break;
						}
						flag=true;
						nx+=dx[j];
						ny+=dy[j];
					}
					if(flag==true && isIn(nx,ny,N)) {
						nx=row+dx[j];
						ny=col+dy[j];
						while(map[nx][ny]!=type) {
							map[nx][ny]=type;
							nx+=dx[j];
							ny+=dy[j];
						}
					}
				}
				
			}
			
			for (int r = 1; r <=N; r++) {
				for (int c = 1; c <=N; c++) {
					if(map[r][c]==1) answer1++;
					else if(map[r][c]==2) answer2++;
				}
			}

			System.out.println("#"+tc+ " "+ answer1 +" " + answer2);
		}

	}

	private static boolean isIn(int row, int col,int N) {
		return row>=1 && row<=N && col>=1 && col<=N;
	}
}
