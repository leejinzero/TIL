package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author leejinyoung
 * @Date  Aug 20, 2020
 * @Language java
 * @Memory 	13568KB
 * @RunningSpeed 96ms
 * @Description 문제만 똑바로 읽자^^
 * 
 */
public class BJ_8979_올림픽 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tks = new StringTokenizer(bf.readLine());
		int size = Integer.parseInt(tks.nextToken());
		int order = Integer.parseInt(tks.nextToken()) - 1;

		int[][] country = new int[size][4];
		int[] stand = new int[4];

		for (int i = 0; i < size; i++) {
			tks = new StringTokenizer(bf.readLine());
			int current = Integer.parseInt(tks.nextToken())-1;
			
			for (int j = 1; j < 4; j++) {
				if (current== order)
					stand[j] = Integer.parseInt(tks.nextToken());
				else
					country[current][j] = Integer.parseInt(tks.nextToken());
			}
		}

		int cnt = 1;
		for (int i = 0; i < size; i++) {
			
			if(order==i) continue;
	
			for (int j = 1; j < 4; j++) {
				if (country[i][j] > stand[j]) {
					cnt++;
					break;
				}else if(country[i][j]<stand[j]) {
					break;
				}
			}

		}
		
		System.out.println(cnt);

	}

}
