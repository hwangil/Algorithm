package dynmaic;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/14501

public class Leave_re {
	static int dp[];
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t[] = new int[n+1];
		int p[] = new int[n+1];
		dp = new int[n+1];
		Arrays.fill(dp, -1);
		for(int i=1; i<=n; i++){
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		System.out.println(leave(0, t, p, n));
	}
	
	private static int leave(int index, int[] t, int[] p, int n){
		
		if(index+t[index] > n+1)
			return 0;
		
		if(dp[index] != -1)
			return dp[index];
		dp[index] = p[index];
		for(int i=index+t[index]; i<=n; i++)
			dp[index] = Math.max(dp[index], p[index] + leave(i, t, p, n));
		
		return dp[index];
	}

}
