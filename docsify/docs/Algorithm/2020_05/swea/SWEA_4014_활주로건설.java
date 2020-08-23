package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author leejinyoung
 * @Date  May 29, 2020
 * @Language java
 * @Memory 26,428 kb	
 * @RunningSpeed 133ms
 * @Description 복잡하게 생각했다가 말렸던 문제 ㅠㅠ 상황별로 나눠서 조건만 잘따져주자!
 * 
 */
public class SWEA_4014_활주로건설 {

	private static int[][] map;
	private static int pos;
	private static int N;
	private static int X;

	public static void main(String[] args) throws IOException {
		//BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader bf = new BufferedReader(new StringReader(str));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer tks = new StringTokenizer(bf.readLine());
			// 맵크기, 경사로 길이
			N = Integer.parseInt(tks.nextToken());
			X = Integer.parseInt(tks.nextToken());

			// 맵
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				tks = new StringTokenizer(bf.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tks.nextToken());
				}
			}

			// 가능한 경우의 수
			pos = 0;
			
			for (int i = 0; i < N; i++) {
				int[] line= new int[N];
				if(check(map[i]))pos++;
				for (int j = 0; j < N; j++) {
					line[j]=map[j][i];
				}
				if(check(line)) pos++;
			}

			sb.append(pos).append("\n");

		} // end of T
		System.out.println(sb);

	}
	
	
	

	private static boolean check(int[] line) {
		
		int conti = 1;
		int stand = line[0];
		boolean need= false;
		for (int i = 1; i < N; i++) {
						
			if(stand==line[i]) {
				conti++;
				if(need && conti>=X) {
					need=false;
					conti=0;
				}
			}
			
			else if(stand<line[i]) {
				if(need) return false;
				
				if(line[i]!=stand+1) return false;
				
				if(conti>=X) {
					conti=1;
					stand=line[i];
					continue;
				}else {
					return false;
				}	
			}
			else if(stand>line[i]){
				if(need) return false;
				
				if(line[i]!=stand-1) return false;
				
				need=true;
				conti=1;
				stand=line[i];
				
			}
			
		}
		
		if(need && conti<X) return false;
		
		//System.out.println(Arrays.toString(line));
		return true;
	}




	private static String str = "1\n" +
			"10 2\n" + 
			"2 2 3 5 3 1 1 1 1 1 \n" + 
			"2 2 3 5 3 1 1 1 1 1 \n" + 
			"3 3 4 5 4 3 2 1 1 2 \n" + 
			"3 3 4 5 4 3 2 1 1 2 \n" + 
			"5 5 5 5 5 5 3 1 1 3 \n" + 
			"4 4 4 5 5 5 4 3 3 3 \n" + 
			"4 4 4 5 5 5 5 5 5 3 \n" + 
			"4 4 4 4 4 5 5 5 5 3 \n" + 
			"4 4 4 4 4 5 5 5 5 3 \n" + 
			"5 5 4 4 4 5 5 5 5 4 \n" +
			"6 2\n" + 
			"3 3 3 2 1 1\n" + 
			"3 3 3 2 2 1\n" + 
			"3 3 3 3 3 2\n" + 
			"2 2 3 2 2 2\n" + 
			"2 2 3 2 2 2\n" + 
			"2 2 2 2 2 2\n" + 
			"6 4\n" + 
			"3 2 2 2 1 2 \n" + 
			"3 2 2 2 1 2 \n" + 
			"3 3 3 3 2 2 \n" + 
			"3 3 3 3 2 2 \n" + 
			"3 2 2 2 2 2 \n" + 
			"3 2 2 2 2 2 \n" + 
			"7 2\n" + 
			"1 1 1 1 2 1 1 \n" + 
			"1 1 1 2 2 2 1 \n" + 
			"2 2 2 2 2 2 2 \n" + 
			"2 2 2 2 2 2 2 \n" + 
			"2 2 2 2 2 2 2 \n" + 
			"2 2 2 2 2 2 2 \n" + 
			"2 2 2 2 2 2 2 \n" + 
			"8 3\n" + 
			"2 2 2 3 3 4 2 2 \n" + 
			"2 2 2 3 3 4 2 2 \n" + 
			"2 2 2 2 2 2 2 2 \n" + 
			"2 2 2 2 2 2 2 2 \n" + 
			"2 2 2 2 1 1 2 2 \n" + 
			"2 1 1 1 1 1 1 1 \n" + 
			"2 1 1 1 1 1 1 1 \n" + 
			"2 1 1 1 1 1 1 1 \n" + 
			"8 4\n" + 
			"1 1 1 1 1 1 1 1 \n" + 
			"1 1 1 1 1 1 1 1 \n" + 
			"1 1 1 1 1 1 1 1 \n" + 
			"2 1 1 1 1 1 1 1 \n" + 
			"2 1 1 1 1 1 1 1 \n" + 
			"2 1 1 1 1 1 1 1 \n" + 
			"1 1 1 1 1 1 1 2 \n" + 
			"1 1 1 1 1 1 1 2 \n" + 
			"9 4\n" + 
			"4 4 3 3 3 3 2 2 2 \n" + 
			"4 4 3 3 1 1 2 2 3 \n" + 
			"3 3 2 2 1 1 1 1 2 \n" + 
			"1 1 1 1 1 1 1 1 1 \n" + 
			"1 1 1 1 1 1 1 1 1 \n" + 
			"2 2 1 1 1 1 1 1 1 \n" + 
			"2 2 1 1 1 1 1 1 1 \n" + 
			"2 2 2 2 2 2 1 1 1 \n" + 
			"3 3 3 3 2 2 2 2 1 \n" +  
			"12 4\n" + 
			"4 4 4 5 5 4 4 4 4 4 4 4 \n" + 
			"5 5 5 5 5 5 5 5 5 5 5 4 \n" + 
			"4 4 4 5 5 4 4 4 5 5 5 4 \n" + 
			"3 3 4 5 5 4 3 4 5 5 5 4 \n" + 
			"3 3 4 5 5 4 3 4 5 5 5 4 \n" + 
			"2 2 3 4 4 4 4 4 4 4 4 5 \n" + 
			"2 2 3 4 4 4 4 4 4 4 4 5 \n" + 
			"2 2 3 3 3 4 5 3 2 2 4 4 \n" + 
			"3 3 3 4 4 4 5 4 3 3 4 4 \n" + 
			"3 3 4 5 5 5 5 5 5 5 5 4 \n" + 
			"3 3 4 5 5 5 5 5 5 5 5 4 \n" + 
			"4 4 4 4 4 4 5 5 5 5 5 4 \n" + 
			"15 3\n" + 
			"5 4 4 3 3 3 2 2 2 3 4 4 4 4 4 \n" + 
			"5 4 4 3 3 3 2 2 2 3 4 4 4 4 4 \n" + 
			"5 5 5 5 4 4 2 2 3 4 4 4 4 4 5 \n" + 
			"5 4 4 3 3 3 2 2 3 4 4 4 4 4 4 \n" + 
			"5 3 3 1 2 2 3 3 3 4 4 4 4 4 4 \n" + 
			"3 3 3 3 3 3 3 3 3 3 4 4 4 4 4 \n" + 
			"3 3 3 3 3 3 3 3 3 3 4 4 4 4 4 \n" + 
			"2 3 3 4 3 3 3 3 3 3 3 4 4 4 3 \n" + 
			"2 3 3 4 3 3 3 3 3 3 3 4 4 4 3 \n" + 
			"3 4 4 4 4 4 3 3 3 3 3 3 4 4 4 \n" + 
			"5 5 5 4 4 4 4 4 3 3 3 3 4 4 5 \n" + 
			"5 5 5 4 4 4 4 4 3 3 3 3 4 4 5 \n" + 
			"5 5 5 5 4 4 4 4 3 3 2 2 3 3 4 \n" + 
			"5 5 5 5 5 5 4 4 3 3 2 1 2 2 3 \n" + 
			"5 5 5 5 5 5 4 4 3 3 2 1 2 2 3 \n" + 
			"20 3\n" + 
			"3 3 3 2 2 2 2 3 3 3 4 4 4 4 4 4 5 5 5 5 \n" + 
			"3 3 3 2 2 2 2 3 3 3 4 4 4 4 4 4 5 5 5 5 \n" + 
			"5 3 3 2 2 2 2 2 3 3 4 4 4 4 5 5 5 5 5 5 \n" + 
			"4 3 3 1 1 1 1 1 2 3 4 4 4 5 5 5 5 5 5 5 \n" + 
			"4 2 2 1 1 1 1 1 2 3 4 5 5 5 5 5 5 5 5 5 \n" + 
			"4 3 3 2 2 2 2 1 2 3 4 5 5 5 5 5 5 5 5 5 \n" + 
			"4 4 4 4 4 3 3 2 3 4 5 5 5 5 5 5 5 5 5 5 \n" + 
			"4 3 3 3 3 3 3 3 4 4 4 5 5 5 5 5 5 4 4 4 \n" + 
			"4 3 3 3 3 3 3 3 4 4 4 5 5 5 5 5 5 4 4 4 \n" + 
			"4 3 3 3 3 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 \n" + 
			"3 3 3 3 3 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 \n" + 
			"3 3 3 3 3 4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 \n" + 
			"3 3 3 3 4 4 4 4 5 5 5 5 5 5 5 5 5 5 5 5 \n" + 
			"4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 4 4 4 \n" + 
			"4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 4 4 4 \n" + 
			"5 5 5 5 5 5 5 5 5 5 5 5 4 4 4 4 4 4 4 4 \n" + 
			"5 5 5 5 5 5 5 5 5 5 5 5 3 3 3 3 4 4 4 4 \n" + 
			"5 5 5 5 5 5 5 5 5 5 5 5 3 3 2 2 3 3 4 4 \n" + 
			"5 5 5 5 5 5 5 5 5 5 5 5 3 3 2 2 3 3 4 4 \n" + 
			"5 5 5 5 5 5 5 5 4 4 4 4 3 3 3 3 4 4 4 4 \n" + 
			"";
			
		
}
