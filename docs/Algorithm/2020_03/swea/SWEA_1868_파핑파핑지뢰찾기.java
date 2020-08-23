package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
 
public class SWEA_1868_파핑파핑지뢰찾기 {
    static int N;
    static char[][] map;
    static int[][] map2;
    static boolean[][] visited;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
 
    static class Point {
        int r, c;
 
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
 
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
 
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#" + tc + " ");
            N = Integer.parseInt(bf.readLine());
            map = new char[N][N];
            map2 = new int[N][N];
            int cnt= 0;
 
            for (int i = 0; i < N; i++) {
                String str = bf.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == '*') {
                        map2[i][j] = 100;
                    }else if(map[i][j] =='.') {
                        cnt++;
                    }
                }
            }
 
            visited = new boolean[N][N];
            int answer = 0;
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] == '.') {
                        bfs(i, j);
                    }
                }
            }
             
            visited=new boolean[N][N];
             
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map2[i][j] == 0) {
                        visited[i][j] = true;
                        cnt-=bfs2(i, j);
                        answer++;
                    }
                }
            }
            answer+=cnt;
             
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
 
    }
     
    private static int bfs2(int i,int j) {
        int k = 1;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));
 
        while (!q.isEmpty()) {
            Point f = q.poll();
             
            for (int j2 = 0; j2 < 8; j2++) {
                int nr = f.r + dir[j2][0];
                int nc = f.c + dir[j2][1];
 
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                    if (map2[nr][nc] != 100) {
                        visited[nr][nc]= true;
                        k++;
                    }
                    if (map2[nr][nc] == 0) {
                        q.offer(new Point(nr,nc));
                    }
                }
            }
             
        }
         
        return k;
    }
         
     
     
    private static void bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));
 
        while (!q.isEmpty()) {
            Point f = q.poll();
 
            if (visited[f.r][f.c])
                continue;
 
            visited[f.r][f.c] = true;
            int cnt = 0;
            ArrayList<Point> list = new ArrayList<>();
            for (int j2 = 0; j2 < 8; j2++) {
                int nr = f.r + dir[j2][0];
                int nc = f.c + dir[j2][1];
 
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                    if (map[nr][nc] == '*') {
                        cnt++;
                    } else if (map[nr][nc] == '.') {
                        list.add(new Point(nr,nc));
                    }
                }
            }
            map2[f.r][f.c] = cnt;
            if (cnt == 0) {
                for (int k = 0; k < list.size(); k++) {
                    q.offer(list.get(k));
                }
            }
        }
    }
}
