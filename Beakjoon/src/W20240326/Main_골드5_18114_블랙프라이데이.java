package W20240326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_골드5_18114_블랙프라이데이 {
	
	static int C, N; // C: 백화점에서 제시한 무게, N: 물건의 개수
	static int w [];
	static boolean canBeResult []; // canBeResult[i]: 최대 3개의 물건을 선택하여 나올 수 있는 무게면 true 아니면 false
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);
		
		w = new int[N];
		canBeResult = new boolean[100000001]; // 0 인덱스는 사용하지 않는다(무게가 0인 경우는 고려 x)
		ans = 0;
		
		split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			w[i] = Integer.parseInt(split[i]);
			canBeResult[w[i]] = true;
			// 물건을 1개 선택했을 때 무게 C를 맞출 수 있는지 검사한다
			if (w[i] == C) {
				ans = 1;
				break;
			}
		}
		
		// ---- 입력받기 끝!
		
		// 물건을 1개 선택했을 때 무게 C를 맞출 수 있으면 정답을 출력하고 끝낸다
		if (ans == 1) {
			System.out.println(ans);
			return;
		}

		// 물건을 2개 선택한다(조합)
		for(int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int sumW = w[i] + w[j];
				// 물건을 2개 선택했을 때 무게 C를 맞출 수 있는지 검사한다
				if (sumW == C) {
					ans = 1;
					break;
				}
				// 물건을 3개 선택했을 때 무게 C를 맞출 수 있는지 검사한다
				else if (sumW < C) {					
					if (canBeResult[C - sumW] && C - sumW != w[i] && C - sumW != w[j]) {
						ans = 1;
						break;
					}
				}
			}
			if (ans == 1) break;
		}
		
		System.out.println(ans);
		
	}
}
