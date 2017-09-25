package kakao_blind;

import java.util.Scanner;

public class Ka2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int answer;
		int length = s.length();
		int arr[] = new int[3];
		
		int count = -1;
		for(int i=0; i<length; i++){
			if(s.charAt(i) == 'S'){
			}else if(s.charAt(i) == 'D'){
				arr[count] = (int) Math.pow(arr[count], 2);
			}else if(s.charAt(i) == 'T'){
				arr[count] = (int) Math.pow(arr[count], 3);
			}else if(s.charAt(i) == '1' && s.charAt(i+1) == '0'){
				count++;
				arr[count] = 10;
				i++;
			}
			else if(s.charAt(i)-'0' >= 0 && s.charAt(i)-'0' <10){
				count++;
				arr[count] = s.charAt(i)-'0';
			}else if(s.charAt(i) == '*'){
				// x2
				if(count == 0)
					arr[count] *= 2;
				else{
					arr[count] *= 2;
					arr[count-1] *= 2;
				}
			}else if(s.charAt(i) == '#'){
				arr[count] *= -1;
			}
		}
		
		answer = arr[0]+arr[1]+arr[2];
		System.out.println(answer);

	}
}
