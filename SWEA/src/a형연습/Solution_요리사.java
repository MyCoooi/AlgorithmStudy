package a형연습;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 유형: 완탐(조합)
public class Solution_요리사 {
	
	static int N; // N: 식재료의 수. (4 ≤ N ≤ 16)
	static int synergy [][];
	static int mem []; // fact() 사용을 위해 필요
	static int flag [];
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			
			// 입력 받기
			N = Integer.parseInt(in.readLine());
			
			synergy = new int[N][N];
			mem = new int[N + 1];
			mem[0] = mem[1] = 1;
			flag = new int[N];
			ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				String split [] = in.readLine().split(" ");
				for (int j = 0; j < N; j++) synergy[i][j] = Integer.parseInt(split[j]);
			}
			
			// 식재료 번호 저장
			int numbers [] = new int[N];
			for (int i = 0; i < N; i++) numbers[i] = i;
			
			// 플래그 배열 초기화
			int cnt = 0;
			while (++cnt <= N / 2) flag[N - cnt] = 1;
			
			// 조합 찾기
			do {
				
				int a [] = new int[N / 2];
				int aCnt = 0;
				int b [] = new int[N / 2];
				int bCnt = 0;
				for (int i = 0; i < N; i++) {
					if (flag[i] == 1) a[aCnt++] = numbers[i];
					else b[bCnt++] = numbers[i];
				}
				
				int aSynergy = 0;
				int bSynergy = 0;
				for (int i = 0; i < N / 2 - 1; i++) {
					for  (int j = i; j < N / 2; j++) {
						aSynergy += synergy[a[i]][a[j]] + synergy[a[j]][a[i]];
						bSynergy += synergy[b[i]][b[j]] + synergy[b[j]][b[i]];
					}
				}
				
				ans = Math.min(ans, Math.abs(aSynergy - bSynergy));
				
			} while (np(flag));
			
			System.out.println("#" + testCase + " " + ans);
			
		} // end testCase iter
	} // end main()
	
	public static boolean np(int p []) {
		final int SIZE = p.length;
		
		int i = SIZE - 1;
		while (i > 0 && p[i - 1] >= p[i]) i--;
		if (i == 0) return false;
		
		int j = SIZE - 1;
		while (p[i - 1] >= p[j]) j--;
		
		swap(i - 1, j, p);
		
		int k = SIZE - 1;
		while (i < k) swap(i++, k--, p);
		
		return true;
	} // end np()
	
	public static void swap(int a, int b, int p []) {
		int tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;
	}
}
