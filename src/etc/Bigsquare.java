package etc;

import java.util.Arrays;
import java.util.Scanner;

public class Bigsquare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		int map[][] = new int[n+1][m+1];
		for(int i=0; i<=n; i++)
			Arrays.fill(map[i], 0);
		for(int i=1; i<=n; i++){
			String s = sc.nextLine();
			for(int j=1; j<=m; j++){
				map[i][j] = s.charAt(j-1)-48;
			}
		}
		// start
		int answer = 0;
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				if(map[i][j] != 0){
					map[i][j] = Math.min(map[i-1][j], Math.min(map[i-1][j-1], map[i][j-1]))+1;
					answer = Math.max(map[i][j], answer);
				}
			}
		}
		System.out.println(answer*answer);

	}

}
