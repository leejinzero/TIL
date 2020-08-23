package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4530_극한의청소작업 {
	static long stand[] = new long[13];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb= new StringBuilder();
		
		stand[0]= 1;
		for (int i = 1; i <= 12; i++) {
			stand[i] = stand[i-1]*9 + (long)Math.pow(10, i);
		}
		
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer tks = new StringTokenizer(bf.readLine());
			
			long S = Long.parseLong(tks.nextToken());
			long E = Long.parseLong(tks.nextToken());
			
			long result = 0;
			
			if(E>0) {
				if(S<0) {
					result = E-S-find(-S)-find(E)-1;			
					
				}else {
					result = E-S-find(E)+find(S);				
				}
			}else {
				result =-S+E+find(-E)-find(-S);	
			}
			
			sb.append(result).append("\n");
			
		}
		System.out.println(sb);
	}

	
	private static long find(long num) {
		long cnt = 0;
		
		int jarisu = (int)Math.log10(num);
		
		for (int i = jarisu; i>=0; i--) {
			long tem= num/((long)Math.pow(10,i));
			
			if(i==0) {
				if(tem>4) {
					cnt++;
				}
				break;
			}
			
			if(tem<4) {
				cnt+= tem*stand[i-1];
			}else {
				cnt+= (tem-1)*stand[i-1]+(long)Math.pow(10, i);
			}
			
			num%=(long)Math.pow(10,i);
		}
		
		return cnt;
	}
}
