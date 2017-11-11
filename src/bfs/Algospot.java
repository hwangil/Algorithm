package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1261

public class Algospot {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int map[][] = new int[n+2][m+2];
		for(int i=0; i<n+2; i++)
			Arrays.fill(map[i], -1);
		
		sc.nextLine();
		for(int i=1; i<=n; i++){
			String s = sc.nextLine();
			for(int j=1; j<=m; j++){
				map[i][j] = s.charAt(j-1)-'0';
			}
		}
		
		Queue <int[]> q = new LinkedList<>();
		q.offer(new int[]{1, 1});
		int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		int weight[][] = new int[n+2][m+2];
		for(int i=0; i<n+2; i++)
			Arrays.fill(weight[i], Integer.MAX_VALUE);
		weight[1][1] = 0;
		
		while(!q.isEmpty()){
			int []select = q.poll();
			int y = select[0]; int x = select[1];
			
			for(int d=0; d<4; d++){
				int dy = dir[d][0]; int dx = dir[d][1];
				if(map[y+dy][x+dx] == 0 && weight[y][x] < weight[y+dy][x+dx]){
					weight[y+dy][x+dx] = weight[y][x];
					q.offer(new int[]{y+dy, x+dx});
				}else if(map[y+dy][x+dx] == 1 && weight[y][x] < weight[y+dy][x+dx]){
					weight[y+dy][x+dx] = weight[y][x]+1;
					q.offer(new int[]{y+dy, x+dx});
				}
			}
			
		}
		System.out.println(weight[n][m]);
	}
}
