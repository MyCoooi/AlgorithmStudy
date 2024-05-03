package W20240429;

import java.io.*;
import java.util.*;

public class Main_골드3_1520_내리막길 {
	
	static int M, N;
	// cnt[i][j]: 상하좌우로부터 i, j로 올 수 있는 경우의 수
	static int [][] map, deltas, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		M = Integer.parseInt(split[0]); // 지도의 세로 크기
		N = Integer.parseInt(split[1]); // 지도의 가로 크기
		cnt = new int[M][N];
		for (int i = 0; i < M; i++) Arrays.fill(cnt[i], -1);
		cnt[0][0] = 1; // 시작 지점은 1로 해두고 시작한다
		map = new int [M][N];
		deltas = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
		
		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(split[j]);
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				solve(i, j);
			}
		}
		System.out.println(cnt[M-1][N-1]);
	}
	
	static int solve(int r, int c) {
		// 기저 조건
		if (cnt[r][c] != -1) return cnt[r][c];
		
		// 유도 부분
		int count = 0;
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if (!isIn(nr, nc) || map[r][c] >= map[nr][nc]) continue;
			
			count += solve(nr, nc);
		}
		
		cnt[r][c] = count;
		return cnt[r][c];
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < M && c < N;
	}
	
	static void printCnt() {
		System.out.println("=====cnt====");
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(cnt[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
