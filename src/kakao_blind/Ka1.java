package kakao_blind;

import java.util.Arrays;
import java.util.Scanner;

public class Ka1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		int map1[][] = new int[n][n];
		int map2[][] = new int[n][n];
		String answer[] = new String[n];
		for(int i=0; i<n; i++){
			arr1[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++){
			arr2[i] = sc.nextInt();
		}
		
		
		for(int i=0; i<n; i++){
			map1[i] = new Ka1().change(n, arr1[i]);
			map2[i] = new Ka1().change(n, arr2[i]);
		}
		
		for(int i=0; i<n; i++){
			answer[i] = "";
			for(int j=0; j<n; j++){
				if(map1[i][j] == 1 || map2[i][j] == 1)
					answer[i] += "#";
				else if(map1[i][j] == 0 && map2[i][j] == 0)
					answer[i] += " ";
			}
		}
		
		for(int i=0; i<n; i++)
			System.out.println(answer[i]);
		
//		for(int i=0; i<n; i++){
//			System.out.println();
//			for(int j=0; j<n; j++){
//				System.out.print(map1[i][j] + " ");
//			}
//		}
//		for(int i=0; i<n; i++){
//			System.out.println();
//			for(int j=0; j<n; j++){
//				System.out.print(map2[i][j] + " ");
//			}
//		}
	}
	
	private int[] change(int n, int num){
		int re[] = new int[n];
		Arrays.fill(re, 0);
		for(int i=n-1; i>=0; i--){
			re[i] = num %2;
			num /= 2;
		}
		return re;
	}

}
