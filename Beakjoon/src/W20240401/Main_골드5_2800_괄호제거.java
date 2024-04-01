package W20240401;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
		printCheck = new boolean[input.length()];
		
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
				for (int i = 0; i < N; i++) {
					if (flag[i] == 1) {
						printCheck[openBrackets.get(i)] = true;
						printCheck[closeBrackets.get(i)] = true;
					}
				}
				
				// 결과물 출력 하기
				print();
			} while(np(flag));
		}
	}

	private static boolean np(int[] flag) {
		// TODO Auto-generated method stub
		return false;
	}

	private static void print() {
		for (int i = 0; i < input.length(); i++) {
			if (!printCheck[i]) sb.append(input.charAt(i));
		}
		sb.append("\n");
	}

	private static void setting() {
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			switch(cur) {
			case '(':
				openBrackets.add(i);
				break;
			case ')':
				closeBrackets.add(i);
				break;
			}
		}
	}
}
