import java.util.Scanner;

public class BJ_17466_N팩과ModP1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int P = sc.nextInt();
		long nmg=1;
		
		
		if(N==P-1) {
			System.out.println(N);
		}else {
			for (int i = 2; i <= N; i++) {
				nmg=nmg*(i%P);
				nmg=nmg%P;
			}
			System.out.println(nmg);			
		}	
	}
}
