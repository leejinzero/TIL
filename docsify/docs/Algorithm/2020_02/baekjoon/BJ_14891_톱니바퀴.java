package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14891_톱니바퀴 {
	static char[][] gear = new char[5][8] ;
	
	public static void rotation(int gear_num,int dir) {
		if(dir==1) {
			char tem = gear[gear_num][7];
			for (int i = 7; i >=0; i--) {
				if(i==0) {
					 gear[gear_num][0]=tem;
				}else {
					gear[gear_num][i]= gear[gear_num][i-1];
				}
			}
		}
		else {
			char tem = gear[gear_num][0];
			for (int i = 0; i < 8; i++) {
				if(i==7) {
					 gear[gear_num][7]=tem;
				}
				else {
					gear[gear_num][i]= gear[gear_num][i+1];
				}
			}
		}
	}
	
	public static boolean left(int a) {
		if(a-1>0 && a<=4) {
			return gear[a-1][2]!=gear[a][6];		
		}else return false;
	}
	
	public static boolean right(int a) {
		if(a+1<=4 && a>0) {
			return gear[a][2]!=gear[a+1][6];		
		}else return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i <= 4; i++) {
			String tem = bf.readLine();
			for (int j = 0; j < 8; j++) {
				gear[i][j]=tem.charAt(j);
			}
		}
		int rotation_num = Integer.parseInt(bf.readLine());
		for (int i = 0; i < rotation_num; i++) {
			StringTokenizer tokens = new StringTokenizer(bf.readLine());
			int target_gear = Integer.parseInt(tokens.nextToken());
			int dir = Integer.parseInt(tokens.nextToken());
			
			int lcnt=0;
			int rcnt=0;
			for (int j = 0; j < 3; j++) {
				if(left(target_gear-j)) {
					lcnt++;
				}else {
					break;
				}
			}
			
			for (int j = 0; j < 3; j++) {
				if(right(target_gear+j)) {
					rcnt++;
				}else {
					break;
				}
			}
			
			int tem_dir=dir*-1;
			for (int j = 1; j <=lcnt; j++) {
				rotation(target_gear-j,tem_dir);
				tem_dir*=-1;
			}
			
			tem_dir=dir*-1;
			for (int j = 1; j <=rcnt; j++) {
				rotation(target_gear+j,tem_dir);
				tem_dir*=-1;
			}
			
			rotation(target_gear,dir);
		}
		
		int sum=0;
		int gab=1;
		for (int i = 1; i <= 4; i++) {
			sum+=gab*(gear[i][0]-'0');
			gab*=2;
		}
		System.out.println(sum);
	}

}
