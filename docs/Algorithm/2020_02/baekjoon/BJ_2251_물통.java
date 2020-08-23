package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Data {
	int a_water, b_water, c_water;

	public Data(int a_water, int b_water, int c_water) {
		this.a_water = a_water;
		this.b_water = b_water;
		this.c_water = c_water;
	}

	@Override
	public String toString() {
		return "Data [a_water=" + a_water + ", b_water=" + b_water + ", c_water=" + c_water + "]";
	}

}

public class BJ_2251_물통 {
	static ArrayList<Integer> clist = new ArrayList<>();
	static int a_beker;
	static int b_beker;
	static int c_beker;
	static boolean[][][] visited;
	static Queue<Data> q = new LinkedList<>();

	public static void bfs(Data c) {
		visited = new boolean[a_beker + 1][b_beker + 1][c_beker + 1];
		q.offer(c);

		while (!q.isEmpty()) {
			Data front = q.poll();

			if (visited[front.a_water][front.b_water][front.c_water])
				continue;

			visited[front.a_water][front.b_water][front.c_water] = true;

			if (front.a_water == 0) {
				clist.add(front.c_water);
			}

			// a
			if (front.a_water > 0) {
				for (int i = 0; i < 2; i++) {
					if (i == 0) {
						int tem = front.a_water + front.b_water;
						if (tem <= b_beker) {
							q.offer(new Data(0, tem, front.c_water));
						} else if (tem > b_beker) {
							q.offer(new Data(tem - b_beker, b_beker, front.c_water));
						}
					} else if (i == 1) {
						int tem = front.a_water + front.c_water;
						if (tem <= c_beker) {
							q.offer(new Data(0, front.b_water, tem));
						} else if (tem > c_beker) {
							q.offer(new Data(tem - c_beker, front.b_water, c_beker));
						}
					}

				}
			}

			// b

			if (front.b_water > 0) {
				for (int i = 0; i < 2; i++) {
					if (i == 0) {
						int tem = front.b_water + front.a_water;
						if (tem <= a_beker) {
							q.offer(new Data(tem, 0, front.c_water));
						} else if (tem > a_beker) {
							q.offer(new Data(a_beker, tem - a_beker, front.c_water));
						}
					} else {
						int tem = front.b_water + front.c_water;
						if (tem <= c_beker) {
							q.offer(new Data(front.a_water, 0, tem));
						} else if (tem > c_beker) {
							q.offer(new Data(front.a_water, tem - c_beker, c_beker));
						}
					}
				}
			}

			// c
			if (front.c_water > 0) {
				for (int i = 0; i < 2; i++) {
					if (i == 0) {
						int tem = front.c_water + front.a_water;
						if (tem <= a_beker) {
							q.offer(new Data(tem, front.b_water, 0));
						} else if (tem > a_beker) {
							q.offer(new Data(a_beker, front.b_water, tem - a_beker));
						}
					} else {
						int tem = front.c_water + front.b_water;
						if (tem <= b_beker) {
							q.offer(new Data(front.a_water, tem, 0));
						} else if (tem > b_beker) {
							q.offer(new Data(front.a_water, b_beker, tem - b_beker));
						}
					}
				}
			}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(bf.readLine());

		a_beker = Integer.parseInt(tokens.nextToken());
		b_beker = Integer.parseInt(tokens.nextToken());
		c_beker = Integer.parseInt(tokens.nextToken());

		bfs(new Data(0, 0, c_beker));
		clist.sort(null);

		for (int i = 0; i < clist.size(); i++) {
			System.out.print(clist.get(i) + " ");
		}

	}

}
