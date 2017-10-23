package dynamic2;

import java.util.Scanner;

public class PasswordCord {
	private static final int MOD = 1000000;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = s.length();
		char arr[] = new char[n+1];
		for(int i=0; i<n; i++)
			arr[i+1] = s.charAt(i);
		
		int dp[] = new int[n+1];
		dp[0] = 1;
		for(int i=1; i<=n; i++){
			int cur = (arr[i]-'0');
			if(cur >= 1 && cur <= 9){
				dp[i] = (dp[i] + dp[i-1])%MOD ;
			}
			if(i==1){
				continue;
			}
			
			int pre = (arr[i-1]-'0');
			if(pre == 0){
				continue;
			}
			
			if((pre*10 + cur) >= 10 && (pre*10 + cur) <= 26){
				dp[i] = (dp[i] + dp[i-2]) %MOD;
			}
		}
		
		System.out.println(dp[n]);
		
	}
}
