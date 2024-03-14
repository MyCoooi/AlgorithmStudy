package W20240311;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// N은 2이상 5천만 이하
// A_i는 1이상 100만 이하
public class Main_실버1_22871_징검다리건너기large {
	
	static int N;
	static int aOfStones [];
	static int dp []; // dp[i]에는 i번째 돌까지 왔을 때 들었던 힘의 최솟값을 저장
	
	public static void main(String[] args) throws Exception {
		/* 입력 받기 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		aOfStones = new int[N];
		dp = new int[N];
		
		String split [] = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(split[i]);
			aOfStones[i] = a;
		}
		/* 입력 끝 */
		
		dp[0] = 0;
		for (int i = 1; i < N; i++) {
		
		}
		
	}
	
}
