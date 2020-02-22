import java.util.Scanner;

public class SWEA_4408_자기방으로돌아가기 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int answer =0;
			int[] room = new int[201];
			
			int people = sc.nextInt();
			
			for (int i = 0; i <people; i++) {
				int start= sc.nextInt();
				int end = sc.nextInt();
				int start_room;
				int end_room;
				
				if(start>end) {
					int tem = start;
					start=end;
					end=tem;
				}
				
				if(start%2==0) start_room = start/2;
				else start_room = start/2+1;
				if(end%2==0) end_room = end/2;
				else end_room = end/2+1;
				
				
				for (int j = start_room; j <=end_room; j++) {
					room[j]++;
				}
			}
			
			for (int i = 0; i < room.length; i++) {
				if(answer<room[i]) answer=room[i];
			}

			System.out.println("#" + tc + " "+ answer);
		}
	
	}

}
