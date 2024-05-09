package W20240506;

import java.io.*;
import java.util.*;

// PRIM 알고리즘 이용
public class Main_골드3_1414_불우이웃돕기 {
	
	static int N, answer;
	static Node [] graph;
	static int [] dist;
	static boolean [] selected;
	
	static class Node {
		int to, len;
		Node next;
		public Node(int to, int len, Node next) {
			super();
			this.to = to;
			this.len = len;
			this.next = next;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine()); // 방의 갯수
		graph = new Node[N];
		dist = new int[N];
		selected = new boolean[N];
		answer = 0;
		
		for (int i = 0 ; i < N; i++) {
			String input = in.readLine();
			
			for (int j = 0; j < N; j++) {
				int from = i;
				int to = j;
				char lenChar = input.charAt(j);
				int len = 0;
				if (lenChar == '0');
				else if (lenChar >= 'a') {
					len = lenChar - 'a' + 1;
				}
				else if (lenChar >= 'A') {
					len = lenChar - 'A' + 27;
				}
					
				graph[from] = new Node(to, len, graph[from]);
				graph[to] = new Node(from, len, graph[to]);
			}
		}
		
		prim(0);
	}
	
	static void prim(int startNode) {
		int cnt = 0; // 처리한 정점 수 
		// 초기화
		for (int i = 0; i < N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[startNode] = 0; // 시작 정점의 최소 비용을 0으로 처리
		while(true) {
			
		}
	}
	
	static void printGraph() {
		for (int i = 0; i < N; i++) {
			for (Node cur = graph[i]; cur != null; cur = cur.next) {
				System.out.print(cur.len + "/" + cur.to + " ");
			}
			System.out.println();
		}
	}
}
