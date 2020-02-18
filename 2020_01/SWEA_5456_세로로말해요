import java.util.Arrays;
import java.util.Scanner;

public class SWEA_5456_세로로말해요 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int su = sc.nextInt();
		StringBuilder sb= new StringBuilder();
		String[][] strArr = new String[5][15];
		int max=0;
		
		for (int a = 0; a < su; a++){
			sb.append("#" + (a+1) +" ");
			for (int i = 0; i < 5; i++) {
				String str = sc.next();
				strArr[i]=str.split("");
				if(strArr[i].length> max) max=strArr[i].length;
				}
			for (int i = 0; i < max; i++) {
				for (int k = 0; k <5; k++) {
					if(i>=strArr[k].length) continue;
					sb.append(strArr[k][i]);
				}
			}
			sb.append("\n");
			}
		System.out.println(sb);
		
	}

}
