package dynamic2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/11048

public class Move {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int map[][] = new int[n+1][m+1];
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				map[i][j] = sc.nextInt();
			}
		}
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				map[i][j] += Math.max(Math.max(map[i-1][j], map[i][j-1]), map[i-1][j-1]);
			}
		}
		System.out.println(map[n][m]);
	}
}
			
			
//		시간 초과
//		Stack<int[]> s = new Stack<>();
//		s.push(new int[]{0,0, map[0][0]});
//		int dir[][] = new int[][]{{1, 0}, {1, 1}, {0, 1}};
//		int max = 0;
//		int [][] dp = new int[n][m];
//		for(int i=0; i<n; i++)
//			Arrays.fill(dp[i], -1);
//		while(!s.isEmpty()){
//			int select[] = s.pop();
//			dp[select[0]][select[1]] = select[2];
//			for(int d=0; d<3; d++){
//				int y = dir[d][0];
//				int x = dir[d][1];
//				if(map[select[0]+y][select[1]+x] != -1 && dp[select[0]+y][select[1]+x] < select[2]+map[select[0]+y][select[1]+x]){
//					s.push(new int[]{select[0]+y, select[1]+x, select[2]+map[select[0]+y][select[1]+x]});
//				}
//					
//			}
//		}
//		System.out.println(dp[n-1][m-1]);
