package dfs;

import java.util.Arrays;
import java.util.Scanner;

// dfs
// https://www.acmicpc.net/problem/6603
// == combintaion
public class Lotto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)
				break;
			int arr[] = new int[n+1];
			for(int i=1; i<=n; i++){
				arr[i] = sc.nextInt();
			}
			for(int i=1; i<arr.length; i++){
				new Lotto().dfs(arr, i, 1, new boolean[n+1]);
			}
			System.out.println();
		}

	}
	
	private void dfs(int[]arr, int start, int count, boolean isVisited[]){
		isVisited[start] = true;
		if(count == 6){
			for(int i=1; i<arr.length; i++){
				if(isVisited[i])
					System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}else if(arr.length-start-1 < 6-count){
			return;
		}
		
		for(int i=start+1; i<arr.length; i++){
			dfs(arr, i, count+1, copyArr(isVisited));
		}
		
	}
	
	private static boolean[] copyArr(boolean[] arr){
		boolean[] ret = new boolean[arr.length];
		for(int i=0; i<arr.length; i++)
			ret[i] = arr[i];
		return ret;
	}
	

}
