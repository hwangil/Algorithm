package dynmaic;

import java.util.Scanner;

public class ASYMTILING {
	static long[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int t=0; t<testCase; t++){
			int n = sc.nextInt();
			dp = new long[n+1];
			initDp(n);
			long total = (new ASYMTILING().tiling(n, 0));
			long symTotal;
			if(n%2 == 0){
				initDp(n);
				total = (total - new ASYMTILING().tiling(n/2, 0) + 1000000007)%1000000007;
				initDp(n);
				total = (total - new ASYMTILING().tiling(n/2-1, 0) + 1000000007)%1000000007;
			}
			
			else{
				initDp(n);
				total = (total - new ASYMTILING().tiling(n/2, 0) + 1000000007)%1000000007;
			}
			System.out.println(total);
		}
	}
	public long tiling(int n, int index){
		if(index == n-1)
			return 1;
		else if(index == n-2)
			return 2;
		else if(n == 0)
			return 1;
		if(dp[index] != -1)
			return dp[index];
		return (dp[index] = (tiling(n, index+1) + tiling(n, index+2))%1000000007);
	}
	public static void initDp(int n){
		for(int i=0; i<=n; i++)
			dp[i] = -1;
	}
}
