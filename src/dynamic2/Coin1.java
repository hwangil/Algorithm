package dynamic2;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2293
public class Coin1 {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int dp[] = new int[k+1];
		dp[0] = 1;
		for(int j=0; j<n ; j++){
			for(int i=1; i<=k ; i++){
				if(arr[j]<=i)
					dp[i] += dp[i-arr[j]];
			}
		}
		System.out.println(dp[k]);
	}
}
