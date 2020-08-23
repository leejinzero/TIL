package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SWEA_1240_단순2진암호코드{
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(tokens.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		map.put("0001101", 0);
		map.put("0011001", 1);
		map.put("0010011", 2);
		map.put("0111101", 3);
		map.put("0100011", 4);
		map.put("0110001", 5);
		map.put("0101111", 6);
		map.put("0111011", 7);
		map.put("0110111", 8);
		map.put("0001011", 9);

		for (int tc = 1; tc <= T; tc++) {
			tokens = new StringTokenizer(in.readLine());
			boolean flag =true;
			int row = Integer.parseInt(tokens.nextToken());
			tokens.nextToken();
			
			String str =null;
			for (int i = 0; i < row; i++) {
				str = in.readLine();
				if(flag && str.contains("1")) {
					int index = str.lastIndexOf("1");
					index-=55;
					
					int[] decode = new int[8];
					for (int j = 0; j < 8; j++) {
						String sub = str.substring(index,index+7);
						decode[j] = map.get(sub);
						index+=7;
					}
					
					int sum=0;
					int sum2=0;
					
					for (int j = 0; j < decode.length; j++) {
						if(j%2==1) {
							sum+=decode[j];
						}else {
							sum+=decode[j]*3;
						}
						sum2+=decode[j];
					}
					
					System.out.print("#"+tc+" ");
					if(sum%10==0) {
						System.out.println(sum2);
					}else {
						System.out.println(0);
					}
					flag=false;
					
				}
			}
			
			
		}

	}

}
