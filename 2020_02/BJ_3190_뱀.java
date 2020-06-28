import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point{
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

public class BJ_3190_뱀 {
	static int mapsize;
	static int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static boolean isIn(int x, int y) {
		return x>0 && x< mapsize+1 && y>0 && y<mapsize+1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		mapsize = Integer.parseInt(bf.readLine());
		int apple = Integer.parseInt(bf.readLine());
		int[][] map = new int[mapsize+1][mapsize+1];
		int break_time=0;
		
		StringTokenizer tokens; 
		for (int i = 0; i < apple; i++) {
			tokens = new StringTokenizer(bf.readLine()); 
			int row = Integer.parseInt(tokens.nextToken());
			int col = Integer.parseInt(tokens.nextToken());		
			map[row][col]=1;
		}
		
		int turn = Integer.parseInt(bf.readLine());
		int[] turn_time = new int[turn];
		char[] turn_dir = new char[turn];
		
		for (int i = 0; i < turn; i++) {
			tokens = new StringTokenizer(bf.readLine()); 
			turn_time[i] = Integer.parseInt(tokens.nextToken());
			turn_dir[i] =tokens.nextToken().charAt(0);
		}
		
		int j=0;
		int head_row=1;
		int head_col=1;
		int tail_row=1;
		int tail_col=1;
		int head_dir=0;
		int size=1;
		boolean[][] visited = new boolean[mapsize+1][mapsize+1];
		List<Point> path = new ArrayList<>();

		while(true) {
			if(break_time == turn_time[j]) {
				if(turn_dir[j]=='L') {
					head_dir--;
					if(head_dir==-1) head_dir=3;
				}
				else {
					head_dir++;
					if(head_dir==4) head_dir=0;
				}
				j++;
				if(j==turn) j--;
			}
			path.add(new Point(head_row,head_col));
			visited[head_row][head_col] =true;
			int nr = head_row+d[head_dir][0];
			int nc = head_col+d[head_dir][1];
			break_time++;
			
			if(!isIn(nr,nc) || visited[nr][nc]) {
				System.out.println(break_time);
				break;
			}		
			
			if(map[nr][nc]==0 && size==1) {
				visited[tail_row][tail_col] =false;
				tail_row=nr;
				tail_col=nc;
			}
			
			if(map[nr][nc]==0 && size>1) {
				visited[tail_row][tail_col] =false;
				tail_row = path.get(path.size()-size+1).row;
				tail_col = path.get(path.size()-size+1).col;
			}
			
			if(map[nr][nc]==1){
				map[nr][nc]=0;
				size++;
			}
			
			head_row = nr;
			head_col = nc;
		}	
	}
}
