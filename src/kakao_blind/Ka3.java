package kakao_blind;

import java.util.Scanner;

public class Ka3 {
	static int count[];
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		String arr[] = new String[n]; // 0 : string 1 : count
		count = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = "0";
			count[i] = -1;
		}
		int answer = 0;
		int max[] = new int[2];
		max[0] = 0;

		String[] cities = new String[] { "Jeju", "Jeju", "Jeju", "Jeju", "Jeju" };
		if (n != 0) {
			for (int i = 0; i < cities.length; i++) {
				int c = 0;
				for (c = 0; c < n; c++) {
					if (count[c] > max[0]) {
						max[0] = count[c];
						max[1] = c; // 1ÀÌ index
					}
					if (arr[c].toLowerCase().equals(cities[i].toLowerCase())) {
						// hit
						raiseCount();
						count[c] = 0;
						answer += 1;
						break;
					} else if (count[c] == -1) {
						// add
						arr[c] = cities[i];
						raiseCount();
						count[c] = 0;
						answer += 5;
						break;
					}
				}
				if (c == n) {
					arr[max[1]] = cities[i];
					raiseCount();
					count[max[1]] = 0;
					answer += 5;
				}
				max[0] = 0;
			}
		} else {
			answer = cities.length * 5;
		}
		System.out.println(answer);

	}

	static void raiseCount() {
		for (int i = 0; i < n; i++) {
			if (count[i] == -1)
				continue;
			count[i]++;
		}
	}

}
