package baekjoon;

import java.util.Scanner;

public class BJ_14501_퇴사 {
	static int max;
	static int date;
	
	static void combi(int datesum, int moneysum) {	
		
		if(datesum >= date) {
			if(max< moneysum) {
				max=moneysum;
			}
			return;
		}
		
		for (int j = datesum; j < map.length; j++) {
			if(j+map[j][0] > date) {
				combi(j+map[j][0], moneysum);
			}
			else {
				combi(j+map[j][0], moneysum+map[j][1]);
			}
		}
		
	}

	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		date = sc.nextInt();
		map = new int[date][2];
		
		for (int i = 0; i < date; i++) {
			map[i][0]=sc.nextInt();
			map[i][1]=sc.nextInt();
		}
		
		for (int i = 0; i < map.length; i++) {
			combi(i,0);
		}
		System.out.println(max);
	}

}
