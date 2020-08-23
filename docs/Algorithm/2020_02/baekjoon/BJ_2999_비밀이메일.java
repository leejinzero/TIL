package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class BJ_2999_비밀이메일 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int len = s.length();
		Stack<Integer> stack = new Stack<>();

		for (int i = 1; i < len; i++) {
			if (len % i == 0) {
				if (len / i < i)
					break;
				stack.push(i);
			}
		}
		int r = stack.pop();
		int c = len / r;

		char[][] map = new char[r][c];

		int count = 0;
		for (int i = 0; i < c; i++) {
			for (int k = 0; k < r; k++) {
				map[k][i] = s.charAt(count++);
			}
		}
		for (int i = 0; i < r; i++) {
			for (int k = 0; k < c; k++) {
				System.out.print(map[i][k]);
			}
		}

	}
}
