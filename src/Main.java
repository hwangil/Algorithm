import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] v = new int[][]{{1, 1},{2, 2},{1, 2}};
		int []answer = {-1, -1};
		int []temp = {-1, -1};
		for(int i=0; i<3; i++){
			if(answer[0] != v[i][0] && temp[0] != v[i][0]){
				temp[0] = answer[0];
				answer[0] = v[i][0];
			}else if (answer[0] == v[i][0])
				answer[0] = temp[0];
				
			if(answer[1] != v[i][1] && temp[1] != v[i][1]){
				temp[1] = answer[1];
				answer[1] = v[i][1];
			}else if (answer[1] == v[i][1])
				answer[1] = temp[1];
		}
		System.out.println(answer[0] + ", " +answer[1]);
	}

}
