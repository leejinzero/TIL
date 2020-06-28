import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2817_부분수열의합{
	
	public static int subsetSum(int[] arr,int target) {
		int cnt=0;
		
		for (int i = 0; i < (1<<arr.length); i++) {
			int sum=0;
			for (int j = 0; j < arr.length; j++) {
				if((i &1<<j)>0) {
					sum+=arr[j];
				}
			}
			
			if(sum==target) cnt++;
		}

		return cnt;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		StringTokenizer tokens;
		
		for (int tc = 1; tc <= T; tc++) {
			 tokens = new StringTokenizer(bf.readLine());
			 int n = Integer.parseInt(tokens.nextToken());
			 int[] arr= new int[n];
			 int target = Integer.parseInt(tokens.nextToken());
			 
			 tokens = new StringTokenizer(bf.readLine());
			 for (int i = 0; i < n; i++) {
				arr[i]=Integer.parseInt(tokens.nextToken());
				}
			 
			 System.out.print("#" + tc +" ");
			 System.out.println(subsetSum(arr,target));
		}
		
		

	}

}
