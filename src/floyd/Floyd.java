package floyd;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11404

public class Floyd {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int map[][] = new int[n+1][n+1];
		for(int i=0; i<n+1; i++){
			Arrays.fill(map[i], Integer.MAX_VALUE);
			map[i][i] = 0;
		}
		for(int i=0; i<m; i++){ 
			int y = sc.nextInt();
			int x = sc.nextInt();
			int w = sc.nextInt();
			map[y][x] = Math.min(map[y][x], w);
		}
		
		for(int k=1; k<=n; k++){
			for(int i=1; i<=n; i++){
				for(int j=1; j<=n; j++){
					if(map[i][k]==Integer.MAX_VALUE || map[k][j] == Integer.MAX_VALUE)
						continue;
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
