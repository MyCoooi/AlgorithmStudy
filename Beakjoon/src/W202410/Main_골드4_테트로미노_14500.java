package W202410;

import java.io.*;
import java.util.*;

public class Main_골드4_테트로미노_14500 {

	static int N, M;
	static int paper [][];
	static int deltas [][] = {{-1,0},{1,0},{0,-1},{0,1}};
	// ㅓ -> ㅏ -> ㅗ -> ㅜ
	static int deltas1 [][][] = {
			{{0,0},{1,0},{-1,0},{0,-1}},
			{{0,0},{1,0},{-1,0},{0,1}},
			{{0,0},{-1,0},{0,-1},{0,1}},
			{{0,0},{1,0},{0,-1},{0,1}}
			};
	static boolean isVisited [][];
	Queue<Node> q = new ArrayDeque<>();
	
	static class Node implements Comparable<Node> {
		int r, c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(paper[r][c], paper[o.r][o.c]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]); // 세로 크기
		M = Integer.parseInt(split[1]); // 가로 크기
		
		paper = new int[N][M];
		isVisited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		int ans = -1;
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ans = Math.max(ans, dfs(i, j, 0));
				ans = Math.max(ans, calculate(i, j));
			}
		}
		
		System.out.println(ans);
	}
	
	public static int dfs(int r, int c, int cnt) {
		if (cnt == 3) {
			return paper[r][c];
		}
		
		int max = -1;
		isVisited[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if (!isIn(nr, nc) || isVisited[nr][nc]) continue;
			
			max = Math.max(max, dfs(nr, nc, cnt + 1) + paper[r][c]);
		}
		
		isVisited[r][c] = false;
		return max;
 	}
	
	public static int calculate(int r, int c) {
		int max = 0;
		for (int i = 0; i < 4; i++) {
			int sum = 0;
			boolean check = false;
			for (int d = 0; d < 4; d++) {
				int nr = r + deltas1[i][d][0];
				int nc = c + deltas1[i][d][1];
				
				if (!isIn(nr, nc)) {
					check = true;
					break;
				}
				
				sum += paper[nr][nc];
			}
			
			if (!check) {
				max = Math.max(max, sum);
			}
		}
		return max;
	}
	
	public static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
