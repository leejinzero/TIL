package baekjoon;

import java.util.Scanner;

public class BJ_1629_곱셈 {
	public static long pow(int a, int b, int divide) {
		if(b==1) return a%divide;
		else if(b%2==1) {
			long tem =pow(a,b/2,divide);
			return (a*tem%divide)*(tem)%divide;
		}else {
			long tem =pow(a,b/2,divide);
			return (tem)*(tem)%divide;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int divide = sc.nextInt();
		
		System.out.println(pow(a,b,divide));
	}
}
