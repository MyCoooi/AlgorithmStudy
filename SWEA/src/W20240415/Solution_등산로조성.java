package W20240415;

import java.util.*;
import java.io.*;

// fail
public class Solution_등산로조성 {
	
	static int N, K, ans;
	static int map [][];
	static int deltas [][] = {{0,1}, {0, -1}, {1,0}, {-1,0}};

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String split [] = in.readLine().split(" ");
			N = Integer.parseInt(split[0]);
			K = Integer.parseInt(split[1]);
			
			map = new int[N][N];
			ans = 0;
			
			int maxH = -1;
			for (int i = 0; i < N; i++) {
				split = in.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(split[j]);
					maxH = Math.max(maxH, map[i][j]);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxH) {
						solve(i, j);
					}
				}
			}
			
			sb.append("#" + tc + " " + ans + "\n"); 
		}
		System.out.println(sb);
	}
	
	static void solve(int r, int c) {
		
	}
}
