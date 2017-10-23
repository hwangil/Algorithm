package dynmaic;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11057

public class Ascent {
	private static final int C = 10007;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long dp[][] = new long[10][n];
		for(int i=0; i<10; i++)
			dp[i][0] = 1;
		for(int i=1; i<n; i++){
			for(int j=0; j<10; j++){
				for(int k=0; k<=j; k++)
					dp[j][i] = (dp[j][i] + dp[j-k][i-1])%C;
			}
		}
		long sum = 0;
		for(int i=0; i<10; i++)
			sum= (sum+dp[i][n-1])%C;
		System.out.println(sum);
	}
}
