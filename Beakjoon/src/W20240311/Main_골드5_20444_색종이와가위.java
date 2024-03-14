package W20240311;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
ex)
N = 6
가로로 자르는 수, 세로로 자르는 수   잘려진 색종이 조각 수
       0               6        ->      1 * 7 = 7
       1               5        ->      2 * 6 = 12
       2               4        ->      3 * 5 = 15
       3               3        ->      4 * 4 = 16
*/
public class Main_골드5_20444_색종이와가위 {

	static long N, K; // N번의 가위질로 K개의 색종이 조각을 만든다
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Long.parseLong(split[0]);
		K = Long.parseLong(split[1]);
		
		String ans = binarySearch(K);
		System.out.println(ans);
	}

	private static String binarySearch(long tg) {
		long start = 0;
		long end = N / 2;
		long mid = 0; // 가로로 자르는 수
		while(start <= end) {
			mid = (start + end	) / 2;
			
			long stripCnt = (mid + 1) * (N - mid + 1);
			if (stripCnt == tg) return "YES";
			else if (stripCnt < tg) {
				// 색종이 더 잘라야 돼!!
				start = mid + 1;
			}
			else {
				// 색종이 덜 잘라야 돼!!
				end = mid - 1;
			}
		}
		
		return "NO";
	}
}
