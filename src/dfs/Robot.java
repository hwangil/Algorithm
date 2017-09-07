package dfs;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

// not dfs
// 역시 문제를 잘 읽자

public class Robot {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		int[]start = new int[3];
		start[0] = sc.nextInt();
		start[1] = sc.nextInt();
		int direction = sc.nextInt();
		// 0 -> 북 , 1->동, 2-> 남, 3->서
		int dir[][][] = new int[][][]{
			{{0, -1}, {1, 0}, {0, 1}, {-1, 0}}, 
			{{-1, 0}, {0, -1}, {1, 0}, {0, 1}},
			{{0, 1}, {-1, 0}, {0, -1}, {1, 0}},
			{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}};
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				map[i][j] = sc.nextInt();
			}
		}
		
		//start
		Stack <int[]> s = new Stack<>();
		s.push(start);
		boolean isVisited[][] = new boolean[n][m];
		int count =0 ;
		while(!s.isEmpty()){
			int[]select= s.pop();
			if(!isVisited[select[0]][select[1]]){
				count++;
				isVisited[select[0]][select[1]] = true;
			}
			
			for(int d=0; d<4; d++){
				int y = dir[direction][d][0];
				int x = dir[direction][d][1];
				
				if(map[select[0]+y][select[1]+x] != 1 && !isVisited[select[0]+y][select[1]+x]){
					s.push(new int[]{select[0]+y, select[1]+x});
					direction = (direction-(d+1)+4)%4;
					break;
				}
			}
			if(s.isEmpty()){
				if(map[select[0]+dir[direction][1][0]][select[1]+dir[direction][1][1]] != 1)
					s.push(new int[]{select[0]+dir[direction][1][0], select[1]+dir[direction][1][1]});
			}
		}
		System.out.println(count);
	}
}
