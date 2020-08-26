package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//prim 방식
public class SWEA_1251_하나로2 {
	static long[][] graph;
	static int[] x_list;
	static int[] y_list;
	static int N;
	static double rate;
	static PriorityQueue<Road> pq ;
	static class Road implements Comparable<Road>{
		int v;
		long dis;
		
		public Road(long dis, int v) {
			this.dis = dis;
			this.v = v;
		}

		@Override
		public int compareTo(Road o) {
			if(this.dis < o.dis) return -1; 
			else return 1;
		}
	
		
	}
	
	
	private static long prim(int v) {
		Road[] dynamicGraph = new Road[N];
		
		for (int i = 0; i < dynamicGraph.length; i++) {
			dynamicGraph[i] = new Road (Long.MAX_VALUE, i);
			if(i==v) {
				dynamicGraph[i].dis = 0;
			}
			pq.add(dynamicGraph[i]);
		}		
		long cost = 0;
		
		while(!pq.isEmpty()) {
			Road f = pq.poll(); //MST에 포함되는 녀석
			cost+=f.dis;
			
			for (int i = 0; i < dynamicGraph.length; i++) {
				Road child = dynamicGraph[i];
				
				//pq : 비MST
				if(pq.contains(child)) {
					long temCost = graph[f.v][child.v];
					if(temCost<child.dis) {
						child.dis = temCost;
						pq.remove(child);
						pq.offer(child);
					}
				}
				
			}		
		}
		
		return cost;
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
      
			rate = Double.parseDouble(bf.readLine());
			graph = new long[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					long dis =(long)(x_list[i]-x_list[j])*(long)(x_list[i]-x_list[j])+(long)(y_list[i]-y_list[j])*(long)(y_list[i]-y_list[j]);
					graph[j][i] = graph[i][j] = dis;
				}	
			}
			
			pq = new PriorityQueue<>();
			double cost = prim(0)*rate;
			sb.append(Math.round(cost)).append("\n");
		}	
		System.out.println(sb);
	
	}

}
