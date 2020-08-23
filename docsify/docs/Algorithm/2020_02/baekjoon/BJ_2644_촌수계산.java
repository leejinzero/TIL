package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2644_촌수계산 {
	static int[] count;
	static List<Integer>[] graph ;
	static boolean[] visited ;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int people = Integer.parseInt(bf.readLine());
		
		StringTokenizer tokens =new StringTokenizer(bf.readLine());
		
		int parent = Integer.parseInt(tokens.nextToken());
		int child = Integer.parseInt(tokens.nextToken());
		
		int edges = Integer.parseInt(bf.readLine());
		
		graph = new ArrayList[people+1];
		count = new int[people+1];
		visited = new boolean[people+1];
		
		for (int i = 1; i <= people; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < edges; i++) {
			tokens = new StringTokenizer(bf.readLine());
			int v1 = Integer.parseInt(tokens.nextToken());
			int v2 = Integer.parseInt(tokens.nextToken());
			
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
	
		bfs(parent,child);
		if(count[child] ==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(count[child]);
		}
		
	}

	private static void bfs(int parent, int child) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(parent);
		Arrays.fill(count, Integer.MAX_VALUE);
		count[parent]=0;
		
		
		while(!q.isEmpty()) {
			int front = q.poll();
			
			if(front == child) {
				break;
			}
			
			List<Integer> childs = graph[front];
			
			for (int i = 0; i < childs.size(); i++) {
				int cc = childs.get(i);
				
				if(!visited[cc]) {
					q.offer(cc);
					visited[cc]=true;
					
					if(count[cc]>count[front]+1) {
						count[cc]=count[front]+1;
					}
				}
			}
		
		}
		
	}

}
