import java.util.Scanner;

public class SWEA_3307_최장증가수열 {

	public static int findMaxLen(int[] arr) {
		int[] counts =new int[arr.length];
		int maxlen=0,count, value;
		
		for (int i = 0; i < arr. length; i++) {
			count = counts[i];
			value = arr[i];
			for (int j = i; j < arr.length; j++) {
				if(value > arr[j]) continue;
				if(count+1 <= counts[j]) continue;
				counts[j]=count+1;
				if(maxlen< count+1) maxlen=count+1;
			}
			
		}
		
		return maxlen;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++) {
			sb.append("#").append(i).append(" ");
			int len = sc.nextInt();
			int[] arr = new int[len];
			for (int j = 0; j < len; j++) {
				arr[j] = sc.nextInt();
			}
			sb.append(findMaxLen(arr)).append("\n");
		}	
		System.out.println(sb);
	}
}
