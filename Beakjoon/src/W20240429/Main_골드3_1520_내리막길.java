package W20240429;

import java.io.*;
import java.util.*;

public class Main_골드3_1520_내리막길 {
	
	static int M, N, answer;
	// cnt[i][j]: 상하좌우로부터 i, j로 올 수 있는 경우의 수
	static int [][] map, deltas, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		M = Integer.parseInt(split[0]); // 지도의 세로 크기
		N = Integer.parseInt(split[1]); // 지도의 가로 크기
		cnt = new int[M][N];
		map = new int [M][N];
		deltas = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
		answer = 0;
		
		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(split[j]);
		}
		
		solve(0, 0);
		
		System.out.println(answer);
	}
	
	static void solve(int r, int c) {
		cnt[r][c] = 1; // 시작 지점은 1로 해두고 시작한다
		
	}
}
