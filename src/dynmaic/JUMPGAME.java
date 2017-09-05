package dynmaic;

import java.util.Scanner;

// dynamic programming
// https://algospot.com/judge/problem/read/JUMPGAME
public class JUMPGAME {

	static int dp[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int t=0; t<testCase; t++){
			int n = sc.nextInt();
			dp = new int[n+1][n+1];
			int[][]map = new int[n+1][n+1];
			for(int i=1; i<=n; i++){
				for(int j=1; j<=n; j++){
						map[i][j] = sc.nextInt();
						dp[i][j] = -1;
				}
			}
			//start
			if(new JUMPGAME().jump(n, 1, 1, map) == 1)
				System.out.println("YES");
			else
				System.out.println("NO");
			
		}
	}
	
	public int jump(int n, int y, int x, int[][]map){
		if(y>n || x>n)
			return 0;
		if(y==n && x==n)
			return 1;
		
		if(dp[y][n] != -1)
			return dp[y][n];
		else if(jump(n, y+map[y][x], x, map)==1 || jump(n, y, x+map[y][x], map)==1){
			dp[y][x] = 1;
			return 1;
		}else
			dp[y][x] = 0;
			return 0;
	}

}
