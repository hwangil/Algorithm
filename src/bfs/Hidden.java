package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// bfs
// ** bfs를 구현 할 때 방문 체크를 1)node를 탐색할 때 하느냐, 2)아니면 다음 node를 넣을때 하느냐
// ** 단순 탐색일 경우 둘다 가능하다. 1)의 경우 대신 Queue에 쌓인 node가 겹치게 된다. 단지 실행될때 방문여부에 따라 continue 될 뿐
// ** 2)의 경우 넣을 떄 방문 체크까지 해버리기 때문에 queue의 node가 겹치지 않는다. (아직까지 나의 생각은 이렇다)
// ** 	이 문제의 경우 node를 넣을 때 depth를 계산해준다. (이전 노드 +1) ***
// ** 이 때 1)의 경우를 사용하면 이미 계산된 node의 depth를 건드릴수 있다 (Queue에 들어가 있는 상태의 node는 방문처리가 되지 않기 때문에)
// ** bfs는 최단거리를 구할 때 많이 사용된다. 따라서 depth를 계산해야되는데 이럴 경우 2)의 방법이 더 적합하다고 생각한다.
// ** Queue에 겹치는 것 자체도 2)의 경우는 그렇지 않기 떄문에 더 적합
public class Hidden {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		boolean[] isVisited = new boolean[2 * (k + 1)];
		int[] answer = new int[2 * (k + 1)];
		Arrays.fill(answer, 0);
		Arrays.fill(isVisited, false);
		if (k <= n) {
			answer[k] = n - k;
		} else {
			while (!q.isEmpty()) {
				int select = q.poll();
				// if(isVisited[select]) // ** 이렇게 앞에다 해주면 안된다
				// continue;
				// isVisited[select] = true;
				if (select + 1 <= 2 * (k) && !isVisited[select + 1]) {
					answer[select + 1] = answer[select] + 1; // ** 이렇게 node를 넣을
																// 떄 depth가
																// 계산되버림, 이 계산된
																// depth는 가장 짧은
																// 것으로 갱신되면 안돼.
																// 그래서 방문했다고 체크
					isVisited[select + 1] = true; // 넣을 떄 방문 여부와 체크를 한다.
					if (select + 1 == k) {
						break;
					}
					q.offer(select + 1);
				}
				if (select - 1 >= 0 && !isVisited[select - 1]) {
					answer[select - 1] = answer[select] + 1;
					isVisited[select - 1] = true;
					if (select - 1 == k) {
						break;
					}
					q.offer(select - 1);
				}
				if (2 * select <= 2 * (k) && !isVisited[2 * select]) {
					answer[2 * select] = answer[select] + 1;
					isVisited[select * 2] = true;
					if (select * 2 == k) {
						break;
					}
					q.offer(2 * select);
				}
			}
		}
		System.out.println(answer[k]);
	}

}
