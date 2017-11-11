package dynamic3;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfFiles {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int t=0; t<testCase; t++){
			int n = sc.nextInt();
			int arr[] = new int[n+1];
			int sum[] = new int[n+1];
			for(int i=1; i<=n; i++){
				arr[i] = sc.nextInt();
				sum[i] = sum[i-1]+arr[i];
			}
			int dp[][] = new int[n+1][n+1];
			for(int i=0; i<=n; i++){
				Arrays.fill(dp[i], Integer.MAX_VALUE);
				dp[i][i] = 0;
			}
			for(int i=1; i<=n; i++){
				for(int j=i-1; j>=1; j--){
					for(int k=1; k<=i-j; k++)
						dp[j][i] = Math.min(dp[j][i-k] + dp[i-k+1][i] + sum[i]-sum[j-1], dp[j][i]);
				}
			}
			System.out.println(dp[1][n]);
		}
	}
}
