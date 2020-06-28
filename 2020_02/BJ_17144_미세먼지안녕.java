import java.util.Scanner;

public class BJ_17144_미세먼지안녕 {

	static int[][] map;
	static int[][] mapCopy;
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static int[][] dir2 = {{1,0},{0,1},{-1,0},{0,-1}};
	static int airRow;
	
	public static void airfresh() {	
		int r= airRow;
		int c =0;
		int i =0;
		while(true) {
			int nr = r+dir[i][0];
			int nc = c+ dir[i][1];
			
			while(isIn(nr,nc)) {
				int tem = mapCopy[r][c];
				mapCopy[r][c] = mapCopy[nr][nc];
				mapCopy[nr][nc]=tem;
				r=nr;
				c=nc;
				nr+=dir[i][0];
				nc+=dir[i][1];
				if(nr==airRow+1) break;
			}
			i++;
			if(i==dir.length) break;
		}
		mapCopy[airRow][1]=0;
				
		r= airRow+1;
		c =0;
		i =0;
		while(true) {
			int nr = r+dir2[i][0];
			int nc = c+ dir2[i][1];
			
			while(isIn(nr,nc)) {
				int tem = mapCopy[r][c];
				mapCopy[r][c] = mapCopy[nr][nc];
				mapCopy[nr][nc]=tem;
				r=nr;
				c=nc;
				nr+=dir2[i][0];
				nc+=dir2[i][1];
				if(nr==airRow) break;
			}
			i++;
			if(i==dir2.length) break;
		}
		mapCopy[airRow+1][1]=0;	
	}
	
	public static void spread() {
		
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				if(map[r][c]/5>0){
					int cnt =0;
					
					for (int i = 0; i < dir.length; i++) {
						int nr= r+dir[i][0];
						int nc =c+dir[i][1];
												
						if(isIn(nr,nc) && mapCopy[nr][nc]!=-1) {
							cnt++;
							mapCopy[nr][nc]+=map[r][c]/5;
						}
					}
					mapCopy[r][c]-=(map[r][c]/5)*cnt;
				}
			}
		}
		
	}
	
	public static void copymap(int[][] map,int[][] mapCopy) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				mapCopy[r][c] = map[r][c];
			}

		}
	}
	
	public static void printmap() {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				System.out.print(mapCopy[r][c]+ " ");
			}
			System.out.println();
		}
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && r<map.length && c>=0 && c<map[0].length;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		int time =sc.nextInt();
		
		map = new int[row][col];
		mapCopy = new int[row][col];
		
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				map[r][c]=sc.nextInt();
				mapCopy[r][c]=map[r][c];
				if(map[r][c] ==-1) airRow =r-1;
			}
		}
		
		for (int t = 0; t < time; t++){
			spread();
			airfresh();
			copymap(mapCopy,map);
		}
		
		int sum=0;
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				if(map[r][c] !=-1) {
					sum+=mapCopy[r][c];
				}
			}
		}
		
		System.out.println(sum);
	}

}
