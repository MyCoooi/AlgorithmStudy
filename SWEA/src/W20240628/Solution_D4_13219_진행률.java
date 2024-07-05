package W20240628;

import java.util.*;
import java.io.*;

public class Solution_D4_13219_진행률 {
	
	static final int WHITE = 0;
	static final int BLACK = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#"  + t + " ");
			String split [] = in.readLine().split(" ");
			
			int P = Integer.parseInt(split[0]);
			int X = Integer.parseInt(split[1]);
			int Y = Integer.parseInt(split[2]);
			
			// 진행률 P에 대한 부채꼴의 각도
			double degree = 3.6 * P;

			if (lengthCheck(X, Y) && calcDegree(X, Y) <= degree) {
				sb.append(BLACK + "\n");
			}
			else {
				sb.append(WHITE + "\n");
			}
		}
		System.out.println(sb);
	}
	
	private static boolean lengthCheck(int x, int y) {
		return Math.sqrt(Math.pow(x-50, 2) + Math.pow(y-50, 2)) <= 50.0;
	}
	
	static double calcDegree(int x, int y) { // (50,50)을 기준으로 (x, y)점의 각도 구하기
		double degree = Math.toDegrees(Math.atan2(x-50,y-50));
		if (degree >= 0.0) {
			return degree;
		}
		else {
			return 360.0 + degree;
		}
	}
}
