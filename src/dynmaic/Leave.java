package dynmaic;

import java.util.Arrays;
import java.util.Scanner;

// dp
// https://www.acmicpc.net/problem/14501
// 문제를 잘 읽자
public class Leave {
	static int[]dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		dp = new int[n+1];
		
		for(int i=1; i<=n; i++){
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
			dp[i] = -1;
		}
		// start
		int max = 0;
		for(int i=1; i<=n; i++)
			max = Math.max(max, new Leave().leave(n, t, p, i));
		System.out.println(max);
	}
	
	private int leave(int n, int[]t, int[]p, int index){
		//base
		if(index > n || index+t[index]-1 > n)
			return 0;
		if(dp[index] != -1)
			return dp[index];
		if(index+t[index]>n)
			return p[index];
		int max = -1;
		for(int i=(index+t[index]); i<=n; i++){
			max = Math.max(max, p[index] + leave(n, t, p, i));
		}
		return dp[index]=max;
	}

}
