package kakao_code;

import java.util.Arrays;
import java.util.Stack;

public class Coloring {
	public static void main(String[] args){
		int picture[][] = new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int m = picture.length;
		int n = picture[0].length;
		int map[][] = new int[m+2][n+2];
		for(int i=0; i<m+2; i++)
			Arrays.fill(map[i], -1);
		for(int i=1; i<=m; i++)
			for(int j=1; j<=n; j++)
				map[i][j] = picture[i-1][j-1];
		
		Stack<int []> s = new Stack<>();
		boolean isVisited[][] = new boolean[m+1][n+1];
		int dir[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int totalNumber = 0;
		int bigArea = 0;
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				int color = map[i][j];
				if(color != 0 && !isVisited[i][j]){
					totalNumber++;
					int count = 0;
					s.push(new int[]{i, j});
					while(!s.isEmpty()){
						int select[] = s.pop();
						if(isVisited[select[0]][select[1]])
							continue;
						isVisited[select[0]][select[1]] = true;
						count++;
						for(int d=0; d<4; d++){
							int dy = dir[d][0]; int dx = dir[d][1];
							if(map[select[0]+dy][select[1]+dx] == color && !isVisited[select[0]+dy][select[1]+dx]){
								s.push(new int[]{select[0]+dy, select[1]+dx});
							}
						}
					}
					bigArea = Math.max(bigArea, count);
				}
			}
		}
		System.out.println(totalNumber);
		System.out.println(bigArea);
	}
}
