import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1289_데이터복구 {

	public static void main(String[] args) {
		StringBuilder sb= new StringBuilder();
		Scanner scanner= new Scanner(System.in);

		int t1=scanner.nextInt();
		for(int i=1;i<=t1;i++) {
			sb.append("#").append(i).append(" ");
			String tt= scanner.next();
			int[] t_list=new int[tt.length()];
			for(int k=0;k<tt.length();k++) {
				t_list[k]=Integer.parseInt(tt.substring(k,k+1));
			}

			int count=0, j;
			for(j=0;j<t_list.length;j++) {
				if(t_list[j]==1) {
					break;
				}
			}
			count++;
			for(;j<t_list.length-1;j++) {
				if(t_list[j]!=t_list[j+1]) {
					count++;
				}
			}
			sb.append(count).append("\n");
		}
			System.out.println(sb);
	}
}
