package dynamic3;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1126
// idea !!

public class SameTower {
	private static final int max = 500000;
	private static int dp[][];
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		for(int i=1; i<=n; i++)
			arr[i] = sc.nextInt();
		dp = new int[max+1][n+1];
		for(int i=0; i<max+1; i++)
			Arrays.fill(dp[i], -1);
		int answer = new SameTower().go(0, arr, 1);
		if(answer == 0)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
	private int go(int k, int arr[], int n){
		if(n == arr.length){
			if(k==0)
				return 0;
			else
				return -max-1;
		}
		if(dp[k][n] != -1)
			return dp[k][n];

		int ans;
		ans = go(k, arr, n+1);
		ans = Math.max(ans, go(k+arr[n], arr, n+1));
		if(k-arr[n] >= 0)
			ans = Math.max(ans, go(k-arr[n], arr, n+1)+arr[n]);
		else
			ans = Math.max(ans, go(arr[n]-k, arr, n+1)+k);
		return dp[k][n] = ans;
		
	}
}
