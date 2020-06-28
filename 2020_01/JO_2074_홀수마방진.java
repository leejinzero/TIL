import java.util.Scanner;

public class JO_2074_홀수마방진 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] matrix = new int[N][N];
		int into=1;
		matrix[0][N/2]=into;
		int row=0;
		int col=N/2;
		
		while(into<N*N) {
			if(into%N==0) {
				into++;
				row++;
				matrix[row][col]=into;
			}else{
				if(col-1<0 && row-1<0) {
					row=N-1;
					col=N-1;
					into++;
					matrix[row][col]=into;
				}else if(col-1<0) {
					col=N-1;
					row--;
					into++;
					matrix[row][col]=into;
				}else if(row-1<0) {
					row=N-1;
					col--;
					into++;
					matrix[row][col]=into;
				}else {
					row--;
					col--;
					into++;
					matrix[row][col]=into;
				}
			}
			
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		

	}

}
