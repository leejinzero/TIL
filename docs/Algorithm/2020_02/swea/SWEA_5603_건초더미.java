package swea;
import java.util.Scanner;

public class SWEA_5603_건초더미 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			int answer=0;
			int count = sc.nextInt();
			int sum = 0;
			int avg=0;
			int[] arr = new int[count];
			
			
			for (int j = 0; j < count; j++) {
				arr[j]=sc.nextInt();
				sum+=arr[j];
			}
			
			avg=sum/count;
			
			for (int j = 0; j < count; j++) {
				if(avg<arr[j]) answer+= arr[j]-avg;
			}
			
			System.out.println("#"+i+" "+ answer);
		}

	}

}
