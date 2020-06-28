package swea;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1234_비밀번호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		for (int tc = 1; tc <=10; tc++) {
			int len =sc.nextInt();
			String src = sc.next();
			Stack<Integer> stack = new Stack<>();
			
			for (int i = 0; i < len; i++) {
				if(stack.isEmpty()) stack.push(src.charAt(i)-'0');
				else {
					Integer tem = stack.peek();
					if(tem==src.charAt(i)-'0') stack.pop();
					else {
						stack.push(src.charAt(i)-'0');
					}
				}
				
			}
			int k=0;
			int[] arr = new int[stack.size()];
			System.out.print("#"+tc +" ");
			while(!stack.isEmpty()) {
				arr[k++]=stack.pop();
			}
			
			for (int i = arr.length-1; i >=0; i--) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}

	}

}
