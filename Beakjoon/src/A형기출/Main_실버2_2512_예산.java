package A형기출;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
 * N은 3 이상 10,000 이하
 *  지방 예산 요청액은 1 이상 100,000 이하
 *  M은 N 이상 1,000,000,000 이하
 */
public class Main_실버2_2512_예산 {
	
	static int N, M; // N: 지방의 수, M: 총 예산
	static Queue<Integer> q = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		String split [] = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			q.offer(Integer.parseInt(split[i]));
		}
		
		M = Integer.parseInt(in.readLine());
		int ans = -1;
		while (!q.isEmpty() && M >= 0) {
			int size = q.size();
			boolean check = false;
			int upperLimitBudget = M / size;
			
			while (size != 0) {
				int cur = q.poll();
				
				if (upperLimitBudget >= cur) {
					check = true;
					M -= cur;
					ans = Math.max(ans, cur);
				}
				else {
					q.offer(cur);
				}
				size--;
			}
			if (!check) {
				ans = upperLimitBudget;
				break;
			}
		}
		System.out.println(ans);
	}
}
