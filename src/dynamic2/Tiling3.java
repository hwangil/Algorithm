package dynamic2;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2133

public class Tiling3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[n+1];
		dp[0] = 1;
		dp[1] = 0;
		for(int i=2; i<=n; i++){
			dp[i] = dp[i-2]*3;
			for(int j=4; i-j >=0; j=j+2){
				dp[i] += 2*dp[i-j];
			}
		}
		System.out.println(dp[n]);
	}
}
