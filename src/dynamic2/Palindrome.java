package dynamic2;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10942

public class Palindrome {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		for(int i=1; i<=n; i++)
			arr[i] = sc.nextInt();
		int m = sc.nextInt();
		int quest[][] = new int[m][2];
		for(int i=0; i<m; i++){
			quest[i][0] = sc.nextInt();
			quest[i][1] = sc.nextInt();
		}
		int dp[][] = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=i; j++){
				if(j==i)
					dp[j][i] = 1;
				else if(j+1==i){
					if(arr[i] == arr[j])
						dp[j][i] = 1;
					else
						dp[j][i] = 0;
				}
				else{
					if(arr[j] == arr[i])
						dp[j][i] = dp[j+1][i-1];
					else
						dp[j][i] = 0;
				}
			}
		}
		
		for(int i=0; i<m; i++)
			System.out.println(dp[quest[i][0]][quest[i][1]]);
		
	}
}
