package dynmaic;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1463

public class MakeOne {
	static int dp[];
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = 0;
		for(int i=2; i<=n; i++){
			int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE; 
			if(dp[n] != -1)
				continue;
			a = dp[i-1]+1;
			if(i%3==0)
				b = dp[i/3] + 1;
			if(i%2==0)
				c = dp[i/2] + 1;
			dp[i] = Math.min(c, Math.min(a, b));
		}
		System.out.println(dp[n]);
//		System.out.println(makeOne(n));
	}
	private static int makeOne(int n){
		
		if(n==1)
			return 0;
		
		if(dp[n] != -1)
			return dp[n];
		
		int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE; 
		a = makeOne(n-1);
		if(n%3==0)
			b = makeOne(n/3);
		if(n%2==0)
			c = makeOne(n/2);
				
		return dp[n] = 1+Math.min(Math.min(a, b), c);
	}
}
