package hanoi;

import java.util.Scanner;

public class Hanoi {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println((int)Math.pow(2, n)-1);
		new Hanoi().hanoi(1, 2, 3, n);
		
	}
	private void hanoi(int start, int mid, int end, int n){
		if(n==1){
			System.out.println(start + " " + end);
			return;
		}
		hanoi(start, end, mid, n-1);
		hanoi(start, mid, end, 1);
		hanoi(mid, start, end, n-1);
	}
}
