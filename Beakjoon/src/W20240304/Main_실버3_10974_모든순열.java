package W20240304;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_실버3_10974_모든순열 {

	static int N;
	static int numbers [];
	static boolean used [];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		input();
		permutation(0);
		System.out.println(sb);
	}
	
	static void permutation(int depth) {
		// 기저 조건
		if (depth == N) {
			for (int i = 0; i < N; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		// 유도 부분
		for (int i = 1; i <= N; i++) {
			if (used[i]) continue;
			
			numbers[depth] = i;
			used[i] = true;
			permutation(depth + 1);
			used[i] = false;
		}
	}
	
	static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		numbers = new int[N];
		used = new boolean[N + 1];
	}
}
