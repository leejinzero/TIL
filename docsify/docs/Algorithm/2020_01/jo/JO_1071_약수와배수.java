package jo;

import java.util.Scanner;

public class JO_1071_약수와배수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] arr = new int[len];
		
		for (int i = 0; i < len; i++) {
			arr[i] = sc.nextInt();
		}
		
		int stand = sc.nextInt();
		int modsum =0, mutisum=0;
		
		for (int i = 0; i < arr.length; i++) {
			if(stand % arr[i]==0) {
				modsum+=arr[i];
			}
			if(arr[i] % stand==0) {
				mutisum+=arr[i];
			}
		}
		
		System.out.println(modsum);
		System.out.println(mutisum);
	}

}
