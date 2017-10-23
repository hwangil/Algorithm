package dynamic2;

import java.util.Arrays;
import java.util.Scanner;

public class Coin2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int k = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		
		int dp[] = new int[k+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i=1; i<=k; i++){
			for(int j=0; j<n; j++){
				if(i-arr[j]>=0 && dp[i-arr[j]]!= Integer.MAX_VALUE)
					dp[i] = Math.min(dp[i], dp[i-arr[j]]+1);
			}
		}
		if(dp[k] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
		
	}
}
