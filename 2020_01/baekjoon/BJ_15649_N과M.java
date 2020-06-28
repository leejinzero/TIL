package baekjoon;

import java.util.Scanner;

public class BJ_15649_N과M {
	
	static int[] list = new int[10];
	static boolean[] trueTest = new boolean[10];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int range = scanner.nextInt();
		int len = scanner.nextInt();
		
		permutation(0,range,len);
	}
	
	public static void permutation(int index, int range, int len) {
		if(index==len) {
			for (int i = 0; i < len; i++) {
				System.out.print(list[i]);
				if(i!=len-1) System.out.print(" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <=range; i++) {
			if(!trueTest[i]) {
				list[index]=i;
				trueTest[i] =true;
				permutation(index+1,range,len);
				trueTest[i]=false;
			}			
		}				
	}
}
