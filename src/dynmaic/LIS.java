package dynmaic;

import java.util.Scanner;

// dp
// https://algospot.com/judge/problem/read/LIS
public class LIS {
	static int dp[];
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int t=0; t<testCase; t++){
			int n = sc.nextInt();
			int arr[] = new int[n];
			dp = new int[n];
			for(int i=0; i<n; i++){
				arr[i] = sc.nextInt();
				dp[i] = -1;
			}
			//start
			int answer = 0;
			for(int i=0; i<n; i++)
				answer = Math.max(answer, new LIS().lis(arr, n, i));
			System.out.println(answer);
			
		}
	}
	
	public int lis(int[]arr, int n, int index){
		if(dp[index] != -1)
			return dp[index];
		
		int count = 1;
		for(int i=index+1; i<n; i++){
			if(arr[index] < arr[i]){
				count = Math.max(count, lis(arr, n, i)+1);
			}
		}
		dp[index] = count;
		return count;
		
	}
}
