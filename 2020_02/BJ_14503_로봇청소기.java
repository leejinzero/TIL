import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14503_로봇청소기 {
	static int[][] map;
	static int map_row;
	static int map_col;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		bf = new BufferedReader(new StringReader(src));

		StringTokenizer tokens = new StringTokenizer(bf.readLine());
		map_row = Integer.parseInt(tokens.nextToken());
		map_col = Integer.parseInt(tokens.nextToken());
		int answer = 0;

		map = new int[map_row][map_col];

		tokens = new StringTokenizer(bf.readLine());
		int robot_row = Integer.parseInt(tokens.nextToken());
		int robot_col = Integer.parseInt(tokens.nextToken());
		int robot_dir = Integer.parseInt(tokens.nextToken());

		for (int r = 0; r < map_row; r++) {
			tokens = new StringTokenizer(bf.readLine());
			for (int c = 0; c < map_col; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		int change = 0;
		int nx = robot_row;
		int ny = robot_col;
		boolean flag = true;
		int forcount = 1;
		while (true) {
			for(int i = 0; i < map_row; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			System.out.println();
			if (change <= 3) {
				if (map[nx][ny] == 0) {
					map[nx][ny] = 3;
					answer++;
					robot_dir--;
					change = 0;
					flag = true;

				} else {
					nx -= dir[robot_dir][0];
					ny -= dir[robot_dir][1];
					robot_dir--;
					change++;
				}
				if (robot_dir == -1) robot_dir = 3;
				nx += dir[robot_dir][0];
				ny += dir[robot_dir][1];
			} else { 
				if (flag) {
					nx -= dir[robot_dir][0];
					ny -= dir[robot_dir][1];
					robot_dir++;
					if (robot_dir == 4)
						robot_dir = 0;
				}

				int back_dir = robot_dir % 2 == 0 ? 2 - robot_dir : 4 - robot_dir;
				
				if (flag)
					forcount = 1;
				else
					forcount = 2;
				
				for (int i = 0; i < forcount; i++) {
					nx += dir[back_dir][0];
					ny += dir[back_dir][1];
				}
				
				if (nx<0 || ny<0 || nx>=map.length || ny >= map[0].length || map[nx][ny] == 1)
					break;
				
				change = 1;
				flag = false;
				robot_dir--;
				if (robot_dir == -1)
					robot_dir = 3;
				nx += dir[robot_dir][0];
				ny += dir[robot_dir][1];

			}
		}

		System.out.println(answer);

	}
}
