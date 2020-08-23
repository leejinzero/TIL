package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11729_하노이탑이동순서 {
	static StringBuilder sb= new StringBuilder();
	static int count;
	
	public static void hano(int N,int from, int by, int to) {
		count++;
		if(N==1) {
			sb.append(from).append(" ").append(to).append("\n");
			return;
		}
		else {
			hano(N-1,from,to,by);
			sb.append(from).append(" ").append(to).append("\n");
			hano(N-1,by,from,to);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());

		hano(N,1,2,3);
		System.out.println(count);
		System.out.println(sb);
	}

}
