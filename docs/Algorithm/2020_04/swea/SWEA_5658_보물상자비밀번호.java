package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SWEA_5658_보물상자비밀번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer tks = new StringTokenizer(bf.readLine());
			
			int N = Integer.parseInt(tks.nextToken());
			int K = Integer.parseInt(tks.nextToken());
			
			int stand = N/4;
			
			String str = bf.readLine();
			
			TreeSet<Integer> tset = new TreeSet<>();
			
			for (int i = 1; i < stand; i++) {
				String tem1 = str.substring(N-stand+i,N)+str.substring(0,i);
				tset.add(Integer.parseInt(tem1, 16));
			}
					
			for (int i = 0; i < N-stand; i++) {
				String tem3= str.substring(i,i+stand);
				tset.add(Integer.parseInt(tem3, 16));
			}
			
			String tem4 = str.substring(N-stand,N);
			tset.add(Integer.parseInt(tem4, 16));

			int size = tset.size();
			int index = 0;
			for(Integer t : tset) {
				if(index==size-K) {
					sb.append(t).append("\n");
					break;
				}
				
				index++;
			}			
		}

		System.out.println(sb);
	}

}
