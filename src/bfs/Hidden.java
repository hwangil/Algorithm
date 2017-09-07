package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// bfs
// ** bfs�� ���� �� �� �湮 üũ�� 1)node�� Ž���� �� �ϴ���, 2)�ƴϸ� ���� node�� ������ �ϴ���
// ** �ܼ� Ž���� ��� �Ѵ� �����ϴ�. 1)�� ��� ��� Queue�� ���� node�� ��ġ�� �ȴ�. ���� ����ɶ� �湮���ο� ���� continue �� ��
// ** 2)�� ��� ���� �� �湮 üũ���� �ع����� ������ queue�� node�� ��ġ�� �ʴ´�. (�������� ���� ������ �̷���)
// ** 	�� ������ ��� node�� ���� �� depth�� ������ش�. (���� ��� +1) ***
// ** �� �� 1)�� ��츦 ����ϸ� �̹� ���� node�� depth�� �ǵ帱�� �ִ� (Queue�� �� �ִ� ������ node�� �湮ó���� ���� �ʱ� ������)
// ** bfs�� �ִܰŸ��� ���� �� ���� ���ȴ�. ���� depth�� ����ؾߵǴµ� �̷� ��� 2)�� ����� �� �����ϴٰ� �����Ѵ�.
// ** Queue�� ��ġ�� �� ��ü�� 2)�� ���� �׷��� �ʱ� ������ �� ����
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
				// if(isVisited[select]) // ** �̷��� �տ��� ���ָ� �ȵȴ�
				// continue;
				// isVisited[select] = true;
				if (select + 1 <= 2 * (k) && !isVisited[select + 1]) {
					answer[select + 1] = answer[select] + 1; // ** �̷��� node�� ����
																// �� depth��
																// ���ǹ���, �� ����
																// depth�� ���� ª��
																// ������ ���ŵǸ� �ȵ�.
																// �׷��� �湮�ߴٰ� üũ
					isVisited[select + 1] = true; // ���� �� �湮 ���ο� üũ�� �Ѵ�.
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
