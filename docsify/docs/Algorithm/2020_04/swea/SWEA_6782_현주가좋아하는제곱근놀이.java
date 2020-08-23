package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_6782_현주가좋아하는제곱근놀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			long N = Long.parseLong(bf.readLine());
			long stand = N;
			long tem=0;
			long stand2 = 0;
			
			while(stand!=2) {
				if(stand==1) {
					tem++;
					break;
				}
				
				if(Math.pow((long)Math.sqrt(stand),2)-stand==0) {
					tem++;
					stand = (long)Math.sqrt(stand);
				}else {
					stand2 = stand;
					stand = (long)Math.sqrt(stand)+1;
					tem += stand*stand - stand2+1;
				}
			}
			
			sb.append(tem).append("\n");
		}
		System.out.println(sb);
	}
}
