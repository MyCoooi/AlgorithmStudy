package W20240401;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

// 3% 반례: (1) -> 1
// 15% 반례: (((1)))
public class Main_골드5_2800_괄호제거 {

	static String input;
	static boolean printCheck []; // 입력받은 수식에서 제거할 괄호를 true 체크 한다
	// openBrackets[i]와 closeBrackets[i]는 짝이다
	static ArrayList<Integer> openBrackets, closeBrackets;
	static Set<String> set = new HashSet<>();
	
	static class Node implements Comparable<Node> { // 사전순으로 출력하기 위한 class
		String value;
		public Node(String value) {
			super();
			this.value = value;
		}
		@Override
		public int compareTo(Node o) {
			return value.compareTo(o.value);
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
		PriorityQueue<Node> answer = new PriorityQueue<>(); // 사전순으로 출력하기 위함
		Iterator<String> iterSet = set.iterator();
		while(iterSet.hasNext()) {
			answer.offer(new Node(iterSet.next()));
		}
		while(!answer.isEmpty()) {
			System.out.println(answer.poll().value);
		}
	}

	private static void solve() {
		int N = openBrackets.size();
		// 괄호쌍을 1 ~ (괄호쌍 개수)개 선택했을 때 나올 수 있는 모든 조합을 구한다(부분 집합 구하기)
		for (int m = 1; m < Math.pow(2, N); m++) {
			// 1. 플래그 문자열 구하기(이진수 이용) ex) 001, 010, 011, ... , 111
			String flagStr = String.format("%0" + N + "d", Integer.parseInt(Integer.toBinaryString(m)));
			
			// 2. 조합 찾기
			printCheck = new boolean[input.length()];
			for (int i = 0; i < flagStr.length(); i++) {
				if (flagStr.charAt(i) == '1') {
					printCheck[openBrackets.get(N - 1 - i)] = true;
					printCheck[closeBrackets.get(N - 1 - i)] = true;
				}
			}
			
			// 결과 출력물 저장 하기
			print(printCheck);
		}
	}

	private static void print(boolean printCheck[]) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (!printCheck[i]) sb.append(input.charAt(i));
		}
		set.add(sb.toString()); // 중복제거를 위함
	}

	private static void setting() {
		Stack<int []> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			
			if (cur == '(') {
				stack.push(new int[]{0, i});
			}
			else if (cur == ')') {
				if (stack.peek()[0] == 0) {
					openBrackets.add(stack.pop()[1]);
					closeBrackets.add(i);
				}
			}
		}
	}
}
