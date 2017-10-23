package dynamic2;

import java.util.Scanner;

// **  다시한번
// https://www.acmicpc.net/problem/1912

public class ContinuousSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		
		long dp[] = new long[n];
		dp[0] = arr[0];
		for(int i=1; i<n; i++){
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
		}
		
		long answer = Long.MIN_VALUE; 
		for(int i=0; i<n; i++)
			answer = Math.max(answer, dp[i]);
		System.out.println(answer);
		
	}

}
