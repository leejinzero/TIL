package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13458_시험감독 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testroom = Integer.parseInt(bf.readLine());
		StringTokenizer tokens = new StringTokenizer(bf.readLine());
		int[] student = new int[testroom];
		long min_director = testroom;
	
		for (int i = 0; i < testroom; i++) {
			student[i] = Integer.parseInt(tokens.nextToken());
		}
		
		tokens = new StringTokenizer(bf.readLine());		
		int main = Integer.parseInt(tokens.nextToken());
		int sub = Integer.parseInt(tokens.nextToken());
		
		for (int i = 0; i < testroom; i++) {
			student[i] = student[i]- main;		
			if(student[i]>0) {
				if(student[i]%sub==0) {
					min_director+= student[i]/sub;
				}
				else {
					min_director+= student[i]/sub+1;
				}
			}
		}	
		System.out.println(min_director);
	}

}
