package W20240401;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_골드5_2800_괄호제거 {

	static String input;
	static StringBuilder sb = new StringBuilder();
	static boolean printCheck [];
	static ArrayList<Integer> openBrackets, closeBrackets;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		input = in.readLine();
		
		openBrackets = new ArrayList<>();
		closeBrackets = new ArrayList<>();
		
		setting();
		solve();
		
		// 결과 출력
		System.out.println(sb);
	}

	private static void solve() {
		int N = openBrackets.size();
		
		// 괄호쌍을 1 ~ (괄호쌍 개수)개 선택했을 때 나올 수 있는 모든 조합을 구한다(부분 집합 구하기)
		for (int m = 1; m <= N; m++) {			
			// 1. 플래그 배열 구하기
			int flag [] = new int[N];
			int k = 0;
			while(++k <= m) flag[N - k] = 1;
			
			// 2. 조합 찾기
			do {
				printCheck = new boolean[input.length()];
				for (int i = 0; i < N; i++) {
					if (flag[i] == 1) {
						printCheck[openBrackets.get(i)] = true;
						printCheck[closeBrackets.get(i)] = true;
					}
				}
				
				// 결과물 출력 하기
				print(printCheck);
			} while(np(flag));
		}
	}

	private static boolean np(int[] flag) {
		int N = flag.length - 1;
		
		// 꼭대기 위치 찾기
		int i = N;
		while(i > 0 && flag[i - 1] >= flag[i]) i--;
		if (i == 0) return false;
		
		// 바꿀 값 위치 찾기
		int j = N;
		while(flag[i - 1] >= flag[j]) j--;
		
		// 바꾸기
		swap(i - 1, j, flag);
		
		// i부터 끝까지 오름차순 정렬
		int k = N;
		while(i < k) swap(i++, k--, flag);
		
		return true;
	}

	private static void swap(int i, int j, int arr []) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	private static void print(boolean printCheck[]) {
		for (int i = 0; i < input.length(); i++) {
			if (!printCheck[i]) sb.append(input.charAt(i));
		}
		sb.append("\n");
	}

	private static void setting() {
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			switch(cur) {
			case '(':
				openBrackets.add(i);
				break;
			case ')':
				dq.offerFirst(i);
				break;
			}
		}
		while(!dq.isEmpty()) {
			int cur = dq.pollFirst();
			closeBrackets.add(cur);
		}
	}
}
