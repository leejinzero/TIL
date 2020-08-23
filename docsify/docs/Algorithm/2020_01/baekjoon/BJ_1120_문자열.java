package baekjoon;

import java.util.Scanner;

public class BJ_1120_문자열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		String M = sc.next();
		
		int cnt = M.length()-N.length();
		int min=Integer.MAX_VALUE;
		
		for (int i = 0; i <cnt+1; i++) {
			int diff=0;
			int k=0;
			for (int j = i; j < i+N.length(); j++) {
				if(N.charAt(k)!=M.charAt(j)) diff++;
				k++;
			}
			
			if(diff<min) min=diff;
		}
		
		System.out.println(min);
	}

}
