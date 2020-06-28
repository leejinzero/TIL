import java.util.Scanner;

public class SWEA_9229_한빈이와SpotMart {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 0; i < num; i++) {
			int testcase = sc.nextInt();
			int limit_gram = sc.nextInt();
			int[] gram = new int[testcase];
			int max=0;
			
			for (int j = 0; j < testcase;j++) {
				gram[j]=sc.nextInt();
			}
			for (int j = 0; j < testcase; j++) {
				for (int j2 = j+1; j2 < testcase; j2++) {
					int hap=gram[j]+gram[j2];
					if(max<hap && hap<=limit_gram) max=hap;
				}
			}
			if(max==0) System.out.println("#"+(i+1)+ " -1");
			else System.out.println("#"+(i+1)+ " "+ max);
		}

	}

}
