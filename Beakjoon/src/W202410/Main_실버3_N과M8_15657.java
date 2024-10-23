package W202410;

import java.io.*;
import java.util.*;

public class Main_실버3_N과M8_15657 {
	
	static int N, M;
	static int nums [];
	static int ans [];
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		nums = new int[N];
		ans = new int[M];
		sb = new StringBuilder();
		
		split = in.readLine().split(" ");
		for (int n = 0; n < N; n++) {
			nums[n] = Integer.parseInt(split[n]);
		}
		
		Arrays.sort(nums);
		
		recursion(0);
		System.out.println(sb.toString());
	}
	
	static void recursion(int cnt) {
		if (cnt == M) {
			for (int m = 0; m < M; m++) {
				sb.append(ans[m]).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for (int n = 0; n < N; n++) {
			if (cnt > 0 && ans[cnt - 1] > nums[n]) {
				continue;
			}
			ans[cnt] = nums[n];
			recursion(cnt + 1);
		}
	}
}
