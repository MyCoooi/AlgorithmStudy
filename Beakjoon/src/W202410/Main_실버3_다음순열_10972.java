package W202410;

import java.io.*;
import java.util.*;

public class Main_실버3_다음순열_10972 {
	
	static int N;
	static int nextNums [];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		
		nextNums = new int[N];
		String split [] = in.readLine().split(" ");
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(split[n]);
			nextNums[n] = num;
		}
		
		boolean np = nextPermutation();
		if (!np) {
			sb.append(-1);
		}
		else {
			for (int n = 0; n < N; n++) {
				sb.append(nextNums[n]).append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	private static boolean nextPermutation() {
		int w = N - 1;
		while (w > 0 && nextNums[w - 1] > nextNums[w]) {
			w--;
		}
		
		if (w == 0) {
			return false;
		}
		
		int t = N - 1;
		while (t > w && nextNums[w - 1] > nextNums[t]) {
			t--;
		}
		
		swap(t, w - 1);
		
		Arrays.sort(nextNums, w, N);
		
		return true;
	}
	
	private static void swap(int a, int b) {
		int temp = nextNums[a];
		nextNums[a] = nextNums[b];
		nextNums[b] = temp;
	}
	
}
