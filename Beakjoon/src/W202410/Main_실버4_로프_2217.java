package W202410;

import java.io.*;
import java.util.*;

public class Main_실버4_로프_2217 {
	
	static int N;
	static int maxWeights [];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		maxWeights = new int[N];
		for (int n = 0; n < N; n++) {
			maxWeights[n] = Integer.parseInt(in.readLine());
		}
		
		// 오름차순 정렬
		Arrays.sort(maxWeights);
		
		int ans = 0;
		for (int n = N - 1; n >= 0; n--) {
			ans = Math.max(ans, maxWeights[n] * (N - n));
		}
		
		System.out.println(ans);
	}
}
