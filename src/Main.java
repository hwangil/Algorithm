import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// bfs dfs
// https://www.acmicpc.net/problem/1260
public class Main {

	private static HashMap<Integer, ArrayList<Integer>> map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		map = new HashMap<>();
		for(int i=1; i<=n; i++){
			map.put(i, new ArrayList<>());
		}
		for(int i=0; i<m; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			map.get(x).add(y);
			map.get(y).add(x);
		}
		
		boolean isVisited[] = new boolean[n+1];
		// dfs
		Arrays.fill(isVisited, false);
		Stack<Integer> s = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();
		s.push(start);
		while(!s.isEmpty()){
			int select = s.pop();
			if(isVisited[select])
				continue;
			isVisited[select] = true;
			System.out.print(select + " ");
			for(int i=0; i<map.get(select).size(); i++){
				if(!isVisited[map.get(select).get(i)])
					list.add(map.get(select).get(i));
			}
			list.sort(null);
			for(int i=list.size()-1; i>=0; i--){
				s.push(list.get(i));
			}
			list.clear();
		}
		
		// bfs
		System.out.println();
		Arrays.fill(isVisited, false);
		Queue<Integer> q = new LinkedList<>();
		list.clear();
		q.offer(start);
		while(!q.isEmpty()){
			int select = q.poll();
			if(isVisited[select])
				continue;
			isVisited[select] = true;
			System.out.print(select + " ");
			for(int i=0; i<map.get(select).size(); i++){
				if(!isVisited[map.get(select).get(i)])
					list.add(map.get(select).get(i));
			}
			list.sort(null);
			for(int i=0; i<list.size(); i++)
				q.offer(list.get(i));
			list.clear();
		}
			
	}
	

}
