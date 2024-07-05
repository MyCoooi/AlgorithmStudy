package W20240628;

import java.util.*;
import java.io.*;

public class Main_골드5_17396_백도어 {

	static int N, M;
	static boolean [] canGo;
	static Node [] graph;
	static int answer;
	static int times [];
	
	static class Node implements Comparable<Node> {
		int to, time;
		Node next;
		public Node(int to, int time, Node next) {
			super();
			this.to = to;
			this.time = time;
			this.next = next;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.time, o.time);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		
		N = Integer.parseInt(split[0]); // 분기점 수
		M = Integer.parseInt(split[1]); // 분기점을 잇는 길의 수
		
		canGo = new boolean[N];
		graph = new Node[N];
		times = new int[N];
		answer = -1;
		
		split = in.readLine().split(" ");
		for (int i = 0; i < split.length; i++) {
			canGo[i] = (Integer.parseInt(split[0]) == 1) ? false : true;
		}
		// N - 1 번째 분기점(상대 넥서스)은 상대방의 시야에 보이지만 갈 수 있다.
		canGo[N - 1] = true;
		
		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			
			int a  = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			int t  = Integer.parseInt(split[2]);
			
			// 양방향 그래프
			graph[a] = new Node(b, t, graph[a]);
			graph[b] = new Node(a, t, graph[b]);
		}
		
		dijkstra(0);
		
		System.out.println(times[N-1]);
	}
	
	static void dijkstra(int startNode) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean [] visited = new boolean[N];
		
		visited[0] = true;
		pq.offer(new Node(startNode, 0, null));
		Arrays.fill(times, Integer.MAX_VALUE);
		times[0] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (visited[cur.to]) continue;			
			visited[cur.to] = true;
			
			for (Node iter = graph[cur.to]; iter != null; iter = iter.next) {
				if (!canGo[iter.to]) continue;
				if (!visited[iter.to] && times[iter.to] > times[cur.to] + times[iter.time] ) {
					times[iter.to] = times[cur.to]  + times[iter.time];
					pq.offer(new Node(iter.to, times[iter.to], null));
				}
			}
		}
	}
}
