package W20240304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 시간초과..
public class Main_실버3_16922_로마숫자만들기 {
	static final int I = 0;
	static final int V = 1;
	static final int X = 2;
	static final int L = 3;

	static int N, ans; // N: 로마 숫자 개수 (1<=N<=20)
	static int [] value = {1, 5, 10, 50};
	static ArrayList<Integer> list; 
	
	public static void main(String[] args) throws Exception {
		input();
		dfs(0, 0);
		System.out.println(ans);
	}
	
	static void dfs(int cnt, int sum) {
		// 기저조건
		if (cnt == N) {
			if (!find(sum)) {
				list.add(sum);
				ans++;
			}
			return;
		}
		
		// 유도부분
		for (int i = I; i <= L; i++) {
			dfs(cnt + 1, sum + value[i]);
		}
	}
	
	static boolean find(int sum) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == sum) return true;
		}
		return false;
	}
	
	static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		ans = 0;
		list = new ArrayList<>();
	}
}
