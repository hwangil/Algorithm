package kakao_blind;

import java.util.Scanner;

public class Ka5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine().toUpperCase();
		String s2 = sc.nextLine().toUpperCase();
		String[] arr1 = new String[s1.length()-1];
		String[] arr2 = new String[s2.length()-1];
		
		for(int i=0; i<s1.length()-1; i++){
			if(s1.charAt(i)-'A'>=0 && s1.charAt(i)-'A'<26 
					&& s1.charAt(i+1)-'A'>=0 && s1.charAt(i+1)-'A'<26 
					|| s1.charAt(i)-'a'>=0 && s1.charAt(i)-'a'<26
					&& s1.charAt(i+1)-'a'>=0 && s1.charAt(i+1)-'a'<26)
				arr1[i] = s1.substring(i, i+2).toUpperCase();
			else
				arr1[i] = "null";
		}
		for(int i=0; i<s2.length()-1; i++){
			if(s2.charAt(i)-'A'>=0 && s2.charAt(i)-'A'<26 
					&& s2.charAt(i+1)-'A'>=0 && s2.charAt(i+1)-'A'<26 
					|| s2.charAt(i)-'a'>=0 && s2.charAt(i)-'a'<26
					&& s2.charAt(i+1)-'a'>=0 && s2.charAt(i+1)-'a'<26)
				arr2[i] = s2.substring(i, i+2).toUpperCase();
			else
				arr2[i] = "null";
		}
		
		for(int i=0; i<arr1.length; i++){
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for(int i=0; i<arr2.length; i++){
			System.out.print(arr2[i] + " ");
		}
		/// jaka
		//and
		int andCount = 0;
		int orCount = 0;
		for(int i=0; i<arr1.length; i++){
			if(arr1[i].equals("null"))
				continue;
			orCount++;
			for(int j=0; j<arr2.length; j++){
				if(arr2[j].equals("null"))
					continue;
				if(arr1[i].equals(arr2[j])){
					andCount++;
					arr2[j] = "null";
					break;
				}
			}
		}
		for(int i=0; i<arr2.length; i++){
			if(arr2[i].equals("null"))
				continue;
			orCount++;
		}
		System.out.println();
		for(int i=0; i<arr1.length; i++){
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for(int i=0; i<arr2.length; i++){
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		System.out.println(andCount);
		System.out.println(orCount);
		if(orCount==0)
			System.out.println(65536);
		else
			System.out.println((int)(((double)andCount/orCount)*65536));
		
		
		

	}
}
