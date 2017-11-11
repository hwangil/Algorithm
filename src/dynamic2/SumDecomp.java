package dynamic2;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2225
// *** ´Ù½Ã

public class SumDecomp {
	private static final int C = 1000000000;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		long dp[][] = new long[n+1][k+1];
		
		for(int i=0; i<=n; i++){
			dp[i][1] = 1;
		}
		for(int i=2; i<=k; i++){	
			for(int j=0; j<=n; j++){
				for(int l=0; l<=j; l++){
					dp[j][i] += dp[j-l][i-1];
					dp[j][i] %= C;
				}
			}
		}
		
		System.out.println(dp[n][k]);
	
	}
}
