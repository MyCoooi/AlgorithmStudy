package W20240311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_실버1_22871_징검다리건너기large {

	static int N;
	static int aOfStones [];
	static long dp []; // dp[i]: i번째 돌까지 오는 모든 경우의 수 중 최소 K값
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		aOfStones = new int[N];
		dp = new long[N];
		
		String split [] = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			aOfStones[i] = Integer.parseInt(split[i]);
			dp[i] = Long.MAX_VALUE;
		}
		
		dp[0] = 0;
		for (long i = 1; i < N; i++) {
			for (long j = 0; j <= i - 1; j++) {
				long w = (i - j) * (1 + Math.abs(aOfStones[(int) i] - aOfStones[(int) j]));
				long k = Math.max(dp[(int) j], w);
				dp[(int) i] = Math.min(dp[(int) i], k);
			}
		}
		System.out.println(dp[N-1]);
	}
}
