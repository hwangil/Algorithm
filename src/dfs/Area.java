package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//dfs
//https://www.acmicpc.net/problem/2583

public class Area {
	static int count =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		int k = sc.nextInt();

		int map[][] = new int[y][x];
		for (int i = 0; i < y; i++)
			Arrays.fill(map[i], 0);
		for (int i = 0; i < k; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for (int m = y1; m < y2; m++) {
				for (int n = x1; n < x2; n++) {
					map[m][n] = 1;
				}
			}
		}
		
		boolean isVisited[][] = new boolean[y][x];
		int area = 0;
		ArrayList areaList = new ArrayList<>();
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (map[i][j] == 0 && !isVisited[i][j]) {
					// dfs
					new Area().dfs(map, isVisited, i, j);
					area++;
					areaList.add(count);
					count = 0;
				}
			}
		}
		
		System.out.println(area);
		Collections.sort(areaList);
		for (int i = 0; i < areaList.size(); i++) {
			System.out.print(areaList.get(i) + " ");
		}

	}

	private void dfs(int[][] map, boolean[][] isVisited, int y, int x) {
		isVisited[y][x] = true;
		count++;
		// 왼쪽.
		if (x - 1 >= 0 && map[y][x - 1] == 0 && !isVisited[y][x - 1]) {
			dfs(map, isVisited, y, x-1);
		}
		// 위쪽.
		if (y - 1 >= 0 && map[y - 1][x] == 0 && !isVisited[y - 1][x]) {
			dfs(map, isVisited, y-1, x);
		}
		// 오른쪽.
		if (x + 1 < map[0].length && map[y][x + 1] == 0 && !isVisited[y][x + 1]) {
			dfs(map, isVisited, y, x+1);
		}
		// 아래쪽.
		if (y + 1 < map.length && map[y + 1][x] == 0 && !isVisited[y + 1][x]) {
			dfs(map, isVisited, y+1, x);
		}
		
	}

}
