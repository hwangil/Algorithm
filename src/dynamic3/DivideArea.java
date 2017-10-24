package dynamic3;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2228
// gg 어렵다 맞는거같은데 틀리네
// https://gist.github.com/Baekjoon/30a479acead102c97c28 참고

public class DivideArea {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int m = sc.nextInt();
		int arr[] = new int[n+1];
		int sum[] = new int[n+1];
		for(int i=1; i<=n; i++){
			arr[i] = sc.nextInt();
			sum[i] = sum[i-1] + arr[i];
		}
		
		int [][]dp = new int[m+1][n+1];
		for(int i=0; i<=m ; i++){
			Arrays.fill(dp[i], -32769);
//			dp[i][0] = 0;
		}
		dp[1][1] = arr[1];
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m && j<=i; j++){
				for(int k=2*j-1; k<=i; k++){
					if(j==1)
						dp[j][i] = Math.max(sum[i]-sum[k-1], dp[j][i]);
					else
						dp[j][i] = Math.max(dp[j-1][k-2] + sum[i]-sum[k-1], dp[j][i]);
				}
				dp[j][i] = Math.max(dp[j][i-1], dp[j][i]);
			}
		}
		System.out.println(dp[m][n]);
	}
}
