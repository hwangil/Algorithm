package dynmaic;

import java.util.Scanner;

public class TILING2 {
	static long dp[];
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int t=0; t<testCase; t++){
			int n = sc.nextInt();
			dp = new long[n+1];
			for(int i=0; i<n+1; i++)
				dp[i] = -1;
			System.out.println(new TILING2().tiling(n, 0)%1000000007);
		}
	}
	public long tiling(int n, int index){
		if(index == n-2)
			return 2;
		else if(index == n-1)
			return 1;
		
		if(dp[index] != -1)
			return dp[index];
		else
			return (dp[index] = tiling(n, index+1) + tiling(n, index+2)%1000000007);
	}
}
