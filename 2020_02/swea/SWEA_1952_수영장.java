package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1952_수영장 {
	static int money=Integer.MAX_VALUE;
	
	public static void find_min(int[] ticket, int[] month) {
		
		money = Math.min(money, ticket[3]);
		
		for (int i = 0; i < (1<<12); i++) {
			List<Integer> three = new ArrayList<>();
			List<Integer> nmg = new ArrayList<>();
			
			for (int j = 0; j < 12; j++) {
				if((i&1<<j)>0) {
					three.add(j);
					j+=2;
				}else {
					nmg.add(j);
				}
			}
			
			for (int j = 0; j < (1<<nmg.size()); j++) {
				int sum=three.size()*ticket[2];
				List<Integer> one = new ArrayList<>();
				List<Integer> daily = new ArrayList<>();
				
				for (int j2 = 0; j2 < nmg.size(); j2++) {
					if((j& 1<<j2)>0) {
						one.add(nmg.get(j2));
					}else {
						daily.add(nmg.get(j2));
					}
				}
				
				sum+=one.size()*ticket[1];
				for (int k = 0; k < daily.size(); k++) {
					sum+=month[daily.get(k)]*ticket[0];
				}	
				money = Math.min(money, sum);
			}	
		}	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer tokens = new StringTokenizer(bf.readLine());
			int[] ticket = new int[4];
			
			for (int i = 0; i < 4; i++) {
				ticket[i] = Integer.parseInt(tokens.nextToken());
			}
			
			tokens = new StringTokenizer(bf.readLine());
			
			int[] month = new int[12];
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(tokens.nextToken());
			}
			
			money=Integer.MAX_VALUE;
			find_min(ticket, month);
						
			System.out.println("#"+tc+" "+money);
		}
	}
}
