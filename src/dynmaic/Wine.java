package dynmaic;

import java.util.Scanner;

// https://www.acmicpc.net/submit/2156
// 1차원으로도 풀수 있음 

public class Wine {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
	
		long dp[][] = new long[3][n];
		dp[0][0] = 0;
		dp[1][0] = arr[0];
		dp[2][0] = 0;
		
		for(int i=1; i<n; i++){
			dp[0][i] = Math.max(Math.max(dp[0][i-1], dp[1][i-1]), dp[2][i-1]);
			dp[1][i] = dp[0][i-1] + arr[i];
			dp[2][i] = dp[1][i-1] + arr[i];
		}
		System.out.println(Math.max(Math.max(dp[0][n-1], dp[1][n-1]), dp[2][n-1]));
	}
}
