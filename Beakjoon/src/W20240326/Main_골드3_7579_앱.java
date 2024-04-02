package W20240326;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_골드3_7579_앱 {
	
	static int N, M; // N: 현재 활성화되어 있는 앱의 개수, M: 추가로 필요한 메모리(바이트 단위)
	static int [] memory, value, dp;
	static int sum;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		memory = new int[N];
		value = new int[N];
		dp = new int[10001];
		sum = 0;
		
		split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			memory[i] = Integer.parseInt(split[i]);
		}
		
		split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			value[i] = Integer.parseInt(split[i]);
			sum += value[i];
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 10000; j > 0; j--) {
				if (j >= value[i]) dp[j] = Math.max(dp[j], dp[j - value[i]] + memory[i]);
			}
		}
		
		for (int i = 0; i <= sum; i++) {
			if (dp[i] >= M) {
				System.out.println(i);
				break;
			}
		}
		
		
	}
}
