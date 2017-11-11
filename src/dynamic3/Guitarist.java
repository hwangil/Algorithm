package dynamic3;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1495
//새로운 dp유형 i think

public class Guitarist {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int s = sc.nextInt(); int m = sc.nextInt();
		int arr[] = new int[n+1];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int dp[][] = new int[m+1][n+1];
		dp[s][0] = 1;
		
		for(int i=0; i<=n-1; i++){
			for(int j=0; j<=m; j++){
				if(dp[j][i] == 1){
					if(j+arr[i]<=m)
						dp[j+arr[i]][i+1] = 1;
					if(j-arr[i]>=0)
						dp[j-arr[i]][i+1] = 1;
				}
			}
		}
		
		int answer = -1;
		for(int i=m; i>=0; i--){
			if(dp[i][n] == 1){
				answer = i;
				break;
			}
		}
		System.out.println(answer);
			
		
		
	}
}
