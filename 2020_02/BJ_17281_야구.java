import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_17281_야구 {
	static int max;
	static boolean[] visited;
	static int[][] member_score;
	static ArrayList<Integer> hit = new ArrayList<>();
	
	public static int score(ArrayList<Integer> hit) {
		int sum = 0;
		int strike = 0;
		int count=0;
		
		for (int i = 0; i < member_score.length; i++) {
			strike = 0;
			boolean[] ru = new boolean[4];
			while (count<10) {
				if(count==9) count=0;
				if(member_score[i][hit.get(count)]==0) {
					strike++;
					if(strike==3) {
						count++;
						break;
					}
				}
				else if(member_score[i][hit.get(count)]==4) {
					sum++;		
					for (int k = 1; k < ru.length; k++) {
						if(ru[k]) sum++;
					}
					ru = new boolean[4];
				}
				else {
					boolean[] ru_tem = new boolean[4];
					for (int k = 1; k <= 3; k++) {
						if(ru[k]) {
							if(k+member_score[i][hit.get(count)]>=4){
								sum++;
								ru[k]=false;
							}else {
								ru_tem[k+member_score[i][hit.get(count)]] =true;
								ru[k]=false;
							}
						}
					}
					
					for (int j = 1; j <=3; j++) {
						if(ru_tem[j]) ru[j] = true;
					}
					ru[member_score[i][hit.get(count)]] =true;
				}
				count++;
			}
		}
		
		return sum;
	}
	
	public static void permu(int index) {
		if(index==8) {
			hit.add(3, 3);
			max = Math.max(max, score(hit));
			hit.remove(3);
			return ;
		}
		
		for (int i = 0; i < 9; i++) {
			if(!visited[i]&& i!=3) {
				visited[i] =true;
				hit.add(i);
				permu(index+1);
				hit.remove(index);
				visited[i]=false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int inning = Integer.parseInt(bf.readLine());
		member_score = new int[inning][9];
		
		for (int i = 0; i < inning; i++) {
			StringTokenizer tokens = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 9; j++) {
				if(j==0) member_score[i][3] = Integer.parseInt(tokens.nextToken());
				else if(j==3) member_score[i][0] = Integer.parseInt(tokens.nextToken());
				else member_score[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		visited = new boolean[9];
		permu(0);
		
		System.out.println(max);
	}

}
