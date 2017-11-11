package kakao_code;

import java.util.Scanner;

// gg 모르겠다 ㅣㅅ간초과~

public class Treble {
	static int count;
	static long dp[][];
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int index = 0;
		for(index=1; index<=31; index++)
			if(Math.pow(3, index)+2*index > n)
				break;
		int mul = index -2;
		int plu = 2*mul;
		int num = mul+plu;
//		System.out.println(index);
		dp = new long[mul+1][num+1];
		new Treble().go(mul, num, 1, 3, n-2);
		System.out.println(count);
	}
	private void go(int mul, int num, int pos, long sum, int target){
		if(pos == num+1){
//			System.out.println(sum);
			if(sum == target)
				count++;
			return;
		}
		if(num-pos+1<mul)
			return;
		if(mul != 0 && dp[mul-1][pos] == 0)
			dp[mul-1][pos] = (long)Math.pow(3, mul-1);
		if(dp[mul][pos] == 0)
			dp[mul][pos] = (long)Math.pow(3, mul);
		
		
		if(mul != 0 && (sum*3)*dp[mul-1][pos]+ (num-pos-mul+1)<= target)
			go(mul-1, num, pos+1, sum*3, target);
		if((sum+1)* dp[mul][pos]+ (num-pos-mul)<= target)
			go(mul, num, pos+1, sum+1, target);
	}
}
