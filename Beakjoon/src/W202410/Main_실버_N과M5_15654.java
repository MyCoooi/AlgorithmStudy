package W202410;

import java.util.*;
import java.io.*;

public class Main_실버_N과M5_15654 {
	
	static int N, M;
	static int nums [];
	static int ans [];
	static boolean isIn [];
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		nums = new int[N];
		ans = new int[M];
		isIn = new boolean[N];
		sb = new StringBuilder();
		
		split = in.readLine().split(" ");
		for (int n = 0; n < N; n++) {
			nums[n] = Integer.parseInt(split[n]);
		}
		
		Arrays.sort(nums);
		
		dfs(0);
		System.out.print(sb.toString());
	}
	
	static void dfs(int cnt) {
		if (cnt == M) {
			for (int m = 0; m < M; m++) {
				sb.append(ans[m]).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for (int n = 0; n < N; n++) {
			if (isIn[n]) {
				continue;
			}
			ans[cnt] = nums[n];
			isIn[n] = true;
			dfs(cnt + 1);
			isIn[n] = false;
		}
	}
}
