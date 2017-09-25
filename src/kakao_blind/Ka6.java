package kakao_blind;

import java.util.Arrays;
import java.util.Scanner;

public class Ka6 {
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();		// m
		int x = sc.nextInt();		// n
		String[] board = new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"};
		
		char map[][] = new char[y+2][x+2];
		for(int i=0; i<y+2; i++)
			Arrays.fill(map[i], 'X');
		for(int i=1; i<=y; i++){
			for(int j=1; j<=x; j++){
				map[i][j] = board[i-1].charAt(j-1);
			}
		}
		
		// start
		int dir[][] = new int[][]{{0, 1}, {1, 1}, {1, 0}};
		boolean isChecked [][] = new boolean[y+2][x+2];
		boolean isVisited [][] = new boolean[y+2][x+2];
		
		while(check(y, x, map, isChecked)){
			for(int i=1; i<=y; i++){
				for(int j=1; j<=x; j++){
					if(map[i][j] != '0' && isChecked[i][j]&&!isVisited[i][j]){
						dfs(i, j, isChecked, isVisited);
					}
				}
			}
			down(y, x, map, isChecked);
			for(int i=1; i<= y; i++){
				Arrays.fill(isChecked[i], false);
				Arrays.fill(isVisited[i], false);
			}
		}
		System.out.println(count);
		
		
	}
	// ³»¸®±â
	static void down(int y, int x, char [][] map, boolean[][] isChecked){
		for(int i=1; i<=y; i++){
			for(int j=1; j<=x; j++){
				if(isChecked[i][j])
					map[i][j] = '0';
			}
		}
//		for(int i=1; i<=y; i++){
//			for(int j=1; j<=x; j++){
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		//
		for(int i=1; i<=x; i++){
			int zero = 0;
			for(int j=y; j>=1; j--){
				if(map[j][i] == '0'){
					zero++;
				}
				else if(map[j][i] != '0' && zero > 0){
					map[j+zero][i] = map[j][i];
					map[j][i] = '0';
				}
			}
		}
//		for(int i=1; i<=y; i++){
//			for(int j=1; j<=x; j++){
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
	}
	
	static boolean check(int y, int x, char [][] map, boolean[][] isChecked){
		boolean isExist = false;
		for(int i=1; i<=y; i++){
			for(int j=1; j<=x; j++){
				
				if(map[i][j] != '0' && map[i][j]==map[i+1][j] 
						&&map[i][j]==map[i][j+1] 
								&& map[i][j]==map[i+1][j+1]){
					isChecked[i][j] = true;
					isChecked[i+1][j] = true;
					isChecked[i][j+1] = true;
					isChecked[i+1][j+1] = true;
					isExist = true;
				}
				
			}
		}
		return isExist;
	}
	static void dfs(int y, int x, boolean[][] isChecked, boolean[][] isVisited){
		if(isVisited[y][x])
			return;
		isVisited[y][x] = true;
		count++;
		int dir[][] = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		for(int d=0; d<4; d++){
			if(isChecked[y][x] && isChecked[y+dir[d][0]][x+dir[d][1]] && !isVisited[y+dir[d][0]][x+dir[d][1]]){
				dfs(y+dir[d][0], x+dir[d][1], isChecked, isVisited);
			}
		}
	}
	
}
