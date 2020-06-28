import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_7208_지도칠하기 {
	static List<Integer>[] graph;
	static int change;
	static int[] before;
	static int[] arr;
	
	public static void permu(int index) {
		if(index==arr.length) {
			if(check(arr)) {
				int cnt=0;
				for (int i = 0; i < arr.length; i++) {
					if(arr[i]!=before[i]) cnt++;
				}
				change = Math.min(change, cnt);
			}			
			return ;
		}
		
		for (int i = 1; i <= arr.length; i++) {
			arr[index]=i;
			permu(index+1);
		}
		
		
	}
	
	public static boolean check(int[] arr) {

		for (int i = 0; i < graph.length; i++) {
			List<Integer> childs = graph[i];
			for (int j = 0; j < childs.size(); j++) {
				int child = childs.get(j);
				if (arr[i] == arr[child]) {
					return false;
				}
			}
		}
		
		return true;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int country = Integer.parseInt(bf.readLine());

			StringTokenizer tokens = new StringTokenizer(bf.readLine());

			before = new int[country];
			arr = new int[country];
			for (int i = 0; i < country; i++) {
				before[i] = Integer.parseInt(tokens.nextToken());
			}

			graph = new ArrayList[country];
			for (int i = 0; i < graph.length; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < country; i++) {
				tokens = new StringTokenizer(bf.readLine());
				for (int j = 0; j < country; j++) {
					int tem = Integer.parseInt(tokens.nextToken());
					if (tem == 1) {
						graph[i].add(j);
					}
				}
			}

			change = Integer.MAX_VALUE;
			
			permu(0);
			
			System.out.println("#" + tc + " " + change);
		}

	}

}
