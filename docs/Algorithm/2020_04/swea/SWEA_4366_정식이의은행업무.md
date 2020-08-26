package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4366_정식이의은행업무 {
	private static int answer;
	private static char[] two;
	private static char[] three;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			two = bf.readLine().toCharArray();
			three = bf.readLine().toCharArray();

			answer = 0;
			go();

			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}

	private static void go() {
		int size = two.length;

		int tem2 = calcthree();
		
		for (int i = 0; i < size; i++) {
			if (two[i] == '0')
				two[i] = '1';
			else
				two[i] = '0';

			int tem1 = calctwo();
			int diff = Math.abs(tem1 - tem2);
			int diff2 = diff % 2 == 0 ? diff / 2 : diff;
			int root = (int) (Math.log10(diff2)/Math.log10(3));

			if (diff == 1 || diff == 2 || diff2 == Math.pow(3, root)) {
				answer = tem1;

				return;
			}
			if (two[i] == '0')
				two[i] = '1';
			else
				two[i] = '0';
		}
	}

	private static int calctwo() {
		int size = two.length;
		int s = 1;
		int total = 0;
		for (int j = size - 1; j >= 0; j--) {
			total += s * (two[j] - '0');
			s *= 2;
		}
		return total;
	}

	private static int calcthree() {
		int size = three.length;
		int s = 1;
		int total = 0;
		for (int j = size - 1; j >= 0; j--) {
			total += s * (three[j] - '0');
			s *= 3;
		}
		return total;
	}

}
