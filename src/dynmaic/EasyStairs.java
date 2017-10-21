package dynmaic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10844

public class EasyStairs {
	static int[] dp;
	private final static int C = 1000000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int dp[][] = new int[10][n];
		for(int i=0; i<10; i++)
			dp[i][0] = 1;
		dp[0][0] = 0;
		for(int i=1; i<n; i++){
			for(int j=0; j<=9; j++){
				if(j==0)
					dp[j][i] = dp[j+1][i-1]%C;
				else if(j==9)
					dp[j][i] = dp[j-1][i-1]%C;
				else
					dp[j][i] = (dp[j-1][i-1] + dp[j+1][i-1])%C;
			}
		}
		int sum = 0;
		for(int i=0; i<10; i++)
			sum = (sum+dp[i][n-1])%C;
//			sum += dp[i][n-1];
		System.out.println(sum%C);
		

	}

}
