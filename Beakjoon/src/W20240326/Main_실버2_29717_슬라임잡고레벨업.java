package W20240326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_실버2_29717_슬라임잡고레벨업 {

	static long N; // 처치한 슬라임 수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			N = Long.parseLong(in.readLine());
			sb.append(binarySearch() + "\n");
		}
		// 결과 출력
		System.out.println(sb);
	}
	
	static int binarySearch() {
		int start = 2;
		int end = 1500000000; // 문제 조건 하에, 슬라임을 처치했을 때 up할 수 있는 최대 레벨(정확하게 계산한 값은 아님. 실제로는 이거보다 작음)
		long getExp = (N + 1) * (N / 2); // 슬라임을 N마리 처치했을 때 얻을 수 있는 경험치
		long offset = (1 + N) / 2;
		getExp = (N % 2 != 0) ? getExp + offset : getExp;
		int mid = 1; // 슬라임을 N마리 처치했을 때 달성할 수 있는 레벨
		int ret = mid; // 슬라임을 N마리 처치했을 때 달성할 수 있는 최대레벨
		while(start <= end) {
			mid = (start + end) / 2;
			if (isSatisfied(mid, getExp)) {
				// N마리 슬라임을 처치했을 때 mid 레벨까지  up 할 수 있는 경우
				start = mid + 1; // 달성할 수 있는 최대 레벨을 구해야하므로 레벨을 더 올려보자!
				ret = mid; // 달성할 수 있는 레벨 갱신
			} else {
				// N마리 슬라임을 처치해도 mid 레벨까지 up 하지 못하는 경우
				end = mid - 1; // 레벨을 더 줄여야 함!
			}
		}
		return ret;
	}
	
	// 결정문제 API
	// N마리 슬라임을 처치하고 mid 레벨까지 up 할 수 있는가?
	private static boolean isSatisfied(int mid, long getExp) {
		long neededExp = (((long)mid - 1) * 2 + 2) * (((long)mid - 1) / 2); // mid 레벨까지 up할 때 필요한 최소 경험치
		long offset = (((long)mid + 2) / 2 - 1) * 2;
		neededExp = (((long)mid - 1) % 2 != 0) ? neededExp + offset : neededExp;
		
		return getExp >= neededExp;
	}
}
