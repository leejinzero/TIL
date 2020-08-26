package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @Author leejinyoung
 * @Date 2020. 5. 13.
 * @Language java
 * @Memory 21,960KB
 * @RunningSpeed 491ms
 * @Description dfs,, 너무 어려운 문제.. 모든 완탐은 시간초과,,
 * 
 */
public class SWEA_1798_범준이의제주도여행계획 {
	// 하루 제한시간
	static int limit = 9 * 60;
	static boolean[] visited;
	private static int[][] data;
	private static int[][] times;
	private static int N;
	private static int M;
	private static int[] spots;
	private static int[] hotels;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();

		here: for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer tks = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(tks.nextToken());
			M = Integer.parseInt(tks.nextToken());
			times = new int[N][N];

			for (int i = 0; i < N - 1; i++) {
				tks = new StringTokenizer(bf.readLine());
				for (int j = i + 1; j < N; j++) {
					times[i][j] = times[j][i] = Integer.parseInt(tks.nextToken());
				}
			}
			// 위치 ,여행 시간, 만족도
			data = new int[N][3];
			int spotCount = 0;
			for (int i = 0; i < N; i++) {
				tks = new StringTokenizer(bf.readLine());
				data[i][0] = tks.nextToken().charAt(0);

				if (data[i][0] == 'P') {
					data[i][1] = Integer.parseInt(tks.nextToken());
					data[i][2] = Integer.parseInt(tks.nextToken());
					spotCount++;
				}
			}
			spots = new int[spotCount];
			hotels = new int[N - spotCount - 1];
			int si = 0;
			int hi = 0;
			for (int i = 0; i < N; i++) {
				if (data[i][0] == 'P') {
					spots[si++] = i;
				} else if (data[i][0] == 'H') {
					hotels[hi++] = i;
				}
			}

			// 방문
			visited = new boolean[N];
			// 총 만족도
			thappy = 0;
			// 경로
			ttpath = new ArrayList<>();
			// 임시경로
			path = new ArrayList<>();
			
			// 완탐
			dfs(0, thappy, 0, 0);
			// 만약 가지못한다면, 0출력
			if (ttpath.size() == 0 || data[ttpath.get(ttpath.size() - 1) - 1][0] != 'A') {
				sb.append("0\n");
				continue here;
			}
			// 출력 붙이기
			sb.append(thappy + " ");
			for (int i = 0; i < ttpath.size(); i++) {
				sb.append(ttpath.get(i) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int thappy = 0;
	static ArrayList<Integer> ttpath;
	static ArrayList<Integer> path;
	
	private static void dfs(int time, int happy, int idx, int tday) {		
		boolean flag = false;
		for (int i = 0; i < spots.length; i++) {
			if (!visited[spots[i]]) {
				int tem = time + times[idx][spots[i]] + data[spots[i]][1];
				if (tem<=limit) {
					path.add(spots[i] + 1);
					flag= true;
					visited[spots[i]] = true;
					dfs(tem, happy + data[spots[i]][2], spots[i], tday);
					path.remove(path.size() - 1);
					visited[spots[i]] = false;
				}
			}
		}
		
		
		if(!flag) {
			if (tday == M-1) {
				if (time + times[0][idx] <= limit) {				
					if (happy > thappy) {
						path.add(1);
						thappy = happy;
						ttpath = new ArrayList<Integer>();
				        for (int i = 0; i < path.size(); i++) {
				            ttpath.add(path.get(i));
				        }
				        path.remove(path.size() - 1);
					}
					
				}
			} else {
				for (int j = 0; j < hotels.length; j++) {
					if (time + times[idx][hotels[j]] <= limit) {
						path.add(hotels[j] + 1);
						dfs(0, happy, hotels[j], tday + 1);
						path.remove(path.size() - 1);
					}

				}
			}

		}
		

	}

}
