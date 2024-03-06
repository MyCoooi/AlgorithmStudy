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
	static int [] cnt;
	static ArrayList<Integer> list; 
	
	public static void main(String[] args) throws Exception {
		input();
		dfs(0, N);
		System.out.println(ans);
	}
	
	static void dfs(int depth, int remain) {
		// 기저조건
		if (depth == 4 || remain == 0) {
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				sum += (cnt[i] * value[i]);
			}
			boolean check = true;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) == sum) {
					check = false;
					break;
				}
			}
			if (check) {
				list.add(sum);
				ans++;
			}
			return;
		}
		
		// 유도부분
		if (depth == 3) {
			cnt[depth] = remain;
			dfs(depth + 1, 0);
			cnt[depth] = 0;
		}
		else {			
			for (int i = 0; i <= remain; i++) {
				cnt[depth] = i;
				dfs(depth + 1, remain - i);
				cnt[depth] = 0;
			}
		}
		
	}
	
	static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		ans = 0;
		list = new ArrayList<>();
		cnt = new int[4];
	}
}
