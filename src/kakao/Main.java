package kakao;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int []arr = new int[27];
		Arrays.fill(arr, 0);
		String s = sc.nextLine();
		for(int i=0; i<s.length(); i++){
			// 2개를 앞서서 -> 2개 앞서서 #이면
			// 다음이 (이면
			if(i == s.length()-1){
				arr[s.charAt(i)-'0']++;
				continue;
			}else if(i==s.length()-2){
				arr[s.charAt(i)-'0']++;
				arr[s.charAt(i+1)-'0']++;
				break;
			}
			
			if(i+2 < s.length() && s.charAt(i+2)== '#'){
				if(i != s.length()-3 && s.charAt(i+1+2) == '('){
					int k = i+1+2+1;
					for(k = i+1+2+1; k<s.length(); k++){
						if(s.charAt(k) == ')'){
							break;
						}
					}
					arr[Integer.parseInt(s.substring(i, i+2))] += Integer.parseInt(s.substring(i+1+2+1, k));
					i = k;		// i++로 다음으로 간다
				}else{
					arr[Integer.parseInt(s.substring(i, i+2))]++;
					i = i+2;		// i++로 다음으로 간다
				}
				
			}else{
				if(i+1<s.length() && s.charAt(i+1) == '('){
					int k = i+2;
					for(k = i+2; k<s.length(); k++){
						if(s.charAt(k) == ')'){
							break;
						}
					}
					arr[Integer.parseInt(s.substring(i, i+1))] += Integer.parseInt(s.substring(i+1+1, k));
					i = k;	// i++로 다음으로 간다
				}else{
					arr[s.charAt(i)-'0']++;
				}
			}
		}
		for(int i=1; i<27; i++)
			System.out.print(arr[i] + " ");
		
	}
}
