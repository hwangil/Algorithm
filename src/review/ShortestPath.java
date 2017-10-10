package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1753

public class ShortestPath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int start = sc.nextInt();
		
		HashMap<Integer, ArrayList<Node>> map = new HashMap<>();
		for(int i=1; i<=V; i++)
			map.put(i, new ArrayList<>());
		for(int i=0; i<E; i++){
			map.get(sc.nextInt()).add(new Node(sc.nextInt(), sc.nextInt()));
		}
		//start
		int answer[] = new int[V+1];
		boolean isVisited[] = new boolean[V+1];
		Arrays.fill(answer, Integer.MAX_VALUE);
		answer[start] = 0;
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start, 0));
		while(!q.isEmpty()){
			Node select = q.poll();
			if(isVisited[select.node])
				continue;
			isVisited[select.node] = true;
			for(int i=0; i<map.get(select.node).size(); i++){
				int node = map.get(select.node).get(i).node;
				int edge = map.get(select.node).get(i).edge;
				
				if(!isVisited[node]){
					answer[node] = Math.min(answer[select.node]+edge, answer[node]);
					q.offer(new Node(node, answer[node]));			//** 출발 ~ node 까지의 비용
				}
			}
			
		}
		for(int i=1; i<=V; i++){
			if(answer[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(answer[i]);
		}

	}

}
class Node implements Comparable<Node>{
	int node;
	int edge;
	public Node(int node, int edge){
		this.node = node;
		this.edge = edge;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return edge>o.edge?1:-1;
	}
}
