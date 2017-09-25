package dynmaic;

import java.util.Scanner;

public class ClimbStair {
	static int dp[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		dp = new int[3][n+1];
		for(int i=1; i<=n; i++){
			arr[i] = sc.nextInt();
			dp[1][i] = -1;
			dp[2][i] = -1;
		}
		arr[0] = 0;
		dp[0][0] = -1;
		dp[1][0] = -1;
		dp[2][0] = -1;
		System.out.println(new ClimbStair().climb(arr, 0, 0, 0));
	}
	
	private int climb(int[] arr, int index, int pre, int count){
		if(count == 3){
			return 0;
		}
		if(index >= arr.length)
			return 0;
		else if(index == arr.length-1)
			return arr[index];
		
		if(dp[pre][index] != -1){
			return dp[pre][index];
		}
		
		return dp[pre][index] = (arr[index] + (Math.max(climb(arr, index+1, 1, count+1), climb(arr, index+2, 2, 1))));
	}
	

}
