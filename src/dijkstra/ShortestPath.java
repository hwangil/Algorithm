package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

// dijkstra
// https://www.acmicpc.net/problem/1753

public class ShortestPath {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		HashMap<Integer, ArrayList<Node>> map = new HashMap<>();
		for (int i = 1; i <= v; i++)
			map.put(i, new ArrayList<>());

		int start = sc.nextInt();
		for (int i = 0; i < e; i++) {
			map.get(sc.nextInt()).add(new Node(sc.nextInt(), sc.nextInt()));
		}

		int answer[] = new int[v + 1];
		boolean isVisited[] = new boolean[v + 1];
		Arrays.fill(answer, Integer.MAX_VALUE);
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start, 0));
		answer[start] = 0;

		while (!q.isEmpty()) {
			Node selectNode = q.poll();
			int select = selectNode.node;
			if (isVisited[select])
				continue;
			isVisited[select] = true;

			for (int i = 0; i < map.get(select).size(); i++) {
				int node = map.get(select).get(i).node;
				int weight = map.get(select).get(i).weight;
				if (!isVisited[node]) {
					answer[node] = Math.min(answer[node], answer[select] + weight);
					q.offer(new Node(node, answer[node]));			// answer[node] *** 
				}
			}
		}

		for (int i = 1; i <= v; i++) {
			if (answer[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(answer[i]);

		}
	}

}

class Node implements Comparable<Node>{
	int node;
	int weight;

	public Node(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return weight > o.weight ? 1 : -1;
	}

	
}
