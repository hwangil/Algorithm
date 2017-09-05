package divide_conquer;

import java.util.Scanner;

// 왜 안되지 ..

public class FENCE {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int t=0; t<testCase; t++){
			//start
			int n = sc.nextInt();
			int fence[] = new int[n+1];
			for(int i=1; i<=n; i++){
				fence[i] = sc.nextInt();
			}
			System.out.println(new FENCE().merge(fence, 1, n));
		}
	}
	
	public int merge(int[]fence, int start, int end){
		if(start == end){
			// base case
			return fence[start]; // start == end
		}
		int mid = (start+end)/2;
		int maxWidth = Math.max(merge(fence, start, mid), merge(fence, mid+1, end));
		// 경계 포함하는 부분
		int left = mid;
		int right = mid+1;
		int minHeight = Math.min(fence[left], fence[right]);
		maxWidth = Math.max(maxWidth, minHeight*2);
	
		
		while(true){		// 
			if(start == left && right == end)
				break;
			if(right<end && (left == start || fence[left-1] <= fence[right+1])){
				right ++;
				minHeight = Math.min(minHeight, fence[right]);
			}else{
				left--;
				minHeight = Math.min(minHeight, fence[left]);
			}
			
			maxWidth = Math.max(maxWidth, minHeight*(right-start+1));
			
			
		}
		
		return maxWidth;
		
	}

}
