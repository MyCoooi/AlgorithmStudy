package W202410;

import java.util.*;
import java.io.*;

public class Main_골드5_자두나무_2240 {
	
	static int T, W;
	static int dp [][];
	static int jadu [];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		T = Integer.parseInt(split[0]);
		W = Integer.parseInt(split[1]);
		
		dp = new int[T + 1][W + 1];
		jadu = new int[T + 1];
		
		for (int t = 1; t <= T; t++) {
			int treeNum = Integer.parseInt(in.readLine());
			jadu[t] = treeNum;
		}

		for (int t = 1; t <= T; t++) {
			
			// 1번 나무에서 한 번도 움직이지 않는 경우
			// 1번 나무에서 자두가 떨어지는 경우
			if (jadu[t] == 1) {
				dp[t][0] = dp[t - 1][0] + 1;
			}
			
			// 2번 나무에서 자두가 떨어지는 경우
			if (jadu[t] == 2) {
				dp[t][0] = dp[t - 1][0];
			}
			
			// 1번 이상 움직이는 경우에 대해 탐색
			for (int w = 1; w <= W; w++) {
				// t초에 자두를 받아먹을 수 있다면
				if (jadu[t] == (w % 2) + 1) {					
					dp[t][w] = Math.max(dp[t - 1][w - 1], dp[t - 1][w]) + 1;
				}
				// t초에 자두를 받아먹을 수 없다면
				else {
					dp[t][w] = Math.max(dp[t - 1][w - 1], dp[t - 1][w]);
				}
			}
		}
		
		int max = 0;
		for (int w = 0; w <= W; w++) {
			max = Math.max(dp[T][w], max);
		}
		System.out.println(max);
	}
}