package kakao_blind;

import java.util.Scanner;

public class Ka4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		// 횟수
		int t = sc.nextInt();		// 간격
		int m = sc.nextInt();		// 인원
		String[] arr = new String[]{"23:59", "00:01"};
		
		int table[][] = new int[2][arr.length];
		for(int i=0; i<arr.length; i++){
			table[0][i] = Integer.parseInt(arr[i].substring(0, 2));
			table[1][i] = Integer.parseInt(arr[i].substring(3, 5));
		}
		// start
		// 09:00 부터 시작한다
		int time[][] = new int[2][n];
		time[0][0] = 9;
		time[1][0] = 0;
		for(int i=1; i<n; i++){
			// 버스 시간표 세팅
			time[1][i] = time[1][i-1] + t;
			time[0][i] = time[0][i-1] + time[1][i]/60;
			time[1][i] = time[1][i] % 60;
		}
		// table sorting 을 하고싶은데
		for(int i=0; i<arr.length-1; i++){
			for(int j=i+1; j<arr.length; j++){
				// 시간먼저
			}
		}
		
		for(int i=0; i<n; i++){
			//check
			
		}
		
	}
}
