package dynamic2;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11055

public class BIS {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		
		int dp[] = new int[n];
		dp[0] = arr[0];
		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++){
				if(arr[i]>arr[j]){
					dp[i] = Math.max(dp[i], dp[j]);
				}
			}
			dp[i] += arr[i];
		}
		int max = 0;
		for(int i=0; i<n; i++){
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
