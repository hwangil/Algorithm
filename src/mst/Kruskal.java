package mst;

import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1197
// 이렇게 해보려했으나, 잘못된 생각이고 ! kruskal 찾아보자! 사이클 확인하는 법. 탐색해봐야되나
public class Kruskal {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for(int i=0; i<e; i++){
			pq.offer(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		//start
		int answer = 0;
		int count = 0;
		boolean isVisited[] = new boolean[v+1];
		while(!pq.isEmpty()){
			if(count == v-1)
				break;
			Edge edge = pq.poll();
			if(isVisited[edge.xNode] && isVisited[edge.yNode])		// 이 조건이 틀렷어 바보야
				continue;
			
			isVisited[edge.xNode] = true;
			isVisited[edge.yNode] = true;
			answer += edge.weight;
			count++;
		}
		System.out.println(answer);
		
	}
}
class Edge implements Comparable<Edge>{
	int xNode, yNode;
	int weight;
	public Edge(int xNode, int yNode, int weight){
		this.xNode = xNode;
		this.yNode = yNode;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return weight>o.weight?1:-1;
	}
}
