package dynamic2;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9461
public class Padoban {
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int t=0; t<testCase; t++){
			int n = sc.nextInt();
			long dp[] = new long[n+1];
			for(int i=1; i<=n; i++){
				if(i==1 || i==2 || i==3)
					dp[i] = 1;
				else if(i==4 || i==5)
					dp[i] = 2;
				else{	
					dp[i] = dp[i-1] + dp[i-5];
				}
			}
			System.out.println(dp[n]);
		}
	}
}
