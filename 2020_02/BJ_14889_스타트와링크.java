import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14889_스타트와링크 {	
	static int[] team1;
	static int[] team2;
	static int N;
	static int[][] power;
	static int[] two1 = new int[2];
	static int[] two2 = new int[2];
	static int s1=0;
	static int s2=0;
	static int min = Integer.MAX_VALUE;
	
	public static void combi2(int index,int before) {
		if(index==2) {
			s1+=power[two1[0]][two1[1]]+power[two1[1]][two1[0]];
			s2+=power[two2[0]][two2[1]]+power[two2[1]][two2[0]];		
			return ;
		}
		
		for (int i = before; i < team1.length; i++) {
				two1[index]=team1[i];
				two2[index]= team2[i];
				combi2(index+1, i+1);
		}
		
	}
	
	public static void combi(int index,int before) {
		if(index==N/2) {
			boolean flag = true;
			int k=0;
			for (int i = 1; i <=N; i++) {
				flag =true;
				for (int j = 0; j < team1.length; j++) {
					if(team1[j]==i) flag= false;
				}
				if(flag) team2[k++]=i;
			}
			
			s1=0;
			s2=0;
			combi2(0,0);	
			min = Math.min(min, Math.abs(s1-s2));
			
			return ; 
		}
		
		for (int i = before; i <= N; i++) {
			team1[index]=i;
			combi(index+1, i+1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		power = new int[N+1][N+1];
		team1 = new int[N/2];
		team2 = new int[N/2];
		
		for (int i = 1; i < power.length; i++) {
			StringTokenizer tokens = new StringTokenizer(bf.readLine());
			for (int j = 1; j < power.length; j++) {
				power[i][j]= Integer.parseInt(tokens.nextToken());
			}
		}	
		combi(0,1);
		System.out.println(min);
	}
}
