package review;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/5558

public class Cheese {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		char map[][] = new char[y+2][x+2];
		int start[] = new int[2];
		for(int i=0; i<y+2; i++)
			Arrays.fill(map[i], 'X');
		for(int i=0; i<y; i++){
			String s = sc.nextLine();
			for(int j=0; j<x; j++){
				map[i+1][j+1] = s.charAt(j);
				if(s.charAt(j) == 'S'){
					start[0] = i+1; start[1] = j+1;
				}
			}
		}
		//start
		Queue <int[]> q = new LinkedList<>();
		int answer[][] = new int[y+2][x+2];							// **
		int [][]dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int sum = 0;
		for(int target=1; target<=n; target++){
			for(int i=0; i<y+2; i++)
				Arrays.fill(answer[i], -1);
			answer[start[0]][start[1]] = 0;
			q.clear();
			q.offer(start);
			
			while(!q.isEmpty()){
				int[] select = q.poll();
				
				if(map[select[0]][select[1]] == '0'+target){
					sum += answer[select[0]][select[1]];
					start = select;
					break;
				}
				for(int d=0; d<4; d++){
					if(map[select[0]+dir[d][0]][select[1]+dir[d][1]] != 'X' && answer[select[0]+dir[d][0]][select[1]+dir[d][1]] == -1){
						answer[select[0]+dir[d][0]][select[1]+dir[d][1]] = answer[select[0]][select[1]]+1;
						q.offer(new int[]{select[0]+dir[d][0], select[1]+dir[d][1]});
					}
				}
			}
		}
		System.out.println(sum);
	}
}
