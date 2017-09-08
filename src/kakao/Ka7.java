package kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// bfs
public class Ka7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] strs = new String[n];
		for(int i=0; i<n; i++)
			strs[i] = sc.nextLine();
		String t = sc.nextLine();
		
		//start
		// bfs
		Queue<Integer> q = new LinkedList<>();
		int[] answer = new int[t.length()+1];
		Arrays.fill(answer, 0);
		q.offer(0);
		
		while(!q.isEmpty()){
			int select = q.poll();
			for(int i=0; i<n; i++){
				int index = strs[i].length();
				if((select+index)>t.length())
					continue;
				if(strs[i].equals(t.substring(select, select+index)) 
						&& answer[select+index] == 0){
					q.offer(select+index);
					answer[select+index] = answer[select]+1;
					if((select+index) == t.length()){
						
						q.clear();
					}
				}
			}
			
		}
		if(answer[t.length()] == 0)
			System.out.println(-1);
		else
			System.out.println(answer[t.length()]);

	}
	

}
