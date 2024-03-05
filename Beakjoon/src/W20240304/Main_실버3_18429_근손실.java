package W20240304;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_실버3_18429_근손실 {
	static final int WEIGHT = 500;

	static int N, K; // N: 운동 키트 개수, K: 매일 감소하는 중량의 크기
	static int [] weightes;
	static int cnt;
	static boolean used [];
	
	public static void main(String[] args) throws Exception {
		input();
		dfs(0, WEIGHT);
		System.out.println(cnt);
	}
	
	static void dfs(int order, int weight) {
		
		// 기저 조건
		if (weight < 500) return;
		
		if (order == N) {
			cnt++;
			return;
		}
		
		// 유도 부분
		for (int i = 0; i < N; i++) {
			if (!used[i]) {
				used[i] = true;
				dfs(order + 1, weight + weightes[i] - K);
				used[i] = false;
			}
		}
		
	}
	
	static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		K = Integer.parseInt(split[1]);
		
		weightes = new int[N];
		cnt = 0;
		used = new boolean[N];
		
		split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) weightes[i] = Integer.parseInt(split[i]);
	}
}
