package W20240326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_골드5_2668_숫자고르기 {
	
	static int N;
	static int nums [];
	static boolean visited[];
	static ArrayList<Integer> ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		nums = new int[N + 1]; // 0 인덱스는 사용하지 않는다
		visited = new boolean[N + 1];
		ans = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(in.readLine());
		}
		
		for (int i = 1; i <= N; i++) {
			dfs(i, i);
		}
		
		sb.append(ans.size() + "\n");
		Collections.sort(ans);
		
		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i) + "\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void dfs(int idx, int firstNum) {
		visited[idx] = true;
		
		// 기저 조건
		if (nums[idx] == firstNum) {
			ans.add(idx);
			visited[idx] = false;
			return;
		}
		
		// 유도 부분
		if (!visited[nums[idx]]) dfs(nums[idx], firstNum);
		visited[idx] = false;
	}
}
