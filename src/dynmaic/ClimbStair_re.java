package dynmaic;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2579

public class ClimbStair_re {

	static int dp[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		dp = new int[3][n+1];
		
		for(int i=1; i<=n; i++){
			arr[i] = sc.nextInt();
		}

		dp[1][1] = arr[1];
		dp[2][1] = arr[1];
		for(int i=2; i<=n; i++){
			
			dp[1][i] = arr[i] + dp[2][i-1];
			dp[2][i] = arr[i] + Math.max(dp[1][i-2], dp[2][i-2]);
		}
		System.out.println(Math.max(dp[1][n], dp[2][n]));
		
	}
}
