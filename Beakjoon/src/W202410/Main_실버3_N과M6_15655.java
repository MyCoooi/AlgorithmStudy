package W202410;

import java.io.*;
import java.util.*;

public class Main_실버3_N과M6_15655 {
	
	static int N, M;
	static StringBuilder sb;
	static int ans [];
	static int nums [];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		sb = new StringBuilder();
		ans = new int[M];
		nums = new int[N];
		
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
			if (cnt > 0 && ans[cnt - 1] >= nums[n]) {
				continue;
			}
			ans[cnt] = nums[n];
			dfs(cnt + 1);
		}
	}
}
