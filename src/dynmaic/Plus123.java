package dynmaic;

import java.util.Arrays;
import java.util.Scanner;

// dp
// https://www.acmicpc.net/problem/9095
public class Plus123 {
	static int dp[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int t=0; t<testCase; t++){
			int n = sc.nextInt();
			dp = new int[n+1];
			Arrays.fill(dp, -1);
			System.out.println(new Plus123().plus(n, 0));
		}
	}
	private int plus(int n, int index){
		if(index == n-3)
			return 4;
		else if(index == n-2)
			return 2;
		else if(index == n-1)
			return 1;
		if(dp[index] != -1)
			return dp[index];
		
		return (dp[index]=plus(n, index+1) + plus(n, index+2) + plus(n, index+3));
		
	}
	
}
