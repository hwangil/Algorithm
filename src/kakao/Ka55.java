package kakao;

import java.util.Scanner;

// greedy i think
public class Ka55 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int arr[][] = new int[][]{{1,2,3,5}, {5,6,7,8}, {4,3,2,1}};
		int n = arr.length;
		for(int k=0; k<n-1; k++){
			for(int i=0; i<4; i++){
				int max = -1;
				for(int j=0; j<4; j++){
					if(i==j) continue;
					max= Math.max(max, arr[k][j]);
				}
				arr[k+1][i] += max;
			}
		}
		
		int answer = -1;
		for(int i=0; i<4; i++){
			answer = Math.max(answer, arr[n-1][i]);
		}
		System.out.println(answer);
		
	}
}
