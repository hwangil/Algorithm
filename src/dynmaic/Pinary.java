package dynmaic;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2193
// long 으로 해야한다.

public class Pinary {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long dp[][] = new long[2][n];
		dp[0][0] = 0;
		dp[1][0] = 1;
		for(int i=1; i<n; i++){
			dp[0][i] = dp[0][i-1] + dp[1][i-1];
			dp[1][i] = dp[0][i-1];
		}
		System.out.println(dp[0][n-1]+dp[1][n-1]);
	}
}
