package hanoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2270

public class Hanoi2 {
	private static int arr[];
	private static int count = 0;
	private static int pow[];
	private static final int MOD = 1000000;
	private static final int MAX = 1000001;
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()); int b= Integer.parseInt(st.nextToken()); int c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<a; i++)
			arr[Integer.parseInt(st.nextToken())] = 1;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<b; i++)
			arr[Integer.parseInt(st.nextToken())] = 2;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<c; i++)
			arr[Integer.parseInt(st.nextToken())] = 3;
		
		//start
		pow = new int[MAX];
		pow[0] = 1;
		for(int i=1; i<MAX; i++)
			pow[i] = (pow[i-1]<<1)%MOD;
		
		
		System.out.println(arr[n]);
		new Hanoi2().hanoi(n-1, arr[n]);
		System.out.println(count);
	}
	private void hanoi(int n, int dest){
		int src = arr[n];
		int mid = 1 + 2+ 3 - src - dest;
		
		if(n==0)
			return;
		if(src != dest){
			hanoi(n-1, mid);
			count = (count+pow[n-1])%MOD;
		}else{
			hanoi(n-1, dest);
		}
		
	}
}
