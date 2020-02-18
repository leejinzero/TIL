import java.util.Arrays;
import java.util.Scanner;

public class BJ_9946_단어퍼즐 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str,str2;
		int idx=0;
		
		do {
			str =sc.next();
			str2 =sc.next();
			if(str.equals("END") && str2.equals("END")) break;
			idx++;
			String[] splited1 = str.split("");
			String[] splited2 = str2.split("");
			
			
			if(splited1.length!=splited2.length) {
				System.out.println("Case "+idx +": different");
			}
			else {
				Arrays.sort(splited1);
				Arrays.sort(splited2);
				int i;
				for (i = 0; i < splited2.length; i++) {
					if(!splited1[i].equals(splited2[i])) {
						System.out.println("Case "+idx +": different");
						break;
					}
				}
				
				if(i==splited2.length) {
					System.out.println("Case "+idx +": same");
				}
			}
			
			
		}while(!str.equals("END") && !str2.equals("END"));

	}

}
