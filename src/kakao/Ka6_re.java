package kakao;

public class Ka6_re {
	public static void main(String[] args) {
		int arr[] = new int[]{1};
		int n = arr.length;
		if(n==1){
            System.out.println(arr[0]);
        }else{
			int dp[][] = new int[2][n];
			dp[1][0] = arr[0];
			for(int i=1; i<n-1; i++){
				dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1]);
				dp[1][i] = dp[0][i-1] + arr[i];
			}
			int answer = Math.max(dp[0][n-2], dp[1][n-2]);
			dp = new int[2][n];
			dp[1][1] = arr[1];
			for(int i=2; i<n; i++){
				dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1]);
				dp[1][i] = dp[0][i-1] + arr[i];
			}
			System.out.println(Math.max(answer, Math.max(dp[0][n-1], dp[1][n-1])));
        }
	}
}
