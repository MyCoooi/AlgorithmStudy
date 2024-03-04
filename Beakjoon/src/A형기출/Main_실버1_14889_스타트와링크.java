package A형기출;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_실버1_14889_스타트와링크 {

	static int N, M; // N: 축구를 하기 위해 모인 사람의 수. 짝수, M: 나눌 팀원의 수
	static int S [][];
	static int flag [];
	static int combCnt = 0;
	static int mem [];
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 받기
		N = Integer.parseInt(in.readLine());
		S = new int[N+1][N+1]; // 0행, 0열은 쓰지 않는다
		mem = new int[21];
		mem[0] = mem[1] = 1;
		
		for (int i = 1; i <= N; i++) {
			String split [] = in.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				S[i][j] = Integer.parseInt(split[j-1]);
			}
		}
		
		// 팀원 조합 구하기
		
		// 0. 팀원 번호 모두 저장하기
		int totalNum [] = new int[N];
		for (int i = 1; i <= N; i++) totalNum[i-1] = i;
		
		// 1. 플래그 배열 구하기
		M = N / 2;
		flag = new int[N];
		int cnt = 0;
		while (++cnt <= M) flag[N - cnt] = 1;
		
		int tmp = fact(N) / (fact(M) * fact(M));
		
		do {
			
			// 2. 조합 생성
			int num1 [] = new int[M];
			int num2 [] = new int[M];
			int cnt1 = 0;
			int cnt2 = 0;
			for (int i = 0; i < N; i++) {
				if (flag[i] == 1) {
					num1[cnt1++] = totalNum[i];
				}
				else num2[cnt2++] = totalNum[i];
			}
			
			// 3. 로직 처리
			int S1 = 0;
			int S2 = 0;
			for (int i = 0; i < M - 1; i++) {
				for (int j = i+1; j < M; j++) {
					S1 += S[num1[i]][num1[j]] + S[num1[j]][num1[i]];
					S2 += S[num2[i]][num2[j]] + S[num2[j]][num2[i]];
				}
			}
			ans = Math.min(ans, Math.abs(S1 - S2));
			
			
		} while (++combCnt < tmp || np(flag));
		
		System.out.println(ans);
		
	}
	
	public static boolean np(int p []) {
		final int SIZE = p.length;
		
		// 1. 맨 뒤에서부터 꼭대기 위치 찾기
		int i = SIZE - 1;
		while (i > 0 && p[i - 1] >= p[i]) i--;
		
		if (i == 0) return false;
		
		// 2. 맨 뒤에서부터 바꿀 값 찾기
		int j = SIZE - 1;
		while (p[i - 1] >= p[j]) j--;
		
		// 3. 바꾸기
		swap(i - 1, j, p);
		
		// 4. 꼭대기 위치부터 맨 뒤까지 오름차순 정렬
		int k = SIZE - 1;
		while (i < k) swap(i++, k--, p);
		
		return true;
	}
	
	public static void swap(int a, int b, int p []) {
		int tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;
	}
	
	public static int fact(int n) {
		if (mem[n] != 0) return mem[n];
		
		mem[n] = fact(n-1) * n;
		return mem[n];
	}
}
