package baekjoon;

import java.util.Scanner;

public class BJ_9625_BABBA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int time = sc.nextInt();

		int Anum = 1;
		int Bnum = 0;

		for (int i = 0; i < time; i++) {
			if (Anum >= 1 && Bnum >= 1) {
				int tem = Anum;
				int tem2 = Bnum;
				Anum -= tem;
				Bnum += tem;
				Anum += tem2;
			} else if (Anum >= 1) {
				int tem = Anum;
				Anum -= tem;
				Bnum += tem;
			} else {
				Anum += Bnum;
			}

		}

		System.out.println(Anum + " " + Bnum);

	}

}
