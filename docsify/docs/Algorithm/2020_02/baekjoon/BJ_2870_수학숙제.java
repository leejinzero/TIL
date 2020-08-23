package baekjoon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BJ_2870_수학숙제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<String> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				String tem = "";
				if (str.charAt(j) - 'a' < 0) {
					tem += str.charAt(j);
					int t = j + 1;
					while (t < str.length() && str.charAt(t) - 'a' < 0) {
						tem += str.charAt(t);
						t++;
					}
					j = t;
					if (tem.length() > 1 && tem.charAt(0) == '0') {
						int k = 1;
						while (k < tem.length() && tem.charAt(k) == '0') {
							k++;
						}
						if (k == tem.length())
							tem = "0";
						else
							tem = tem.substring(k);
					}
					list.add(tem);
				}
			}
		}
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				Integer len1 = o1.length();
				Integer len2 = o2.length();
				if (len1 == len2) {
					return o1.compareTo(o2);

				} else {
					return len1.compareTo(len2);
				}

			}

		});

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
