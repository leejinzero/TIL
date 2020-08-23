package baekjoon;

import java.util.Scanner;

public class BJ_3985_롤케이크 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();
		int[] cake = new int[L + 1];
		int maxCnt = 0;
		int index = 0;

		for (int i = 1; i <= N; i++) {
			int p = sc.nextInt();
			int k = sc.nextInt();

			if (maxCnt < k - p + 1) {
				maxCnt = k - p + 1;
				index = i;
			}
			for (int j = p; j <= k; j++) {
				if (cake[j] == 0)
					cake[j] = i;
			}
		}

		int[] count = new int[N + 1];
		for (int i = 1; i < cake.length; i++) {
			count[cake[i]]++;
		}

		int max = 0;
		int index2 = 0;
		for (int i = 1; i < count.length; i++) {
			if (max < count[i]) {
				max = count[i];
				index2 = i;
			}
		}
		System.out.println(index);
		System.out.println(index2);

	}

}
