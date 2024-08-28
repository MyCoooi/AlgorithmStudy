package W20240819;

import java.io.*;
import java.util.*;

public class Main_골드4_스도쿠_2580 {
	
	static int puzzle [][];
	static int N = 9;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		puzzle = new int[N][N];
		
		int blankIdx [] = new int[2];
		for (int i = 0; i < N; i++) {
			String split [] = in.readLine().split(" ");
			int cnt = 0;
			int sum = 0;
			for (int j = 0; j < N; j++) {
				puzzle[i][j] = Integer.parseInt(split[j]);
				sum += puzzle[j][j];
				if (puzzle[i][j] == 0) {
					cnt++;
					blankIdx[0] = i;
					blankIdx[1] = j;
				}
			}
			if (cnt == 1) {
				puzzle[blankIdx[0]][blankIdx[1]] = 45 - sum;
			}
		}
		
		
		
	}
}
