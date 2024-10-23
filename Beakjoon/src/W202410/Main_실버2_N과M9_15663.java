package W202410;

import java.io.*;
import java.util.*;

public class Main_실버2_N과M9_15663 {

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
			int num = Integer.parseInt(split[n]);
			nums[n] = num;
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
		
		int prev = 0;
		for (int n = 0; n < N; n++) {
			if (prev == nums[n]) {
				continue;
			}
			if (isIn[n]) {
				continue;
			}
			ans[cnt] = nums[n];
			prev = nums[n];
			isIn[n] = true;
			recursion(cnt + 1);
			isIn[n] = false;
		}
	}
}
