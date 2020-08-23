package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author leejinyoung
 * @Date 2020. 5. 13.
 * @Language java
 * @Memory 289096KB
 * @RunningSpeed 940ms
 * @Description bfs로 색칠해주기 근데 그래프가 연결요소가 여러개일시 주의!
 * 
 */
public class BJ_1707_이분그래프 {

	private static List[] graphs;
	private static int V;
	private static int[] colors;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		sb = new StringBuilder();

here:	for (int tc = 1; tc <= T; tc++) {
			StringTokenizer tks = new StringTokenizer(bf.readLine());

			V = Integer.parseInt(tks.nextToken());
			int E = Integer.parseInt(tks.nextToken());

			graphs = new List[V + 1];

			for (int i = 1; i <= V; i++) {
				graphs[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < E; i++) {
				tks = new StringTokenizer(bf.readLine());
				int v1 = Integer.parseInt(tks.nextToken());
				int v2 = Integer.parseInt(tks.nextToken());

				graphs[v1].add(v2);
				graphs[v2].add(v1);
			}

			colors = new int[V + 1];
			for (int i = 1; i < V; i++) {
				if(colors[i]==0) {
					if(!bfs(i)) {
						sb.append("NO\n");
						continue here;
					}
				}
			}
			
			sb.append("YES\n");
			
		}
		System.out.println(sb);

	}
	
	static class Color{
		int c;
		int idx;
		
		public Color(int c, int idx) {
			this.c = c;
			this.idx = idx;
		}
		
	}

	private static boolean bfs(int idx) {
		Queue<Color> q = new LinkedList<>();
		q.offer(new Color(1,idx));		
		colors[idx]=1;
		
		while(!q.isEmpty()) {
			Color f= q.poll();
						
			List child = graphs[f.idx];
			for (int i = 0; i < child.size(); i++) {				
				if(colors[(int) child.get(i)]==0) {
					colors[(int) child.get(i)]=3-f.c;
					q.offer(new Color(3-f.c,(int) child.get(i)));
				}else {
					if(f.c==colors[(int) child.get(i)]) return false;
				}
			}
		}
		return true;
	}

}
