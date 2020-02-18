import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BJ_17471_게리멘더링 {

	static int[] citypick1 ;
	static int[] citypick2;
	static boolean visited[];
	static List<Integer>[] g;
	static int[] pArr;
	static List<Integer> difflist = new ArrayList<>(); 
		
	public static void combi(int index, int len, int start,int vertex) {
		if(index== len) {
			
			boolean flag=false;
			int  k =0;
			for (int i = 1; i <= vertex; i++) {
				flag=false;
				for (int j = 0; j < citypick1.length; j++) {
					if(citypick1[j]==i) {
						flag=true;
					}
				}
				if(!flag) citypick2[k++]=i;
			}
			
			visited= new boolean[vertex+1];

			for (int j = 0; j < citypick2.length; j++) {
				visited[citypick2[j]]=true;
			}
	
			int sum=0;
			for (int i = 0; i < citypick1.length; i++) {
				if(!visited[citypick1[i]]) {
					sum+=sameCity(citypick1[i]);
				}
			}
			
			if(sum!=1) return;

			visited= new boolean[vertex+1];

			for (int j = 0; j < citypick1.length; j++) {
				visited[citypick1[j]]=true;
			}
			
			sum=0;
			for (int i = 0; i < citypick2.length; i++) {
				if(!visited[citypick2[i]]) {
					sum+=sameCity(citypick2[i]);
				}
			}
			if(sum!=1) return;

			int pSum=0;
			for (int i = 0; i < citypick1.length; i++) {
				pSum+=pArr[citypick1[i]];
			}
			
			int pSum2=0;
			for (int i = 0; i < citypick2.length; i++) {
				pSum2+=pArr[citypick2[i]];
			}
			
			difflist.add(Math.abs(pSum-pSum2));
			
			return;
		}
		
		for (int i = start; i < g.length; i++) {
			citypick1[index]=i;
			combi(index+1,len,i+1,vertex);
		}
		
		
	}
			
	public static int sameCity(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int top = q.poll();
			if(visited[top]) continue;
			visited[top]=true;
			
			List childs = g[top];
			for (int i = 0; i < childs.size(); i++) {
				int child = (int) childs.get(i);
				if(!visited[child]) q.offer(child);
				
			}
		}		
		return 1;
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int vertex = sc.nextInt();		
		g = new List[vertex+1];		
		pArr = new int[vertex+1];
		visited= new boolean[vertex+1];
		
		for (int i = 1; i < pArr.length; i++) {
			pArr[i]=sc.nextInt();
			g[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < vertex+1; i++) {
			int childnum = sc.nextInt();
			for (int j = 0; j < childnum; j++) {
				int child = sc.nextInt();
				g[i].add(child);
			}
		}
	
		for (int i = 1; i <= vertex/2; i++) {
			citypick1 = new int[i];
			citypick2 = new int[vertex-i];
			combi(0,i,1,vertex);
		}

		difflist.sort(null);
		if(difflist.size()==0) System.out.println(-1);
		else System.out.println(difflist.get(0));
	}
}
