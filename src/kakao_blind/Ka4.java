package kakao_blind;

import java.util.Scanner;

public class Ka4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		// Ƚ��
		int t = sc.nextInt();		// ����
		int m = sc.nextInt();		// �ο�
		String[] arr = new String[]{"23:59", "00:01"};
		
		int table[][] = new int[2][arr.length];
		for(int i=0; i<arr.length; i++){
			table[0][i] = Integer.parseInt(arr[i].substring(0, 2));
			table[1][i] = Integer.parseInt(arr[i].substring(3, 5));
		}
		// start
		// 09:00 ���� �����Ѵ�
		int time[][] = new int[2][n];
		time[0][0] = 9;
		time[1][0] = 0;
		for(int i=1; i<n; i++){
			// ���� �ð�ǥ ����
			time[1][i] = time[1][i-1] + t;
			time[0][i] = time[0][i-1] + time[1][i]/60;
			time[1][i] = time[1][i] % 60;
		}
		// table sorting �� �ϰ������
		for(int i=0; i<arr.length-1; i++){
			for(int j=i+1; j<arr.length; j++){
				// �ð�����
			}
		}
		
		for(int i=0; i<n; i++){
			//check
			
		}
		
	}
}
