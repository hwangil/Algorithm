package dynmaic;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9465

public class Sticker {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int t=0; t<testCase; t++){
			int n = sc.nextInt();
			int[][] arr = new int[2][n];
			for(int i=0; i<n; i++)
				arr[0][i] = sc.nextInt();
			for(int i=0; i<n; i++)
				arr[1][i] = sc.nextInt();
			
			//start
			long dp[][] = new long[3][n];
			dp[0][0] = 0;
			dp[1][0] = arr[0][0];
			dp[2][0] = arr[1][0];
			for(int i=1; i<n; i++){
				dp[0][i] = Math.max(Math.max(dp[1][i-1], dp[2][i-1]), dp[0][i-1]);
				dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1])+arr[0][i];
				dp[2][i] = Math.max(dp[0][i-1], dp[1][i-1])+arr[1][i];
			}
			System.out.println(Math.max(Math.max(dp[1][n-1], dp[2][n-1]), dp[0][n-1]));
			
		}
	}
}
