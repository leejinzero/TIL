package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author leejinyoung
 * @Date  Jul 27, 2020
 * @Language java
 * @Memory 	366768KB
 * @RunningSpeed 3468ms
 * @Description bfs...방문체크를?,,
 * 
 */
public class BJ_9019_DSLR {
	
	private static int after;
	private static StringBuilder sb;
	static boolean[] visited ;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(bf.readLine());
		sb = new StringBuilder();
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer tks = new StringTokenizer(bf.readLine());
			int before = Integer.parseInt(tks.nextToken());
			after = Integer.parseInt(tks.nextToken());
			visited = new boolean[10000];
			bfs(before);

		}
		System.out.println(sb);
	}

	static class Pair{
		int num;
		String order;
		
		public Pair(int num, String order) {
			this.num = num;
			this.order = order;
		}

		@Override
		public String toString() {
			return "Pair [num=" + num + ", order=" + order + "]";
		}	
		
	}
	
	
	static void bfs(int start) {
		Queue<Pair> q = new LinkedList<>();	
		q.offer(new Pair(start,""));
		visited[start]=true;
		
		while(!q.isEmpty()) {
			Pair f = q.poll();
			
			
			if(f.num==after) {
				sb.append(f.order).append("\n");
				return;
			}
			
			int D= (f.num*2)%10000;
			if(!visited[D]) {
				q.offer(new Pair(D, f.order+"D"));
				visited[D] = true;
			}
			
			
			int S = f.num-1 == -1? 9999 : f.num-1;
			if(!visited[S]) {
				q.offer(new Pair(S, f.order+"S"));
				visited[S] =true;
			}
			
			int d1 = f.num/1000;
			int d2 = f.num/100%10;
			int d3 = f.num/10%10;
			int d4 = f.num%10;
			
			int L = d2*1000+ d3*100 + d4*10 + d1;
			
			if(!visited[L]) {
				q.offer(new Pair(L, f.order+"L"));
				visited[L] =true;
			}
			
			
			int R = d4*1000+ d1*100 + d2*10 + d3;
			
			if(!visited[R]) {
				q.offer(new Pair(R, f.order+"R"));
				visited[R] =true;
			}
		}
	}	

}

