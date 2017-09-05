package dynmaic;

import java.util.Scanner;

// dynamic
// https://algospot.com/judge/problem/read/TRIANGLEPATH
public class TRIANGLEPATH {
	static int dp[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int t=0; t<testCase; t++){
			int n =sc.nextInt();
			int map[][] = new int[n+1][n+1];
			dp = new int[n+1][n+1];
			for(int i=1; i<=n; i++){
				for(int j=1; j<=i; j++){
					map[i][j] = sc.nextInt();
					dp[i][j] = -1;
				}
			}
			//start
			System.out.println(new TRIANGLEPATH().path(map,  n,  1, 1));
			
		}
	}
	
	public int path(int[][]map, int n, int y, int x){
		if(y==n){
			return map[y][x];
		}
		if(dp[y][x] != -1)
			return dp[y][x];
		else
			return dp[y][x] = (Math.max(path(map, n, y+1, x)+map[y][x], path(map, n, y+1, x+1)+map[y][x])); 
	}

}
