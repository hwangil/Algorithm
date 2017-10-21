package kakao;

import java.util.Arrays;
import java.util.Scanner;

public class Ka66 {
	static int dp[];
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[] {1, 2, 3};
		int n = arr.length;
		
		dp = new int[n];
		for(int i=0; i<3; i++){
			Arrays.fill(dp, -1);
			System.out.println(sol(arr, i, i));
		}
		
	}
	private static int sol(int[]arr, int start, int index){
		int n = arr.length;
		if(index >= n)
			return 0;
		if(dp[index] != -1)
			return dp[index];
		
		if((index+2+n)%n == (start -1+n)%n){
			return arr[index];
		}else if((index+3+n)%n == (start -1+n)%n){
			return dp[index] = (arr[index] + sol(arr, start, index+2));
		}else
			return dp[index] = (arr[index] + Math.max(sol(arr, start, index+2), sol(arr, start, index+3)));
	}
}
