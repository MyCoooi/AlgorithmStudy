package W20240729;

import java.util.*;
import java.io.*;

public class Main_실버2_그르다김가놈_18113 {
	
	static int N, M, K;
	static int kimbabLeng[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		
		N = Integer.parseInt(split[0]); // 김밥 개수
		K = Integer.parseInt(split[1]); // 꼬다리 길이
		M = Integer.parseInt(split[2]); // 김밥 조각의 최소 개수
		
		kimbabLeng = new int[N]; // 손질된 김밥 길이
		int maxLeng = 0;
		for (int n = 0; n < N; n++) {
			int leng = Integer.parseInt(in.readLine());
			
			if (leng >= 2 * K) {
				leng = leng - 2 * K;
			}
			else if (leng > K) {
				leng = leng - K;
			}
			else {
				leng = 0; // 김밥 폐기
			}
			maxLeng = Math.max(maxLeng, leng);
			kimbabLeng[n] = leng;
		}
		
		int ans = binarySearch(maxLeng);
		System.out.println(ans);
	}
	
	public static int binarySearch(int high) {
		int low = 1;
		int ret = -1;
		while(low <= high) {
			// 김밥 조각의 길이 P
			int mid = (low + high) / 2;
			
			// mid 만큼의 길이로 김밥을 잘랐을 때, 김밥 조각의 개수가 M보다 많은가?
			if (isMoreThanM(mid)) {
				low = mid + 1;
				ret = mid;
			}
			else {
				high = mid - 1;
			}
		}
		// 문제 조건을 만족하는 P가 없는 경우 -1 반환
		return ret;
	}
	
	public static boolean isMoreThanM(int p) {
		int sum = 0;
		for (int n = 0; n < N; n++) {
			sum += kimbabLeng[n] / p;
		}
		return sum >= M;
	}
}
