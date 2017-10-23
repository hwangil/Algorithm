package dynmaic;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11052
	
public class Fish {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		for(int i=1; i<=n; i++){
			arr[i] = sc.nextInt();
		}
		arr[0] = 0;
		for(int i=1; i<=n; i++){
			for(int j=1; j<=i; j++){
				arr[i] = Math.max(arr[i-j]+arr[j], arr[i]);
			}
		}
		System.out.println(arr[n]);
		
	}
}
