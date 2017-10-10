package review;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//https://www.acmicpc.net/problem/1012

public class Cabbage {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for(int t=0; t<testCase; t++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			int k = sc.nextInt();
			int map[][] = new int[y+2][x+2];
			for(int i=0; i<k; i++){
				int kX = sc.nextInt();
				int kY = sc.nextInt();
				map[kY+1][kX+1] = 1;
			}
			// start
			boolean isVisited[][] = new boolean[y+2][x+2];
			int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
			int count = 0;
			for(int i=1; i<=y; i++){
				for(int j=1; j<=x; j++){
					if(!isVisited[i][j] && map[i][j]==1){
						count++;							// **
						Stack<int[]> s = new Stack<>();
						s.push(new int[]{i, j});
						while(!s.isEmpty()){
							int[] select = s.pop();
							if(isVisited[select[0]][select[1]])
								continue;
							isVisited[select[0]][select[1]] = true;
							for(int d=0; d<4; d++){
								if(map[select[0]+dir[d][0]][select[1]+dir[d][1]]==1 && !isVisited[select[0]+dir[d][0]][select[1]+dir[d][1]]){
									s.push(new int[]{select[0]+dir[d][0], select[1]+dir[d][1]});
								}
							}
						}
					}
				}
			}
			
			System.out.println(count);
			
		}
	}
	
}
