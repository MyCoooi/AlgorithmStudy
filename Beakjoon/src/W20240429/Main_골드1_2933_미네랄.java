package W20240429;

import java.io.*;
import java.util.*;

public class Main_골드1_2933_미네랄 {
	
	static final char BLANK = '.';
	static final char MINERAL = 'x';
	
	static int R, C, N;
	static int [][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static char [][] map;
	static int [] heights;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		R = Integer.parseInt(split[0]); // 세로 크기
		C = Integer.parseInt(split[1]); // 가로 크기
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String input = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		N = Integer.parseInt(in.readLine()); // 막대를 던진 횟수
		
		heights = new int[N]; // 막대를 던진 높이
		split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			heights[i] = Integer.parseInt(split[i]);
		}
		
		// -- 입력 받기 끝
		
		printMap();
		
	}
	
	static void printMap() {
		System.out.println("=====map=====");
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
