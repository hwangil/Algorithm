package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Cheese {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		
		char map[][] = new char[h+2][w+2];
		int answer[][] = new int[h+2][w+2];
		int start[] = new int[2];
		for(int i=0; i<h+2; i++){
			Arrays.fill(map[i], 'X');
			Arrays.fill(answer[i], 0);
		}
		for(int i=1; i<=h; i++){
			String s = sc.nextLine();
			for(int j=1; j<=w; j++){
				map[i][j] = s.charAt(j-1);
				if(map[i][j] == 'S'){
					start[0] = i;
					start[1] = j;
				}
			}
		}
		
		int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int sum = 0;
		for(int i=1; i<=n; i++){
			Queue<int[]> q = new LinkedList<>();
			q.offer(start);
			
			while(!q.isEmpty()){
				int[] select = q.poll();
				if(map[select[0]][select[1]] == ('0'+i)){
					sum += answer[select[0]][select[1]];
					start = select;
					break;
				}
				for(int d=0; d<4; d++){
					int y = dir[d][0];
					int x = dir[d][1];
					if(map[select[0]+y][select[1]+x] != 'X' && answer[select[0]+y][select[1]+x] == 0){
						answer[select[0]+y][select[1]+x] = answer[select[0]][select[1]] + 1;
						q.offer(new int[]{select[0]+y, select[1]+x});
					}
				}
			}
			for(int r=0; r<h+2; r++){
				Arrays.fill(answer[r], 0);
			}
		}
			
		System.out.println(sum);
	}

}
