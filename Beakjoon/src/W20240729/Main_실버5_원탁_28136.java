package W20240729;

import java.util.*;
import java.io.*;

public class Main_실버5_원탁_28136 {
	
	static int N;
	static int nums [];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		nums = new int[N];
		String split [] = in.readLine().split(" ");
		for (int n = 0; n < N; n++) {
			nums[n] = Integer.parseInt(split[n]);
		}
		
		int ans = solve();
		System.out.println(ans);
	}
	
	public static int solve() {
		int ret = 0;

		for (int n = 0; n < N - 1; n++) {
			int cur = nums[n];
			int next = nums[n + 1];
			if (cur >= next) {
				ret++;
			}
		}
		
		if (nums[N - 1] >= nums[0]) {
			ret++;
		}
		
		return ret;
	}
}
