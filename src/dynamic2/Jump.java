package dynamic2;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1890

public class Jump {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int map[][] = new int[n][n];
		long dp[][] = new long[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				map[i][j] = sc.nextInt();
			}
		}
		
		dp[0][0] = 1;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(map[i][j] == 0 ) continue;
				
				if(map[i][j]+i < n){
					dp[i+map[i][j]][j] += dp[i][j];
				}
				if(map[i][j]+j < n){
					dp[i][j+map[i][j]] += dp[i][j];
				}
//				for(int k=0; k<j; k++){
//					if(j-k == map[i][k])
//						dp[i][j] += dp[i][k];
//				}
//				for(int k=0; k<i; k++){
//					if(i-k == map[k][j])
//						dp[i][j] += dp[k][j];
//				}
			}
		}
		System.out.println(dp[n-1][n-1]);
	}
}
