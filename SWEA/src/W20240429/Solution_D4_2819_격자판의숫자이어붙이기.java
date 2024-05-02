package W20240429;

import java.io.*;
import java.util.*;

public class Solution_D4_2819_격자판의숫자이어붙이기 {
	
	static final int N = 4;
	
	static int answer;
	static int deltas [][] = {{-1,0},{1,0},{0,1},{0,-1}};
	static int [][] map;
	static HashMap<String, Boolean> hash;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			answer = 0;
			map = new int[N][N];
			hash = new HashMap<>();
			
			for (int i = 0; i < N; i++) {
				String split [] = in.readLine().split(" ");
 				for (int j = 0; j < N; j++) {				
 					map[i][j] = Integer.parseInt(split[j]);
				}
			}
			// -- 입력받기 끝 --
			
			for (int i = 0; i < N; i++) {
 				for (int j = 0; j < N; j++) {				
 					dfs(0, i, j, "");
				}
			}
			
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int cnt, int r, int c, String num) {
		// 기저
		if (cnt == 7) {
			// 중복 검사
			if (hash.get(num) != null) {
				return;
			}
			
			answer++;
			hash.put(num, true);
			return;
		}
		
		// 유도
		for (int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if (!isIn(nr, nc)) continue;
			
			dfs(cnt+1, nr, nc, num + map[nr][nc]);
		}
		
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
