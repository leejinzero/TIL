import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074_Z {
	static int count=-1;
	static int row;
	static int col;
	static boolean flag=false;
	
	public static void cut(int len,int r, int c) {
		if(len == 2) {
			for (int i = r; i < r+2; i++) {
				for (int j = c; j < c+2; j++) {
					++count;
					if(i== row && j==col) {
						flag= true;
						return;
					}
				}
			}
			return ;
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if(!flag) {
					cut(len/2, r+len/2*i ,c+len/2*j);
				}else {
					return;
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(bf.readLine());
		
		int size = Integer.parseInt(tokens.nextToken());
		row = Integer.parseInt(tokens.nextToken());
		col = Integer.parseInt(tokens.nextToken());

		cut((int) Math.pow(2,size), 0,0);		
		System.out.println(count);
		
	}

}
