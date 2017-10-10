package mst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1197

public class Prim {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		HashMap<Integer, ArrayList<Node>> map = new HashMap<>();
		for(int i=1; i<=v; i++)
			map.put(i, new ArrayList<>());
		for(int i=0; i<e; i++){
			int s = sc.nextInt();
			int d = sc.nextInt();
			int w = sc.nextInt();
			map.get(s).add(new Node(d, w));
			map.get(d).add(new Node(s, w));
			
		}
		//start
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		boolean isVisited[] = new boolean[v+1];
		int answer = 0;
		while(!pq.isEmpty()){
			Node select = pq.poll();
			if(isVisited[select.node])
				continue;
			isVisited[select.node] = true;
			answer += select.weight;
			for(int i=0; i<map.get(select.node).size(); i++){
				int node = map.get(select.node).get(i).node;
				int weight = map.get(select.node).get(i).weight;
				if(!isVisited[node]){
					pq.offer(new Node(node, weight));
				}
			}
		}
		System.out.println(answer);
	}
}
class Node implements Comparable<Node>{
	int node;
	int weight;
	public Node(int node, int weight){
		this.node = node;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return weight>o.weight?1:-1;
	}
}
