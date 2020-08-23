package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11728_배열합치기{
	
	static int[] result ;
	public static void merge(int[] arr1 ,int[] arr2) {
		int index1 = 0;
		int index2 = 0;
		int index3=0;
		
		while(index1<arr1.length && index2<arr2.length) {
			if(arr1[index1]<arr2[index2]) {
				result[index3++]=arr1[index1++];
			}else {
				result[index3++]=arr2[index2++];
			}
		}
		while(index1<arr1.length) {
			result[index3++]=arr1[index1++];
		}
		while(index2<arr2.length) {
			result[index3++]=arr2[index2++];
		}				
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		int col1 = Integer.parseInt(tokens.nextToken());
		int col2= Integer.parseInt(tokens.nextToken());
		int[] arr1 =new int[col1];
		int[] arr2 =new int[col2];
		result =new int[col1+col2];
		
		tokens = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < arr1.length; i++) {
			arr1[i]=Integer.parseInt(tokens.nextToken());
		}

		tokens = new StringTokenizer(bf.readLine());
		for (int i = 0; i < arr2.length; i++) {
			arr2[i]=Integer.parseInt(tokens.nextToken());
		}
		
		merge(arr1,arr2);
		
		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]+" ");
		}
		
		System.out.println(sb);
	}

}
