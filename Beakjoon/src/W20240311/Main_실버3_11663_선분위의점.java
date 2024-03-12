package W20240311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_실버3_11663_선분위의점 {
	
	static int N, M;
	static int points [];
	static int lines [][];

	public static void main(String[] args) throws Exception {
		input();
		for (int i = 0; i < M; i++) {
			
			int startP = Math.min(lines[i][0], lines[i][1]);
			int endP = Math.max(lines[i][0], lines[i][1]);
			
			int ans = 0;
			if (points[0] > endP || points[N - 1] < startP);
			else {				
				int minIdx = binary_search(startP, true);
				int maxIdx = binary_search(endP, false);
				ans = maxIdx - minIdx + 1;
			}
			
			System.out.println(ans);
		}
	}
	
	static int binary_search(int tg, boolean flag)	{
		// flag가 true인 경우: 선분의 시작점을 의미(작은 값)
		// flag가 false인 경우: 선분의 끝점을 의미(큰 값)
		int start = 0;
		int end = N - 1;
		int mid = -1;
		int ansMid = -1;
		int value = (flag) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		while(start <= end) {
			mid = (start + end) / 2;
			
			int cur = points[mid];
			
			if (cur == tg) return mid;
			else {
				if (flag) { // 선분의 시작점인 경우
					// 선분의 시작점보다 큰 값 중 제일 작은 값을 찾아야 한다
					if (cur < tg) {
						start = mid + 1;
					}
					else { // cur > tg
						if (cur < value) {
							value = cur;
							ansMid = mid;
						}
						end = mid - 1;
					}
				}
				else { // 선분의 끝점인 경우
					// 선분의 끝점보다 작은 값 중 제일 큰 값을 찾아야 한다
					if (cur > tg) {
						end = mid - 1;
					}
					else { // cur < tg
						if (cur > value) {
							value = cur;
							ansMid = mid;
						}
						start = mid + 1;
					}
				}
			}
		}
		
		if (ansMid == -1) return mid;
		else return ansMid;
	}
	
	
	static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		points = new int[N];
		lines = new int[M][2];
		
		split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			points[i] = Integer.parseInt(split[i]);
		}
		
		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			lines[i][0] = Integer.parseInt(split[0]);
			lines[i][1] = Integer.parseInt(split[1]);
		}
		
		// 오름차순 정렬
		Arrays.sort(points);
	}
}
