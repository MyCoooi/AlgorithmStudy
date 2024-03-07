package W20240304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_실버2_15666_N과M12 {
	
	static int N, M;
	static int [] inputNumbers, numbers ;
	static ArrayList<Integer> removeDuplicatesInputNumbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		input(); // 수 입력받기
		removeDuplicates(); // 입력받은 수 중 중복되는 수 제거
		// 오름차순 정렬(사전 순으로 증가하는 순서로 수열을 출력하기 위함)
		Collections.sort(removeDuplicatesInputNumbers);
		// 순열 찾기
		permutation(0, 0);
		// 출력
		System.out.println(sb);
	}
	
	static void permutation(int depth, int idx) {
		// 기저 조건
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		// 유도부분
		for (int i = idx; i < removeDuplicatesInputNumbers.size(); i++) {
			numbers[depth] = removeDuplicatesInputNumbers.get(i);
			permutation(depth+1, i);
		}
		
	}
	
	static void removeDuplicates() {
		for (int i = 0; i < N; i++) {
			boolean flag = true;
			for (int j = 0; j < removeDuplicatesInputNumbers.size(); j++) {
				if (inputNumbers[i] == removeDuplicatesInputNumbers.get(j)) {
					flag = false;
					break;
				}
			}
			if (flag) removeDuplicatesInputNumbers.add(inputNumbers[i]);
		}
	}
	
	static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		inputNumbers = new int[N];
		removeDuplicatesInputNumbers = new ArrayList<>();
		numbers = new int[M];
		
		split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			inputNumbers[i] = Integer.parseInt(split[i]);
		}
	}

}
