```java
package baekjoon;

import java.util.Scanner;

public class BJ_1969_DNA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] dna = new char[N][M];
		int[] dnaCount;
		int hamD = 0;
		char[] smallhamDiff = new char[M];
		char chars[] = {'A','C','G','T'};

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				dna[i][j] = str.charAt(j);
			}
		}

		for (int j = 0; j < M; j++) {
			dnaCount= new int[4];
			for (int i = 0; i < N; i++) {
				if(dna[i][j]=='A') {
					dnaCount[0]++;
				}else if(dna[i][j]=='C'){
					dnaCount[1]++;
				}else if(dna[i][j]=='G'){
					dnaCount[2]++;
				}else {
					dnaCount[3]++;
				}

			}
			int max=0,diff=0;
			for (int k = 0; k < dnaCount.length; k++) {
				if(max<dnaCount[k]) {
					max = dnaCount[k];
					diff=k;
				}else if(max==dnaCount[k]){
					if(k<diff) {
						diff=k;
					}
				}
			}
			hamD+= N-max;
			smallhamDiff[j]= chars[diff];
		}

		for (int i = 0; i <M; i++) {
			System.out.print(smallhamDiff[i]);
		}
		System.out.println();
		System.out.println(hamD);

	}

}
```
