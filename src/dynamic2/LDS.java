package dynamic2;

import java.util.Scanner;
// https://www.acmicpc.net/problem/11722

public class LDS {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		
		long dp[] = new long[n];
		dp[0] = 1;
		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++){
				if(arr[i]<arr[j] && dp[i] <dp [j])
					dp[i] = dp[j];
			}
			dp[i] += 1;
		}
		
		long answer = 0;
		for(int i=0; i<n; i++){
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}
