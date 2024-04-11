package W20240411;

import java.io.*;
import java.util.*;

public class Main_골드5_1717_집합의표현 {

	static final int UNION = 0;
	static final int FINDSET = 1;
	
	static int N, M; // M: 입력으로 주어지는 연산의 개수
	static int parent [];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		parent = new int[N + 1];
		
		makeSet();
		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			int cmd = Integer.parseInt(split[0]);
			int a = Integer.parseInt(split[1]);
			int b = Integer.parseInt(split[2]);
			
			if (cmd == UNION) {
				union(a, b);
			}
			else if (cmd == FINDSET) {
				String ans = "NO";
				if (findSet(a) == findSet(b)) ans = "YES";
				sb.append(ans + "\n");
			}
		}
		System.out.println(sb);
	}

	private static int findSet(int a) {
		if (parent[a] == a)
			return parent[a];
		else
			return parent[a] = findSet(parent[a]);
	}

	private static void union(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		if (pa > pb) {
			parent[pa] = pb;
		}
		else parent[pb] = pa;
	}

	private static void makeSet() {
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static void printSet() {
		for (int i = 0; i <= N; i++) System.out.print(parent[i] + " ");
		System.out.println("\n============");
	}
}
