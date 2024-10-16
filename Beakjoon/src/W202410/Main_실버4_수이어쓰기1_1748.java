package W202410;

import java.util.*;
import java.io.*;

public class Main_실버4_수이어쓰기1_1748 {
	
	static int N;
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		ans = 0;
		
		// N의 자릿수를 구함
		int cnt = 1;
		int tmpN = N;
		while (tmpN % (Math.pow(10, cnt)) != tmpN) {
			cnt++;
		}
		
		int divisionCnt = cnt;
		int division = (int) Math.pow(10, divisionCnt - 1);
		ans += cnt * (N - division + 1);
		
		while (division != 1) {
			divisionCnt--;
			int tmpDivision = (int) Math.pow(10, divisionCnt - 1);
			ans += divisionCnt * (division - tmpDivision);
			division = tmpDivision;
		}
		System.out.println(ans);
	}
}
