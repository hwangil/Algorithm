package dynmaic;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11726
public class Tiling {

	static int dp[];
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n+1];
		Arrays.fill(dp, -1);
		if(n==1)
			System.out.println(1);
		else{
			dp[1] = 1;
			dp[2] = 2;
			System.out.println(tiling(n)%10007);
			
	//		for(int i=3; i<=n; i++){
	//			if(dp[i]!=-1)
	//				continue;
	//			dp[i] = (dp[i-1]+dp[i-2])%10007;
	//		}
	//		System.out.println(dp[n]);
		}
		
	}
	
	private static int tiling(int n){
		if(dp[n] != -1)
			return dp[n];
		return dp[n] = ((tiling(n-1) + tiling(n-2))%10007);
	}
}
