import java.util.Scanner;

public class BJ_2941_크로아티아알파벳 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String[] list = {"c=","c-","d-","lj","nj","s=","z=","dz="};
		int cnt=0;
		
here:	for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch=='d' && i+2<str.length()) {
				String tem = str.substring(i,i+3);
				if(tem.equals(list[7])) {
					cnt++;
					i+=2;
					continue;
				}
			}
			if(i+1<str.length()) {
				if(ch=='c'|| ch=='l'|| ch=='d'|| ch=='n'|| ch=='s'||ch=='z') {
					String s= str.substring(i,i+2);
					for (int j = 0; j < list.length-1; j++) {
						if(s.equals(list[j])) {
							cnt++;
							i+=1;
							continue here;
						}
					}
				}else {
					cnt++;
					continue;
				}
			}
			cnt++;
			
		}
		System.out.println(cnt);

	}

}
