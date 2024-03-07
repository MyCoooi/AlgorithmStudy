package W20240304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// fail
public class Main_실버2_15666_N과M12 {
	
	static int N, M;
	static boolean used [][];
	static int [] inputNumbers, numbers ;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		input();
		// 오름차순 정렬(사전 순으로 증가하는 순서로 출력하기 위해)
		Arrays.sort(inputNumbers);
		
		// 순열 찾기
		
		
		// 출력
		System.out.println(sb);
	}
	
	static void permutation(int depth, int prevN) {
		// 기저 조건
		
		
		// 유도부분
		
	}
	
	static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		inputNumbers = new int[N];
		numbers = new int[M];
		used = new boolean[M][10001];
		
		split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			inputNumbers[i] = Integer.parseInt(split[i]);
		}
	}

}
