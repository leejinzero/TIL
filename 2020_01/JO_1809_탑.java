import java.util.Scanner;
import java.util.Stack;

public class JO_1809_탑 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i]= sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			if(stack.isEmpty()) {
				System.out.print("0 ");
				stack.push(i+1);
			}else {
				Integer tem = stack.peek();
				if(arr[tem-1]<arr[i]) {
					while(arr[tem-1]<arr[i]) {
						stack.pop();
						if(stack.isEmpty()) break;
						tem = stack.peek();
						
					}
					if(stack.isEmpty()) System.out.print("0 ");
					else{
						Integer tem2 = stack.peek();
						System.out.print(tem2+" ");
					}
					stack.push(i+1);
						
				}else {
					System.out.print(tem+" ");
					stack.push(i+1);
				}
			}
		}
		
	}

}
