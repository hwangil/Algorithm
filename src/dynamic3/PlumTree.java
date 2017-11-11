package dynamic3;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2240

public class PlumTree {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int w = sc.nextInt();
		int []arr = new int[t+1];
		
		for(int i=1; i<=t; i++)
			arr[i] = sc.nextInt();
		
		int dp[][] = new int[w+2][t+1];
		for(int i=1; i<=t; i++){
			for(int j=1; j<=w+1 &&j<=i+1; j++){
				
				dp[j][i] = Math.max(dp[j][i-1], dp[j-1][i-1]);
				if((j+1)%2+1 == arr[i])
					dp[j][i] += 1;
			}
		}
		// 이게 맞다
//		int answer = 0;
//		for(int i=1; i<w+2; i++)
//			answer = Math.max(answer, dp[i][t]);
//		System.out.println(answer);
		System.out.println(dp[w+1][t]);
		
	}
}
