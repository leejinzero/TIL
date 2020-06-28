import java.util.Scanner;

public class JO_1707_달팽이사각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] matrix = new int[N][N];
		int r=0;
		int c=0;
		int into=1;
		int turn =0;
		
		while (into<=N*N) {
			for (; c < N-turn; c++){
				matrix[r][c]=into++;
			}
			c--;
			r++;
			for (; r<N-turn ; r++) {
				matrix[r][c]=into++;
			}
			r--;
			c--;
			for (; c>=turn; c--){
				matrix[r][c]=into++;
			}
			turn++;
			c++;
			r--;
			for (; r>=turn ; r--) {
				matrix[r][c]=into++;
			}
			r++;
			c++;	
		}
		

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
