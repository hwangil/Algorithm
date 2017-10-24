package dynamic3;

import java.util.Scanner;

public class HighBuilding {
	private static final int mod = 1000000007;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int R = sc.nextInt();
		
		int n = N-1;
		int r = R-1;
		
		int dp[][] = new int[n+1][r+1];
		for(int i=0; i<=n; i++)
			dp[i][0] = 1;
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=r ; j++){
				if(i==j){
					dp[i][j] = 1;
					break;
				}
				else
					dp[i][j] = (dp[i-1][j] + dp[i-1][j-1])%mod;
			}
		}
		System.out.println(dp[n][r]);
		
	}
}
