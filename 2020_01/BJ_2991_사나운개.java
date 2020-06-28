import java.util.Scanner;

public class BJ_2991_사나운개 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int A_break = sc.nextInt();
		int B = sc.nextInt();
		int B_break = sc.nextInt();
		
		int post = sc.nextInt();
		int milk = sc.nextInt();
		int news= sc.nextInt();
		
		int count=0;
		if(post%(A+A_break)<=A && post%(A+A_break)!=0) count++;
		if(post%(B+B_break)<=B&& post%(B+B_break)!=0) count++;
		System.out.println(count);
		
		count=0;
		if(milk%(A+A_break)<=A && milk%(A+A_break)!=0) count++;
		if(milk%(B+B_break)<=B && milk%(B+B_break)!=0) count++;
		System.out.println(count);

		count=0;
		if(news%(A+A_break)<=A&& news%(A+A_break)!=0) count++;
		if(news%(B+B_break)<=B&& news%(B+B_break)!=0) count++;
		System.out.println(count);

	}

}
