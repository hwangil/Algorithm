package dynamic2;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1699

public class SumOfSquares {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long dp[] = new long[n+1];
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 1; 
		for(int i=2; i<=n; i++){
//			dp[i] = i;				// 1^2들로 구성이 최대값
			for(int j=1; j*j<=i; j++){
				dp[i] = Math.min(dp[i-j*j], dp[i]);
			}
			dp[i]+=1;
		}
		
		System.out.println(dp[n]);
	}
}
