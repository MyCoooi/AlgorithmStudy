package W202410;

import java.util.*;
import java.io.*;

public class Main_실버3_이전순열_10973 {
	
	static int N;
	static int input [];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		
		input = new int[N];
		
		String split [] = in.readLine().split(" ");
		for (int n = 0; n < N; n++) {
			input[n] = Integer.parseInt(split[n]);
		}
		
		boolean pp = prevPermutation();
		if (!pp) {
			sb.append(-1);
		}
		else {
			for (int num : input) {
				sb.append(num).append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	private static boolean prevPermutation() {
		int t = N - 1;
		while (t > 0 && input[t - 1] < input[t]) {
			t--;
		}
		
		if (t == 0) {
			return false;
		}
		
		int w = t;
		while (w <= N - 1 && input[t - 1] > input[w]) {
			w++;
		}

		swap(t - 1, w - 1);
		
		// w번째 다음 숫자 부터 끝 숫자 까지 내림차순 정렬
		int right = N - 1;
		int left = t;
		while (left <= right) {
			swap(left, right);
			left++;
			right--;
		}
		
		return true;
	}
	
	private static void swap(int a, int b) {
		int tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}
	
}
