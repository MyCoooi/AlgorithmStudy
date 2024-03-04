package W20240304;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_실버2_19949_영재의시험 {
	static final int N = 10;
	
	static int answer [];
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		input();
		for (int i = 1; i <= 5; i++) dfs(0, i);
	}
	
	static void dfs(int pNumber, int ans) {
		
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
