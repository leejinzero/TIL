import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1244_최대상금{

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		bf.readLine();
		for (int tc = 1; tc <= 10; tc++) {
			String str = bf.readLine();
			StringTokenizer tokens = new StringTokenizer(str);
			String[] first = tokens.nextToken().split("");
			int[] first_num = new int[first.length];
			int[] sort = new int[first.length];
			
			for (int i = 0; i < first_num.length; i++) {
				first_num[i]= Integer.parseInt(first[i]);
				sort[i]=first_num[i];
			}
			Arrays.sort(sort);
			int chance = Integer.parseInt(tokens.nextToken());
			
			int index=0;
			for (int i = 0; i < chance; i++) {
here:			while(sort[sort.length-1-index]==first_num[index]) {
					index++;
					if(index==sort.length){
						for (int h = 0; h < sort.length; h++) {
							for (int j = h+1; j < sort.length; j++) {
								if(sort[sort.length-1-h]==sort[sort.length-1-j]) {
									index=h;
									break here;
								}
							}	
						}
						index=sort.length-2;
						break;
					}
				}
				int max=0;
				for (int j = index+1; j < first_num.length; j++) {
					if(max<first_num[j]) {
						max = first_num[j];
					}
				}
				
				int maxcnt=0;
				for (int l = 0; l< sort.length; l++) {
					if(max== sort[l]) {
						maxcnt++;
					}
				}
				
				int cnt=0;
				int k=0;
				for (int j = index+1; j < first_num.length; j++) {
					if(max==first_num[j]){
						k=j;
						int count=0;
						cnt++;
						int end = index+chance-i> sort.length ? sort.length:index+chance-i;
						for (int j2 = index+1; j2 < end; j2++) {
							if(first_num[index]> first_num[j2]) {
								count++;
							}
						}				
						if(maxcnt-count==cnt){
							k = j;
							maxcnt--;
							break;
						}
					}
				}
				int tem = first_num[index];
				first_num[index]= first_num[k];
				first_num[k]=tem;
				
			}
			System.out.print("#"+tc+" ");
			
			for (int i = 0; i < first_num.length; i++) {
				System.out.print(first_num[i]);
			}
			System.out.println();
		}

	}

}
