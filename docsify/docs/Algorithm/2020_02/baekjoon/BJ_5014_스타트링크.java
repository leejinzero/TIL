package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_5014_스타트링크 {
	static int building;
	static int start;
	static int interview;
	static int up;
	static int down;
	static boolean[] visited;

	static class Count {
		int location, cnt;

		public Count(int location, int cnt) {
			this.location = location;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Count [location=" + location + ", cnt=" + cnt + "]";
		}

	}

	public static void bfs(Count start) {
		Queue<Count> q = new LinkedList<>();
		q.offer(start);

		while (!q.isEmpty()) {
			Count front = q.poll();

			if (visited[front.location])
				continue;

			visited[front.location] = true;

			if (front.location == interview) {
				System.out.println(front.cnt);
				return;
			}
			int tem = front.cnt;
			if (front.location + up <= building && up != 0)
				q.offer(new Count(front.location + up, tem + 1));
			if (front.location - down >= 1 && down != 0)
				q.offer(new Count(front.location - down, tem + 1));
		}
		System.out.println("use the stairs");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(bf.readLine());

		building = Integer.parseInt(tokens.nextToken());
		start = Integer.parseInt(tokens.nextToken());
		interview = Integer.parseInt(tokens.nextToken());
		up = Integer.parseInt(tokens.nextToken());
		down = Integer.parseInt(tokens.nextToken());

		visited = new boolean[building + 1];
		bfs(new Count(start, 0));
	}

}
