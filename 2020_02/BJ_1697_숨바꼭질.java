import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1697_숨바꼭질 {
	static int[] count = new int[100001];
	static int[] dir = {-1,1};
	
	public static void bfs(int start, int target) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		Arrays.fill(count, Integer.MAX_VALUE);
		count[start]=0;
		
		while(!q.isEmpty()) {
			int front = q.poll();
			
			if(front == target) {
				break;
			}
			
			for (int i = 0; i < 3; i++) {
				int next;
				if(i==2) {
					next = front*2;
				}else {
					next = front+dir[i];
				}
				
				if(next>=0 && next<=100000 && count[next] > count[front]+1) {
					q.offer(next);
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
		
		bfs(start, target);
		
		System.out.println(count[target]);
		
	}

}
