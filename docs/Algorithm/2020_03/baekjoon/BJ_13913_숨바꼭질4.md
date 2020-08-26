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

public class BJ_13913_숨바꼭질4 {
	static int[] count = new int[100001];
	static int[] dir = {-1,1};
	static int[] path = new int[100001];
	
	public static void bfs(int start, int target) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		path[start] = start;
		Arrays.fill(count, Integer.MAX_VALUE);
		count[start]=0;

		while(!q.isEmpty()) {
			int front = q.poll();

			if(front == target) {
				break;
			}

			if(front<target) {
				for (int i = 0; i < 3; i++) {
					int next;
					if(i==2) {
						next = front*2;
					}else {
						next = front+dir[i];
					}

					if(next>=0 && next<=100000 && count[next] > count[front]+1) {
						q.offer(next);
						path[next] = front;
						count[next]= count[front]+1;
					}
				}
			}else {
				int next = front-1;
				
				if(next>=0 && count[next] > count[front]+1) {
					q.offer(next);
					path[next] = front;
					count[next]= count[front]+1;
				}
				
			}
			
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tokens = new StringTokenizer(bf.readLine());

		int start = Integer.parseInt(tokens.nextToken());
		int target = Integer.parseInt(tokens.nextToken());

		if(start>target) {
			System.out.println(start-target);
			for (int i = start; i >=target; i--) {
				System.out.print(i+" ");
			}
			return ;
		}
		
		if(start==target) {
			System.out.println(0);
			System.out.println(start);
			return ;
		}
		
		bfs(start, target);

		int t = count[target];
		System.out.println(t);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(target);
		int tem = target;
		for(int i = 0 ; i < t ; i++) {
			list.add(path[tem]);
			tem = path[tem];
		}
	
		for(int i=t ; i>=0 ; i--) {
			System.out.print(list.get(i)+" ");
		}
	}

}
