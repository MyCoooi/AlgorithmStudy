import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_수영장 {
	static final int YEAR = 12;

	static int dayMoney, monthMoney, threeMonthMoney, yearMoney;
	static int yearPlan [];
	static int ans; // 수영장을 이용할 수 있는 가장 적은 비용
	static int start, end;

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(in.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			input();
			for (int i = 1; i <= YEAR; i++) {
				if (yearPlan[i] == 0) continue;
				if (start == -1) start = i;
				end = i;
			}
			dfs(start, 0);
			ans = Math.min(ans, yearMoney);
			// 결과 출력
			System.out.println("#" + testCase + " " + ans);
		} // end testCase iter
	}
	
	public static void dfs(int m, int cost) {
		// 기저 조건
		if (m > end) {
			ans = Math.min(ans, cost);
			return;
		}
		
		// 유도 부분
		if (yearPlan[m] != 0) {			
			// 1일 이용권을 이용할 때 계산
			dfs(m+1, yearPlan[m] * dayMoney + cost);
			
			// 한 달 이용권을 이용할 때 계산
			dfs(m+1, monthMoney + cost);
			
			// 3달 이용권을 이용할 때 계산
			dfs(m+3, threeMonthMoney + cost);
		}
		else {
			dfs(m+1, cost);
		}
	}
	
	public static void input() throws Exception {
		
		String split [] = in.readLine().split(" ");
		dayMoney = Integer.parseInt(split[0]);
		monthMoney = Integer.parseInt(split[1]);
		threeMonthMoney = Integer.parseInt(split[2]);
		yearMoney = Integer.parseInt(split[3]);
		
		yearPlan = new int[YEAR + 1]; // 0 인덱스는 쓰지 않는다
		ans = Integer.MAX_VALUE;
		start = end = -1;
		
		split = in.readLine().split(" ");
		for (int i = 1; i <= YEAR; i++) {
			yearPlan[i] = Integer.parseInt(split[i - 1]);
		}
		
	}
	
}