import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_7965_퀴즈{

	public static long sigma(long n,long r){
		if(r==1) {
			return n;
		}
		if(r%2==1) {
			long tem =sigma(n, r/2);
			return (n*tem%1000000007)*(tem)%1000000007;
		}else {
			long tem =sigma(n, r/2);
			return (tem*tem)%1000000007;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));	
		int T = Integer.parseInt(bf.readLine());		
		
		for (int tc = 1; tc <= T; tc++) {
			long n = Integer.parseInt(bf.readLine());
			long tem=0;
			for (long i = 1; i <=n; i++) {
				tem= (tem+sigma(i,i))%1000000007;
			}
			System.out.println("#"+tc+" "+tem);
		}
		
	}

}
