import java.util.Scanner;

public class BJ_16987_계란으로계란치기 {
	static Scanner sc = new Scanner(System.in);
	static int T = sc.nextInt();

	public static void main(String[] args) {
		int[][] egg = new int[T][2];
		
		for (int i = 0; i < T; i++) {
			egg[i][0]=sc.nextInt();
			egg[i][1]=sc.nextInt();
		}
		
		egghits(egg,0);
		System.out.println(max);
		
	}
	
	static int max= 0;
	private static void egghits(int[][] egg, int index) {
		
		if(index == T) {
			int cnt=0;
			for (int j = 0; j < egg.length; j++) {
				if(egg[j][0]<=0) cnt++;
			}
			
			if(max<cnt) max = cnt;
			
			return ;
		}
		if(egg[index][0]<=0) {
			egghits(egg, index+1);
			return ;
		}
		
		boolean flag= false;
		
		for (int i = 0; i < egg.length; i++) {
			if(i==index || egg[i][0]<=0) continue;
			
			flag= true;
			egg[index][0]-=egg[i][1];
			egg[i][0]-=egg[index][1];

			egghits(egg,index+1);
				
			egg[index][0]+=egg[i][1];
			egg[i][0]+=egg[index][1];
		}
		
		if(flag==false) egghits(egg,index+1);
		
	}
	
}
