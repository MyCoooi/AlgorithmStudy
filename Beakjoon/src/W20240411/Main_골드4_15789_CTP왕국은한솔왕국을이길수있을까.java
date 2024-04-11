package W20240411;

import java.io.*;
import java.util.*;

// fail
// 동맹 맺을 기회를 모두 사용하지 않아도 되지만, 동맹을 많이 맺을수록 CTP왕국의 힘이 커진다
public class Main_골드4_15789_CTP왕국은한솔왕국을이길수있을까 {

	static int N, M, K, C, H, ans;
	static int [] parent;
	static HashMap<Integer, Integer> cnt = new HashMap<>();
	static PriorityQueue<Kingdom> kingdoms = new PriorityQueue<>();
	
	static class Kingdom implements Comparable<Kingdom>{
		int no, cnt;
		public Kingdom(int no, int cnt) {
			super();
			this.no = no;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Kingdom o) {
			return Integer.compare(o.cnt, this.cnt);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) parent[i] = i; // make set
		ans = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			union(X, Y);
		}
		st = new StringTokenizer(in.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		solve();
		System.out.println(ans);
	}

	private static void solve() {
		for (int i = 1; i <= N; i++) {
			if (parent[i] == parent[H]) continue; // 한솔 왕국과 동맹인 왕국과는 동맹을 맺을 수 없다
			
			if (!cnt.containsKey(parent[i])) cnt.put(parent[i], 1);
			else cnt.put(parent[i], cnt.get(parent[i]) + 1);
		}
		Iterator<Integer> keys = cnt.keySet().iterator();
		while(keys.hasNext()) {
			int key = keys.next();
			if (key == parent[C]) continue;
			kingdoms.offer(new Kingdom(key, cnt.get(key)));
		}
		
		int k = K;
		while(!kingdoms.isEmpty() && k > 0) {
			ans += kingdoms.poll().cnt;
			k--;
		}
		ans += cnt.get(parent[C]);
	}

	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if (px > py) {
			parent[px] = py;
		}
		else parent[py] = px;
	}

	private static int findSet(int x) {
		if (parent[x] == x)
			return parent[x];
		else
			return parent[x] = findSet(parent[x]);
	}
	
	static void printParent() {
		System.out.println("!!!parent");
		for (int i = 0; i <= N; i++) System.out.print(parent[i] + " ");
		System.out.println("\n==========");
	}
	
}
