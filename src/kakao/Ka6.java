package kakao;

import java.util.Arrays;
import java.util.Scanner;

// dp
// 테스트 케이스 시간초과
public class Ka6 {

	static int dp[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		dp = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
			dp[i] = -1;
		}
		
		int answer=-1;
		for(int i=0; i<3; i++){
			Arrays.fill(dp, -1);
			answer = Math.max(answer, new Ka6().sol(n, arr, -1,  new boolean[n]));
		}
		System.out.println(answer);
	}
	private int sol(int n, int[] arr, int start, boolean[] isVisited){
		
		if(isVisited[start])
			return 0;
		isVisited[(start-1+n)%n] = true;
		isVisited[start] = true;
		isVisited[(start+1+n)%n] = true;
		
		if(dp[start] != -1)
			return dp[start];
		int max = 0;
		for(int i=1; i<n; i++){
			if(isVisited[(start+i)%n])
				continue;
			max = Math.max(max, sol(n, arr, (start+i)%n, copyArr(isVisited)));
		}
		
		return dp[start] = arr[start] + max;
		
	}
	private boolean[] copyArr(boolean[]_arr){
		boolean[] arr = new boolean[_arr.length];
		for(int i=0; i<arr.length; i++)
			arr[i] = _arr[i];
		return arr;
	}

}
