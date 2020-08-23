package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1652_누울자리를찾아라 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		char[][] map = new char[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = bf.readLine().toCharArray();
		}

		int row = 0;
		int col = 0;
		boolean flagR = false;
		boolean flagC = false;

		for (int i = 0; i < N; i++) {
			flagC = false;
			flagR = false;
			for (int j = 0; j < N-1; j++) {
				if (!flagC && map[j][i] == '.' && map[j+1][i] == map[j][i]) {
					flagC= true;
					col++;
				}
				if(map[j][i]=='X') flagC=false;	
				
				if (!flagR && map[i][j] == '.' && map[i][j] == map[i][j+1]) {
					flagR= true;
					row++;
				}
				
				if(map[i][j]=='X') flagR =false;

			}

		}

		System.out.println(row + " " + col);

	}

}
