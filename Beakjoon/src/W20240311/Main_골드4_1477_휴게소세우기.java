package W20240311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_골드4_1477_휴게소세우기 {
	
	static int N, M, L; // N: 현재 휴게소 개수, M: 더 지으려고 하는 휴게소의 개수, L: 고속도로의 길이
	static int [] alreadyBuildedRestAreas, dists;
	
	public static void main(String[] args) throws Exception {
		input();
		calcDist();
		System.out.println(binarySearch());
	}
	
	static int binarySearch() {
		int start = 1;
		int end = L;
		int mid; // 휴게소가 없는 구간의 최댓값
		int value = 0;
		while(start <= end) {
			mid = (start + end	) / 2;
			
			// 지어야하는 휴게소 개수 계산
			int cnt = 0;
			for (int i = 0; i <= N; i++) {
				cnt += dists[i] / mid;
				if (dists[i] % mid == 0) cnt--;
			}
			
			if (cnt > M) {
				// 더 늘려야 돼!
				start = mid + 1;
			}
			else {
				value = mid;
				end = mid - 1;
			}
		}
		return value;
	}
	
	// 휴게소 간 거리 계산 후 큐에 삽입
	static void calcDist() {
		if (N == 0) {
			dists[0] = L;
			return;
		}
		
		dists[0] = alreadyBuildedRestAreas[0];
		for (int i = 1; i < N; i++) {
			dists[i] = alreadyBuildedRestAreas[i] - alreadyBuildedRestAreas[i - 1];
		}
		dists[N] = L - alreadyBuildedRestAreas[N - 1];
	}
	
	static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		L = Integer.parseInt(split[2]);
		
		alreadyBuildedRestAreas = new int[N];
		dists = new int[N + 1];
		
		split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			alreadyBuildedRestAreas[i] = Integer.parseInt(split[i]);
		}
		
		// 오름차순 정렬
		Arrays.sort(alreadyBuildedRestAreas);
	}
}
