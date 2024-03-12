package W20240304;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_골드4_2661_좋은수열 {

	static int N, ans;
	static boolean isDone;
	static int [] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		nums = new int[N];
		isDone = false;
		
		dfs(0);
	}
	
	static void dfs(int depth) {
		
		if (isDone) return;
		
		// 기저 조건
		if (depth == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(nums[i]);
			}
			isDone = true;
			return;
		}
				
		// 유도 부분
		for (int i = 1; i <= 3; i++) {
			if(depth > 0 && nums[depth - 1] == i) continue;
			
			nums[depth] = i;
			
			if (depth < 3) {
				dfs(depth + 1);
				continue;
			}
			
			boolean allCheck = true;
			for (int j = depth - 1; j > depth / 2; j--) {
				int size = depth - j + 1;
				int m = j - size;
				boolean check = false;
				for (int k = j; k <= depth; k++) {
					if (nums[m] != nums[k]) {
						check = true;
						break;        
					}
					m++;
				}
				if (!check) {
					allCheck = false;
					break;
				}
			}
			if (allCheck) dfs(depth+1);
		}
	}
}
