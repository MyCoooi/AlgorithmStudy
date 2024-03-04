package W20240304;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_실버2_19949_영재의시험 {
	static final int N = 10;
	
	static int answer [];
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		input();
		dfs(0, 0, 0, 0);
		System.out.println(cnt);
	}
	
	static void dfs(int pNumber, int curAns, int preAns, int score) {
		
		// 기저 조건
		if (pNumber == N) {
			if (score >= 5) cnt++;
			return;
		}
		
		// 유도 부분
		for (int a = 1; a <= 5; a++) {
			if (curAns == preAns && preAns == a) continue; // 3번 연속해서 같은 번호를 찍을 수 없다
			
			if (answer[pNumber] == a) {
				dfs(pNumber + 1, a, curAns, score + 1);
			}
			else dfs(pNumber + 1, a, curAns, score);
		}
		
	}
	
	static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		answer = new int[N];
		cnt = 0; 
		
		String split [] = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			answer[i] = Integer.parseInt(split[i]);
		}
	}
}
