package W202410;

import java.io.*;
import java.util.*;

public class Main_실버2_N과M10_15664 {
	
	static int N, M;
	static int ans [];
	static int nums [];
	static boolean isIn [];
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		ans = new int[M];
		nums = new int[N];
		isIn = new boolean[N];
		sb = new StringBuilder();
		
		split = in.readLine().split(" ");
		for (int n = 0; n < N; n++) {
			nums[n] = Integer.parseInt(split[n]);
		}
		
		Arrays.sort(nums);
		
		permutation(0);
		
		System.out.println(sb.toString());
	}
	
	static void permutation(int cnt) {
		if (cnt == M) {
			for (int m = 0; m < M; m++) {
				sb.append(ans[m]).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		int prev = 0;
		for (int n = 0; n < N; n++) {
			
			if (prev == nums[n] || isIn[n]) {
				continue;
			}
			
			if (cnt > 0 && ans[cnt - 1] > nums[n]) {
				continue;
			}
			
			ans[cnt] = nums[n];
			isIn[n] = true;
			prev = ans[cnt];
			permutation(cnt + 1);
			isIn[n] = false;
		}
	}
}
