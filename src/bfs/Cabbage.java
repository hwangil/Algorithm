package bfs;

import java.util.Scanner;
import java.util.Stack;

public class Cabbage {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 0; t < testCase; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int k = sc.nextInt();
			int map[][] = new int[y + 2][x + 2];
			for (int i = 0; i < y + 2; i++) {
				for (int j = 0; j < x + 2; j++) {
					map[i][j] = 0;
				}
			}
			for (int i = 0; i < k; i++) {
				int _x = sc.nextInt();
				int _y = sc.nextInt();
				map[_y + 1][_x + 1] = 1;
			}
			boolean isVisited[][] = new boolean[y + 2][x + 2];
			Stack<int[]> s = new Stack<>();
			int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
			int count = 0;
			for (int i = 1; i <= y; i++) {
				for (int j = 1; j <= x; j++) {
					if (map[i][j] == 1 && !isVisited[i][j]) {
						count++;
						s.push(new int[]{i, j});
						while (!s.isEmpty()) {
							int select[] = s.pop();
							if (isVisited[select[0]][select[1]])
								continue;
							isVisited[select[0]][select[1]] = true;
							for (int d = 0; d < 4; d++) {
								int sY = select[0] + dir[d][0];
								int sX = select[1] + dir[d][1];
								if (map[sY][sX] == 1 && !isVisited[sY][sX]) {
									s.push(new int[] { sY, sX });
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
