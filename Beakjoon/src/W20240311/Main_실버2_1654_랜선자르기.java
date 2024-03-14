package W20240311;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 원래 알고리즘
 * : 입력받은 케이블 중 가장 짧은 케이블에 대해 이분 탐색을 진행하여 답을 구했다.
 * 하지만 이 경우 반례가 생긴다.
 * 3 5
 * 100
 * 1
 * 1
 * 해당 테스트케이스의 답은 20이 되어야 하지만, 내 알고리즘의 경우 1이 나오게 된다.
 * 
 * => 수정: 입력받은 랜선 케이블 중 제일 긴 케이블에 대해 이분 탐색을 진행하여 답을 도출.
 * */
public class Main_실버2_1654_랜선자르기 {
	
	static int K, N; // K: 이미 가지고 있는 랜선의 개수, N: 필요한 랜선의 개수
	static int lanCables [];

	public static void main(String[] args) throws Exception {
		/* 입력 받기 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		K = Integer.parseInt(split[0]);
		N = Integer.parseInt(split[1]);
		
		long ans = Integer.MIN_VALUE;
		int maxLanCable = Integer.MIN_VALUE;
		lanCables = new int[K];
		
		for (int i = 0; i < K; i++) { // O(K) = 최악의 경우 10,000
			int lanCable = Integer.parseInt(in.readLine());
			lanCables[i] = lanCable;
			maxLanCable = Math.max(maxLanCable, lanCable);
		}
		ans = Math.max(ans, binarySearch(maxLanCable));
		
		// 결과 출력
		System.out.println(ans);
	}
	
	static long binarySearch(int maxLanCable) {
		long start = 1;
		long end = maxLanCable;
		long mid = 0;
		long val = Integer.MIN_VALUE;
		while(start <= end) {
			
			mid = (start + end) / 2;
			
			int n = calc(mid);
			if (n >= N) {
				val = mid;
				start = mid + 1;
			}
			else if (n < N) {
				end = mid - 1; // 랜선 길이 더 줄여야 돼!
			}
			else start = mid + 1; // 랜선 길이 더 늘려야 돼!
		}

		return val;
	}
	
	/** 랜선 케이블을 leng길이만큼 잘랐을 때 몇개가 나오는지 확인!! */
	static int calc(long leng) {
		int cnt = 0;
		for (int i = 0; i < K; i++) {
			cnt += lanCables[i] / leng;
		}
		return cnt;
	}
}
