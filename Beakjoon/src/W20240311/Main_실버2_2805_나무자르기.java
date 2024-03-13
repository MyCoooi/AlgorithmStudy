package W20240311;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// (1 ≤ N ≤ 1,000,000, 1 ≤ M ≤ 2,000,000,000)
// 나무의 높이: 1,000,000,000보다 작거나 같은 양의 정수 또는 0
public class Main_실버2_2805_나무자르기 {
	
	static int N, M; // N: 나무의 수, M: 상근이가 집으로 가져가려고 하는 나무의 길이
	static int trees [];
	
	public static void main(String[] args) throws Exception {
		/* 입력 받기 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		trees = new int[N];
		int maxHeight = Integer.MIN_VALUE;
		
		split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(split[i]);
			maxHeight = Math.max(maxHeight, trees[i]);
		}
		System.out.println(binarySearch(maxHeight));
		
	}
	
	static int binarySearch(int maxHeight) {
		int start = 1;
		int end = maxHeight;
		int mid = 0;
		long takenTreeHeight = Long.MAX_VALUE;
		int ripSawHeight = 0;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			long sum = 0; // 절단기를 mid 높이로 설정해서 나무들을 잘랐을 때 얻어갈 수 있는 나무 총 크기
			for (int i = 0; i < N; i++) {
				if (trees[i] > mid) sum += trees[i] - mid;
			}
			
			if (sum < M) {
				// 나무 더 필요해!!
				end = mid - 1;
			}
			else {
				// 나무 충분히 모았어!!
				if (sum < takenTreeHeight) { // 환경 보호 해야되니까 최대한 적게 가져가자!!
					takenTreeHeight = sum;
					ripSawHeight = mid;
				}
				else if (sum == takenTreeHeight) { // 대신 절단기 높이는 최대로 하자!!
					if (ripSawHeight < mid) {
						ripSawHeight = mid;
						takenTreeHeight = sum;
					}
				}
				
				start = mid + 1;
			}
		}
		
		// 상근이가 집에 필요한 나무를 못 가져가는 경우는 없다.
		return ripSawHeight;
	}
}
