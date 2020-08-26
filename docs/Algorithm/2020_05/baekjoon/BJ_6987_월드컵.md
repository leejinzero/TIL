package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author leejinyoung
 * @date 2020. 5. 6.
 * @description brute force
 * 
 */
public class BJ_6987_월드컵 {

	private static int[][] table;
	private static boolean flag;
	private static ArrayList<Pair> team;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String answer = "";
		table = new int[6][3];
		
		team = new ArrayList<Pair>();
		for (int k = 0; k < 5; k++) {
			for (int j = k+1; j < 6; j++) {
				team.add(new Pair(k,j));
			}
		}
		
here:	for (int i = 0; i < 4; i++) {
			StringTokenizer tks = new StringTokenizer(bf.readLine());
			
			for (int j = 0; j < 6; j++) {
				table[j][0]= Integer.parseInt(tks.nextToken());
				table[j][1]= Integer.parseInt(tks.nextToken());
				table[j][2]= Integer.parseInt(tks.nextToken());				
				
				if(table[j][0]+table[j][1]+table[j][2]>5) {
					answer+="0 ";
					continue here;
				}
			
			}
			
			flag = false;
			dfs(0);
			
			if(flag) answer+="1 ";
			else answer+="0 ";
		}
		
		System.out.println(answer);
		
	}
	
	static class Pair{
		int a,b;

		public Pair(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Pair [a=" + a + ", b=" + b + "]";
		}
		
	}
	
	private static void dfs(int total) {
		//flag true라면 더볼 필요없음
		if(flag) return;
		
		//끝까지 갔다면 가능한 case
		if(total==15) {
			flag = true;
			return ;
		}
		
		//a팀이 이길때
		if(table[team.get(total).a][0]>0 && table[team.get(total).b][2]>0) {
			table[team.get(total).a][0]--;
			table[team.get(total).b][2]--;
			dfs(total+1);
			table[team.get(total).a][0]++;
			table[team.get(total).b][2]++;			
		}
		
		//비길때
		if(table[team.get(total).a][1]>0 && table[team.get(total).b][1]>0) {
			table[team.get(total).a][1]--;
			table[team.get(total).b][1]--;
			dfs(total+1);
			table[team.get(total).a][1]++;
			table[team.get(total).b][1]++;
		}
		
		//b팀이 이길때
		if(table[team.get(total).a][2]>0 && table[team.get(total).b][0]>0) {
			table[team.get(total).a][2]--;
			table[team.get(total).b][0]--;
			dfs(total+1);
			table[team.get(total).a][2]++;
			table[team.get(total).b][0]++;
		}
	
	}

}
