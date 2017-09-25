package kakao_blind;

import java.util.Scanner;

public class Ka44 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		// Ƚ��
		int t = sc.nextInt();		// ����
		int m = sc.nextInt();		// �ο�
		String[] arr = new String[]{"23:59", "00:01"};
		int person[] = new int[arr.length];
		
		for(int i=0; i<arr.length; i++){
			person[i] = Integer.parseInt(arr[i].substring(0, 2))*60 + Integer.parseInt(arr[i].substring(3, 5));	// ������ �ٲ���
		}
		// sorting
		for(int i=0; i<arr.length-1; i++){
			for(int j=i+1; j<arr.length; j++){
				if(person[i] > person[j]){
					int temp = person[i];
					person[i] = person[j];
					person[j] = temp;
				}
			}
		}
		// bus table
		int busTime[] = new int[n];
		busTime[0] = 9*60;
		for(int i=1; i<n; i++){				// n==1 �ϋ� �ȵ���
			busTime[i] = busTime[i-1] + t;
		}
		
//		// test
//		for(int i=0; i<n; i++){				// n==1 �ϋ� �ȵ���
//			System.out.println(busTime[i]);
//		}
		int answer = 0;
		// start
		int index = 0;
		int count = 0;
		boolean isRemain = false;
		boolean isEnd = false;
		for(int i=0; i<n; i++){
			int time = busTime[i];
			count = 0;
			for(int j=index; j<arr.length; j++){
				if(i==n-1){		// ������ ��������
					if(m==1){
						if(person[j]<time ){
							answer = person[j]-1;
							isEnd = true;
						}
						else
							isEnd = false;
						break;
					}
					if(person[j] <= time){
						count++;		// ž��
						index = j+1;
					}else
						index = j+1;
					if(count == m-1){		// �� ������
						if(j == arr.length-1){
							index = arr.length;
							break;
						}else{
							// �̰��� ����� ������
							
							if(person[j] == person[j+1]){
								answer = person[j]-1;
								isEnd = true;
							}
							else{
								if(person[j]<time && time <person[j+1])
									isEnd = false;
								else{
									answer = person[j];
									isEnd = true;
								}
							}
							
						}
						
					}
				}else{
					if(person[j] <= time){
						count++;		// ž��
						index = j+1;
					}
					if(count == m){		// ���� Ÿ��
						count = 0;
						index = j+1;
						break;
					}
				}
			}
			if(index >= arr.length){
				//�̰��� ���� ������
				isRemain = true;
				break;
			}
		}
		if(!isEnd && (isRemain || answer == 0)){
			answer = busTime[n-1];
		}
		String re = "";
		if(answer/60 < 10){
			re += "0"+(answer/60) +":";
			if(answer%60 < 10){
				re+=  "0"+(answer%60 );
			}else{
				re+= (answer%60); 
			}
		}else{
			re += (answer/60)+":";
			if(answer%60 < 10){
				re+=  "0"+(answer%60 );
			}else{
				re+= (answer%60); 
			}
		}
		System.out.println(re);
		
		
	}
}
