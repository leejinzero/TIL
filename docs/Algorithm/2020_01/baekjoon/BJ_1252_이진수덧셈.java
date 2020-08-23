package baekjoon;

import java.util.Scanner;

public class BJ_1252_이진수덧셈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		StringBuilder sb = new StringBuilder();

		if (str1.length() < str2.length()) {
			String tem = str1;
			str1 = str2;
			str2 = tem;
		}

		int maxLen = str1.length();
		int minLen = str2.length();
		int up = 0;
		for (int i = 0; i < minLen; i++) {
			int ch = str1.charAt(str1.length() - 1 - i) - '0';
			int ch2 = str2.charAt(str2.length() - 1 - i) - '0';

			int sum = ch + ch2 + up;

			if (sum >= 2) {
				up = 1;
				sb.append(sum - 2);
			} else {
				sb.append(sum);
				up = 0;
			}
		}

		for (int i = minLen; i < maxLen; i++) {
			int ch = str1.charAt(str1.length() - 1 - i) - '0';
			int sum = ch + up;

			if (sum >= 2) {
				up = 1;
				sb.append(sum - 2);
			} else {
				sb.append(sum);
				up = 0;
			}
		}
		if (up == 1) {
			sb.append(1);
			int i = 0;
			for (i = sb.length() - 1; i >= 0; i--) {
				if (sb.charAt(i) - '0' == 1)
					break;
			}
			if (i < 0) {
				System.out.print("0");
			} else {
				for (int j = i; j >= 0; j--) {
					System.out.print(sb.charAt(j));
				}
			}
		}
	}
}
