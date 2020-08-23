package jo;

import java.util.Scanner;

public class JO_1719_별삼각형2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int m =sc.nextInt();
		
		if(n<0 || n>100 || n%2==0 || m>4 || m<=0) {
			System.out.println("INPUT ERROR!");
		}else {
			if(m==1) {
				for (int i = 1; i <= (n+1)/2; i++) {
					for (int j = 1 ; j <= i ; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for (int i = (n+1)/2+1; i <= n; i++) {
					for (int j = i ; j <= n ; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				
			}else if(m==2) {
				
				for (int i = 1; i <= (n+1)/2; i++) {
					for (int j = 0 ; j < (n+1)/2- i; j++) {
						System.out.print(" ");
					}
					for (int j = 1 ; j <= i ; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for (int i = (n+1)/2+1; i <= n; i++) {
					for (int j = (n+1)/2 +1 ; j <= i; j++) {
						System.out.print(" ");
					}
					for (int j = i ; j <= n ; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				
			}else if(m==3) {
				for (int i = 1; i <= (n+1)/2; i++) {
					for (int j = 1 ; j < i; j++) {
						System.out.print(" ");
					}
					int n2=n;
					for (int j = i ; j <= (n-i+1); j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for (int i = (n+1)/2+1; i <= n; i++) {
					for (int j = i+1 ; j <= n; j++) {
						System.out.print(" ");
					}
					for (int k = n+1-i ; k <= i ; k++) {
						System.out.print("*");
					}
					System.out.println();
				}
				
			}else {
				for (int i = 1; i <= (n+1)/2; i++) {
					for (int j = 1 ; j < i; j++) {
						System.out.print(" ");
					}
					for (int j = i ; j <=(n+1)/2; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for (int i = (n+1)/2+1; i <= n; i++) {
					for (int k = 1; k < (n+1)/2 ; k++) {
						System.out.print(" ");
					}
					for (int j = (n+1)/2 ; j <= i ; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				
			}		
		}

	}

}
