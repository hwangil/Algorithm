package kakao;

import java.util.Scanner;

// dp
// 테스트케이스 정답, 효율성 실패
public class Ka5 {
	static int dp[][];
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int map[][] = new int[n][4];
		dp = new int[n][4];
		for(int i=0; i<n; i++){
			for(int j=0; j<4; j++){
				map[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}
		// start
		int answer = -1;
		for(int i=0; i<4; i++)
			answer = Math.max(answer, new Ka5().sol(map, n, 0, i));
		System.out.println(answer);
		
	}
	private int sol(int[][] map, int n, int y, int x){
		if(y == n)		// index
			return 0;
		
		if(dp[y][x] != -1)
			return dp[y][x];
		int max = -1;
		for(int i=0; i<4; i++){
			if(i==x)
				continue;
			max = Math.max(sol(map, n, y+1, i), max);
		}
		return dp[y][x] = map[y][x] + max;
	}
}
