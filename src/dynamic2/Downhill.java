package dynamic2;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1520
// dp를 0으로 초기화해주면 무한루프가 돈다. 왜그런지는 지금 모르겟다 나중에 생각하자! https://www.acmicpc.net/board/view/14670

public class Downhill {
	static long dp[][];
	static int dir[][];
	static int m;
	static int n;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		int map[][] = new int[m+2][n+2];
		for(int i=0; i<m+2; i++)
			Arrays.fill(map[i], 10001);
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				map[i][j] = sc.nextInt();
			}
		}
		dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		dp = new long[m+1][n+1];
		for(int i=0; i<m+1; i++)
			Arrays.fill(dp[i], -1);			// **
		System.out.println(new Downhill().downhill(map, 1, 1));
		
	}
	long downhill(int map[][], int y, int x){
		if(y == m && x == n)
			return 1;
		if(dp[y][x] != -1)
			return dp[y][x];
		dp[y][x] = 0;				// **
		for(int d=0; d<4; d++){
			int dy = dir[d][0];
			int dx = dir[d][1];
			if(map[y][x] > map[y+dy][x+dx])
				dp[y][x] += downhill(map, y+dy, x+dx);
		}
		return dp[y][x];
	}
}
