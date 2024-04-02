package W20240401;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
 * 반례
 * (1+1)+(1*2)
 * ((1+1)*(2+5))/5
 * 
 * 사전순이 뭔데!!
 */
public class Main_골드5_2800_괄호제거2 {

	static String input;
	static StringBuilder sb = new StringBuilder();
	static boolean printCheck [];
	static ArrayList<Integer> openBrackets, closeBrackets;
	
	static class Node {
		char c;
		int idx;
		public Node(char c, int idx) {
			super();
			this.c = c;
			this.idx = idx;
		}
	}
	
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
		for (int m = 1; m < Math.pow(2, N); m++) {			
			// 1. 플래그 문자열 구하기(이진수 이용)
			String flagStr = String.format("%0" + N + "d", Integer.parseInt(Integer.toBinaryString(m)));
			
			// 2. 조합 찾기
			printCheck = new boolean[input.length()];
			for (int i = 0; i < flagStr.length(); i++) {
				if (flagStr.charAt(i) == '1') {
					printCheck[openBrackets.get(N - 1 - i)] = true;
					printCheck[closeBrackets.get(N - 1 - i)] = true;
				}
			}
			
			// 결과물 출력 하기
			print(printCheck);
		}
	}

	private static void print(boolean printCheck[]) {
		for (int i = 0; i < input.length(); i++) {
			if (!printCheck[i]) sb.append(input.charAt(i));
		}
		sb.append("\n");
	}

	private static void setting() {
		Stack<Node> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			
			if (cur == '(') stack.push(new Node(cur, i));
			else if (cur == ')') {
				Node top = stack.peek();
				if (top.c == '(') {
					openBrackets.add(top.idx);
					closeBrackets.add(i);
					stack.pop();
				}
				else {
					stack.push(new Node(cur, i));
				}
			}
		}
		
	}
}
