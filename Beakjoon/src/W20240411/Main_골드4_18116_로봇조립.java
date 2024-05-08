package W20240411;

import java.io.*;
import java.util.*;

public class Main_골드4_18116_로봇조립 {
	
	static int N;
	static int parent [] = new int[1000001];
	static int cnt [] = new int[1000001];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		// cnt 배열 초기화
		for (int i = 1; i <= 1000000; i++) cnt[i] = 1;

		makeSet();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			
			String cmd = st.nextToken();
			
			switch (cmd) {
			case "I":
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				unionSet(a, b);
				break;
			case "Q":
				int c = Integer.parseInt(st.nextToken());
				query(c);
				break;
			}
		}
		System.out.println(sb);
	}

	private static void query(int c) {
		int pc = findSet(c);
		sb.append(cnt[pc]).append("\n");
	}

	private static void makeSet() {
		for (int i = 1; i <= 1000000; i++) {
			parent[i] = i;
		}
	}

	private static void unionSet(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		
		if (pa == pb) return;
		
		if (pa > pb) {
			parent[pa] = pb;
			cnt[pb] += cnt[pa];
			cnt[pa] = 0;
		}
		else {
			parent[pb] = pa;
			cnt[pa] += cnt[pb];
			cnt[pb] = 0;
		}
	}

	private static int findSet(int a) {
		if (parent[a] == a) return a;
		
		parent[a] = findSet(parent[a]);
		return parent[a];
	}
}
