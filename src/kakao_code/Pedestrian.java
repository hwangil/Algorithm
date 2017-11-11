package kakao_code;

import java.util.Arrays;

public class Pedestrian {
	public static void main(String[] args){
		int[][] cityMap = new int[][]{{0, 0, 0}};
		int m = cityMap.length;
		int n = cityMap[0].length;
		int map[][] = new int[m+1][n+1];
		for(int i=0; i<=m; i++)
			Arrays.fill(map[i], 1);
		for(int i=1; i<=m; i++)
			for(int j=1; j<=n; j++)
				map[i][j] = cityMap[i-1][j-1];
		int dp[][] = new int[m+1][n+1];
		dp[1][1] = 1;
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				if(map[i][j] == 0){
					dp[i][j] += dp[i-1][j] + dp[i][j-1];
				}else if(map[i][j] == 2){
					if(map[i-1][j] == 0){
						for(int k=i+1; k<=m; k++){
							if(map[k][j] == 0){
								dp[k][j] += dp[i-1][j];
								break;
							}else if(map[k][j] == 1){
								break;
							}
						}
					}
					if(map[i][j-1] == 0){
						for(int k=j+1; k<=n; k++){
							if(map[i][k] == 0){
								dp[i][k] += dp[i][j-1];
								break;
							}else if(map[i][k] == 1)
								break;
						}
					}
				}
					
			}
		}
		System.out.println(dp[m][n]);
	}
}
