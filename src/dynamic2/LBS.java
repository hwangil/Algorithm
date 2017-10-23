package dynamic2;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11054

public class LBS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		
		long dp[][] = new long[2][n];
		dp[0][0] = 1;
		dp[1][n-1] = 1;

		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++)
				if(arr[i]>arr[j])
					dp[0][i] = Math.max(dp[0][i], dp[0][j]);
			dp[0][i]++;
		}
		for(int i=n-2; i>=0; i--){
			for(int j=n-1; j>i; j--)
				if(arr[i]>arr[j])
					dp[1][i] = Math.max(dp[1][i], dp[1][j]);
			dp[1][i]++;
		}
			
		long answer = 0;
		for(int i=0; i<n; i++){
			answer = Math.max(answer, dp[0][i]+dp[1][i]);
		}
		System.out.println(answer-1);
	}
}
