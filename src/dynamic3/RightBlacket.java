package dynamic3;

import java.util.Arrays;
import java.util.Scanner;

public class RightBlacket {
	private static long dp[][];
	private static char[] open ;
	private static char[] close ;
	private static final int MOD = 100000;
	private static boolean  over;
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		char[] arr = s.toCharArray();
		open = new char[]{'(', '{', '['};
		close = new char[]{')', '}', ']'};
		dp = new long[n][n];
		for(int i=0; i<n; i++)
			Arrays.fill(dp[i], -1);
		if(n%2 == 1){
			System.out.println(0);
			return;
		}
			
		long answer = new RightBlacket().rightBlacket(arr, 0, n-1);
		if(over){
			System.out.println(String.format("%05d", answer));
		}else
			System.out.println(answer);
	}
	private long rightBlacket(char[]arr, int i, int j){
		
		if(i>j)
			return 1;
		if(dp[i][j] != -1)
			return dp[i][j];
		
		dp[i][j] = 0;
		for(int k=i+1; k<=j; k+=2){
			for(int l=0; l<3; l++){
				if(arr[i] == open[l] || arr[i] == '?'){
					if(close[l] == arr[k] || arr[k] == '?'){
						long temp = (rightBlacket(arr, i+1, k-1) * rightBlacket(arr, k+1, j));
						
						if (dp[i][j] + temp >= MOD) {
	                        over = true;
	                    }
						dp[i][j] += temp;
						dp[i][j] %= MOD;
					}
				}
			}
		}
		return dp[i][j];
	}
}
