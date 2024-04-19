package W20240415;

import java.io.*;
import java.util.*;

public class Solution_D3_View {

	static int N, ans; // N: 건물의 개수
	static int heights [];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			ans = 0;
			heights = new int[N];
			
			String split [] = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(split[i]);
			}
			
			solve();
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}
	
	static void solve() {
		for (int i = 2; i < N - 2; i++) {
			int curH = heights[i];
			// 왼쪽 검사
			boolean left = (heights[i - 1] < curH && heights[i - 2] < curH);
			// 오른쪽 검사
			boolean right = (heights[i + 1] < curH && heights[i + 2] < curH);
			
			if (left && right) {
				// 왼쪽 2건물, 오른쪽 2건물의 높이가 모두 curH보다 낮아야 조망권이 확보된 세대가 존재할 수 있다
				// 왼쪽 건물 중에서 높이가 제일 높은 건물의 높이
				int leftMaxH = Math.max(heights[i - 1], heights[i - 2]);
				// 오른쪽 건물 중에서 높이가 제일 높은 건물의 높이
				int rightMaxH = Math.max(heights[i + 1], heights[i + 2]);
				
				// 조망권이 확보될려면 왼쪽, 오른쪽으로 2칸씩 비어있어야 함
				ans += curH - Math.max(leftMaxH, rightMaxH);
			}
		}
	}
}
