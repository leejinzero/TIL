```java
package swea;
import java.util.Scanner;

public class SWEA_1209_sum2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			int max = Integer.MIN_VALUE;
			int[][] matrix = new int[100][100];
			sc.nextInt();
			int sum2=0,sum=0;
			for (int j = 0; j < 100; j++) {
				int sumRow=0;

				for (int j2 = 0; j2 < 100; j2++) {
					matrix[j][j2]=sc.nextInt();
					sumRow+=matrix[j][j2];
				}
				if(sumRow>max) max= sumRow;

			}

			for (int j = 0; j < 100; j++) {
				int sumCol=0;
				for (int j2 = 0; j2 < 100; j2++) {
					sumCol+=matrix[j2][j];
                    if(j==j2) sum+=matrix[j][j2];
                    if(j+j2==99) sum2+=matrix[j][j2];
				}
				if(sumCol>max) max= sumCol;
			}
            if(sum>max) max= sum;
            if(sum2>max) max= sum2;


			System.out.println("#"+i+" "+max);




		}

	}

}
```
