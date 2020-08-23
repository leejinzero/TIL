package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//kruskal 방식
public class SWEA_1251_하나로1 {
	static int[] x_list;
	static int[] y_list;
	static int[] visited ;
	static int N;
	static double rate;
	static PriorityQueue<Road> pq ;
	static class Road implements Comparable<Road>{
		int v1,v2;
		long dis;
		
		public Road(long dis, int v1, int v2) {
			this.dis = dis;
			this.v1 = v1;
			this.v2 = v2;
		}

		@Override
		public int compareTo(Road o) {
			if(this.dis < o.dis) return -1; 
			else return 1;
		}
	
		
	}

	private static void combi() {		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				long dis =(long)(x_list[i]-x_list[j])*(long)(x_list[i]-x_list[j])+(long)(y_list[i]-y_list[j])*(long)(y_list[i]-y_list[j]);
				pq.offer(new Road(dis,i,j));
			}	
		}
	}
	
	private static double get_min() {
		double d = 0.0;
		
		while(!pq.isEmpty()) {
			Road f = pq.poll();
			
			if(!find(f.v1,f.v2)) {
				d+=f.dis*rate;
				unionParent(f.v1,f.v2);
			}		
		}
		
		return d;
	}

	 static int getParent(int x) {
	        if(visited[x] == x) return x;
	        return visited[x] = getParent(visited[x]);
	    }
	     
	 static void unionParent(int a, int b) {
	        a=getParent(a);
	        b= getParent(b);
	        if(a<b) visited[b] =a;
	        else
	            visited[a] = b;
	    }
	     
	 static boolean find(int a, int b) {
	        a= getParent(a);
	        b = getParent(b);
	        if(a==b)
	            return true;
	        else
	            return false;
	                 
	    }

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#"+tc+" ");
			N = Integer.parseInt(bf.readLine());		
			x_list = new int[N];
			y_list = new int[N];
			visited = new int[N];
			
			StringTokenizer tks = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {				
				int x = Integer.parseInt(tks.nextToken());			
				x_list[i] = x;				
			}
			
			tks = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				int y = Integer.parseInt(tks.nextToken());			
				y_list[i] = y;
			}
			
			for (int i = 0; i < N; i++) {
				visited[i] = i;
			}
			
			rate = Double.parseDouble(bf.readLine());
			pq = new PriorityQueue<>();
			combi();
			sb.append((long)Math.round(get_min())).append("\n");
		}	
		System.out.println(sb);
	}

}
