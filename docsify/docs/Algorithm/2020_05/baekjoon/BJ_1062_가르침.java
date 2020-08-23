package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1062_가르침 {
	private static String stand;
	private static String[] list;
	private static int max=0;
	private static boolean[] masking;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tks = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(tks.nextToken());
		int K = Integer.parseInt(tks.nextToken());
		
		masking = new boolean[26];
		stand ="atnci";
		
		for (int i = 0; i < stand.length(); i++) {
			masking[stand.charAt(i)-'a']= true;
		}
			
		if(K<5) {
			System.out.println(0);
			System.exit(0);
		}
		
		
		list = new String[N];
		for (int i = 0; i < N; i++) {			
			list[i]=bf.readLine();
		}
		combi(0,0,K-5);
		System.out.println(max);

	}

	
	private static void combi(int idx,int before, int len) {
		if(idx==len) {						
			int cnt=0;
			for (int i = 0; i < list.length; i++) {
				int start=4;
				int end = list[i].length()-4;
				int j=0;
				for (j = start; j < end; j++) {
					if(!masking[list[i].charAt(j)-'a']) {
						break;
					}
				}
				if(j==end) cnt++;
			}		
			max=Math.max(max, cnt);
			return;
		}
		
		for (int i = before; i < 26; i++) {
			if(!masking[i]) {
				masking[i] = true;
				combi(idx+1,i+1,len);
				masking[i]= false;
			}
			
		}
		
	}

}
