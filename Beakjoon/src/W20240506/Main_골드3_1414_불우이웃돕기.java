package W20240506;

import java.io.*;
import java.util.*;

// PRIM 알고리즘 이용
public class Main_골드3_1414_불우이웃돕기 {
	
	static int N, answer, cnt; // cnt: 처리한 정점 수
	static Node [] graph;
	static int [] minEdge;
	static boolean [] selected;
	
	static class Node implements Comparable<Node>{
		int to, len;
		Node next;
		
		public Node(int to, int len) {
			super();
			this.to = to;
			this.len = len;
		}

		public Node(int to, int len, Node next) {
			super();
			this.to = to;
			this.len = len;
			this.next = next;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.len, o.len);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine()); // 방의 갯수
		graph = new Node[N];
		minEdge = new int[N];
		selected = new boolean[N];
		answer = 0;
		cnt = 0;
		
		for (int i = 0 ; i < N; i++) {
			String input = in.readLine();
			
			for (int j = 0; j < N; j++) {
				int from = i;
				int to = j;
				char lenChar = input.charAt(j);
				int len = 0;
				if (lenChar == '0') continue;
				else if (lenChar >= 'a') {
					len = lenChar - 'a' + 1;
				}
				else if (lenChar >= 'A') {
					len = lenChar - 'A' + 27;
				}
					
				graph[from] = new Node(to, len, graph[from]);
				if (from != to) {					
					graph[to] = new Node(from, len, graph[to]);
				}
				answer += len;
			}
		}
		
		int cost = prim(0);
		if (cnt != N) System.out.println(-1);
		else System.out.println(answer - cost);
//		printGraph();
	}
	
	static int prim(int startNode) {
		int cost = 0; // 최소 스패닝 트리의 가중치
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
//		// 초기화
//		for (int i = 0; i < N; i++) {
//			minEdge[i] = Integer.MAX_VALUE;
//		}
//		minEdge[startNode] = 0; // 시작 정점의 최소 비용을 0으로 처리
		
		pq.offer(new Node(startNode, 0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();

			if (selected[cur.to]) continue; // 이미 트리에 속해있으면 건너뛰기
			
			selected[cur.to] = true; // 방문 처리(트리에 속함)
			cost += cur.len; // 가중치 더하기
			cnt++;
			
			for (Node n = graph[cur.to]; n != null; n = n.next) {
				if (!selected[n.to]) { // 비트리 정점이라면
					pq.offer(new Node(n.to, n.len));
				}
			}
		}
		return cost;
	}
	
	static void printGraph() {
		for (int i = 0; i < N; i++) {
			for (Node cur = graph[i]; cur != null; cur = cur.next) {
				System.out.print(cur.to + "/" + cur.len + " ");
			}
			System.out.println();
		}
	}
}
