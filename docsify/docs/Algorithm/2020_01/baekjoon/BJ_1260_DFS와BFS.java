package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BJ_1260_DFS와BFS {
	private static void dfs(List<Integer>[] graph, int start) {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[graph.length+1];
		List<Integer> path = new ArrayList<>();
		stack.push(start);
		
		while(!stack.isEmpty()) {
			Integer top = stack.pop();
			
			if(visited[top]) {
				continue;
			}
			visited[top]=true;
			path.add(top);
			
			List<Integer> childs = graph[top];
			for (int i = childs.size()-1; i>=0; i--) {
				Integer child= childs.get(i);
				if(!visited[child]) {
					stack.push(child);
				}
			}
			
		}
		for (int i = 0; i < path.size(); i++) {
			System.out.print(path.get(i)+" ");
		}
		System.out.println();
		
	}
	
	private static void bfs(List<Integer>[] graph, int start) {
		Queue<Integer> q= new LinkedList<>();
		boolean[] visited = new boolean[graph.length+1];
		List<Integer> path = new ArrayList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			Integer top = q.poll();
			
			if(visited[top]) {
				continue;
			}
			visited[top]=true;
			path.add(top);
			
			List<Integer> childs = graph[top];
			for (int i = 0; i<childs.size(); i++) {
				Integer child= childs.get(i);
				if(!visited[child]) {
					q.offer(child);
				}
			}
			
		}
		for (int i = 0; i < path.size(); i++) {
			System.out.print(path.get(i)+" ");
		}
		System.out.println();
		
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int edgeCnt = sc.nextInt();
		int start = sc.nextInt();
		List<Integer>[] graph = new List[v+1];
		
		for (int i = 1; i < graph.length; i++) {
			graph[i]= new ArrayList<>();
		}
		
		for (int i = 0; i < edgeCnt; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		
		for (int i = 1; i < graph.length; i++) {
			graph[i].sort(null);
		}
		
		dfs(graph, start);
		bfs(graph, start);

	}

}
