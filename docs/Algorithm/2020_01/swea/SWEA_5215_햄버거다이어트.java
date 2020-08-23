package swea;

import java.util.Scanner;

public class SWEA_5215_햄버거다이어트 {
	static int[] cal_list= new int[20];
	static int[] good_list =new int[20];
	
	public static int findMaxHappy(int t2, int cal_limit) {
		int max=Integer.MIN_VALUE;
		
		for(int j=0; j< (1<<cal_list.length);j++) {
			int sum=0,good=0;
			for (int i = 0; i < t2; i++) {
				if( (j&(1<<i)) == (1<<i)) {
					sum+=cal_list[i];
					good+=good_list[i];
					if(sum<=cal_limit && max<good) {
						max=good;
					}
				}
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		StringBuilder sb= new StringBuilder();
		Scanner scanner= new Scanner(System.in);
		
		int t1= scanner.nextInt();
		
		for(int i=1;i<=t1;i++) {
			int t2= scanner.nextInt();
			int cal_limit= scanner.nextInt();
			sb.append("#").append(i).append(" ");
			
			for(int j=0; j<t2;j++) {
				good_list[j]=scanner.nextInt();
				cal_list[j]=scanner.nextInt();
				}
			
			sb.append(findMaxHappy(t2,cal_limit)).append("\n");
		}	
		
		System.out.println(sb);
		
	}
	
}
