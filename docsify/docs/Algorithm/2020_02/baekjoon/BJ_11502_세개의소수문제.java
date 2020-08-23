package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_11502_세개의소수문제 {
	private static int count=0;
	
	public static void permutation(List<Integer> arr,int[] perArr, int index, int len, int P,int before) {
		if(index==len) {
			if(isTrue(perArr,P)) {
				count++;
				for (int i = 0; i < perArr.length; i++) {
					System.out.print(perArr[i]+" ");
				}
				System.out.println();
			}	
				return ;
			}
			
			for (int i = 0; i < arr.size(); i++) {
				if(isTrue(perArr,P)) return;
				perArr[index]=arr.get(i);
				permutation(arr,perArr,index+1,len,P,i);
			}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		int[] Plist  = new int[N];
		
		list.add(2);
		for (int i = 3; i < 1000; i++) {
			int j;
			for (j = 2; j < i; j++) {
				if(i%j==0) break;
			}
			if(j==i) list.add(i);	
		}
		
		for (int i = 0; i < N; i++) {
			Plist[i] = sc.nextInt();
		}
		
		for (int i = 0; i < Plist.length; i++) {
			int[] perArr = new int[3];
			count=0;
			permutation(list, perArr,0,3,Plist[i],0);
			if(count==0) System.out.println("0");
		}

	}
	

	private static boolean isTrue(int[] perArr, int P) {
		
		int sum=0;
		for (int i = 0; i < perArr.length; i++) {
			sum+=perArr[i];
		}
		
		if(sum==P) return true;
		else return false;
	}
}
