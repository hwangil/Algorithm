package dynamic3;

import java.util.Scanner;

// https://www.acmicpc.net/problem/5557
// 새로운 dp유형

public class Grade1 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		
		long dp[][] = new long[21][n];
		dp[arr[0]][0] = 1;
		for(int i=0; i<n-2; i++){
			for(int j=0; j<21; j++){
				if(dp[j][i] > 0){
					if(j+arr[i+1]<=20)
						dp[j+arr[i+1]][i+1] += dp[j][i];
					if(j-arr[i+1]>=0)	
						dp[j-arr[i+1]][i+1] += dp[j][i];
				}
			}
		}
		System.out.println(dp[arr[n-1]][n-2]);
		
	}
}
