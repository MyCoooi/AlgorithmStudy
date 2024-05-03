package W20240429;

import java.io.*;
import java.util.*;

public class Main_골드4_21940_가운데에서만나기 {
	
	static int N, M, K;
	static int [] livingCities;
	static Node adjList [];
	static ArrayList<Integer> answer;
	// 최단 시간 테이블
	static int minTime [][];
	
	static class Node {
		int to, time;
		Node next;
		public Node(int to, int time, Node next) {
			super();
			this.to = to;
			this.time = time;
			this.next = next;
		}
	}
	
	static class Node2 {
		int to, time;
		public Node2(int to, int time) {
			super();
			this.to = to;
			this.time = time;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]); // 도시의 개수
		M = Integer.parseInt(split[1]); // 도로의 개수
		
		adjList = new Node[N + 1]; // 0번 인덱스는 쓰지 않는다
		answer = new ArrayList<>();
		minTime = new int[N + 1][N + 1];
		// 최단 시간 테이블 모두 무한으로 초기화
		for (int i = 1; i <= N; i++) Arrays.fill(minTime[i], Integer.MAX_VALUE);
		
		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			
			int from = Integer.parseInt(split[0]);
			int to = Integer.parseInt(split[1]);
			int t = Integer.parseInt(split[2]);
			adjList[from] = new Node(to, t, adjList[from]);
		}
		
		int K = Integer.parseInt(in.readLine()); // 준형이와 친구들의 총 인원
		livingCities = new int[K];
		split = in.readLine().split(" ");
		for (int i = 0; i < K; i++) livingCities[i] = Integer.parseInt(split[i]);
		
		for (int i = 1; i <= N; i++) {			
			dijkstra(i);
		}
		
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node2> pq = new PriorityQueue<>();
		pq.offer(new Node2(start, 0));
		
		while(!pq.isEmpty()) {
			Node2 cur = pq.poll();
			
			
		}
	}

	static void printAdjList() {
		System.out.println("====adjList====");
		for (int i = 1; i <= N; i++) {
			Node cur = adjList[i];
			while(cur != null) {
				System.out.println(i + "->" + cur.to + ":" + cur.time);
				cur = cur.next;
			}
		}
	}
}
