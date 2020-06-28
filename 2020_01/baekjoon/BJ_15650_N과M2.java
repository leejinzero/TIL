package baekjoon;

import java.util.Scanner;

public class BJ_15650_N과M2 {
	
	public static void nmTest(int[] arr,boolean[] visited,int[] perArr, int index, int len, int before) {
		if(index==len) {
			for (int i = 0; i < perArr.length; i++) {
				System.out.print(perArr[i]+" ");
			}
			System.out.println();
			return ;
		}
		
		for (int i = before; i < arr.length; i++) {
			if(!visited[i]) {
				visited[i]=true;
				perArr[index]=arr[i];
				nmTest(arr,visited, perArr,index+1,len,i);
				visited[i]=false; 
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int range = sc.nextInt();
		int len = sc.nextInt();
		int[] perArr =new int[len];
		int[] arr = new int[range];
		boolean[] visited = new boolean[range];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=i+1;
		}
 		
		nmTest(arr,visited,perArr,0,len,0);
	}

}
