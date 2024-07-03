package W20240628;

import java.util.*;
import java.io.*;

public class Solution_D4_13219_진행률 {
	
	static final int WHITE = 0;
	static final int BLACK = 1;
	static final int WIDTH = 100;
	static final int HEIGHT = 100;
	
	static int [][] insideQuadrantInfo = {{},{1},{1,2,3,4,},{1,3,4},{1,4}}; // 제0사분면은 존재하지 않으므로 사용x.

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			String split [] = in.readLine().split(" ");
			
			int P = Integer.parseInt(split[0]);
			int X = Integer.parseInt(split[1]);
			int Y = Integer.parseInt(split[2]);
			
			// 진행률 P에 대한 부채꼴의 각도
			float degree = 3.6f * P;
			
			// 사분면 중 어디에 속하는 지 확인
			int quadrant = findQuadrant(degree);
			
			// cos 계산을 위한 각도 계산
			// (현재 구한 각도 degree는 부채꼴을 시계방향으로 쓸었을 때의 degree이다. 하지만 cos 계산을 위해서는 x=0직선을 기준으로 시계 반대 방향으로 갈 때의 각도가 필요하다.)
			float cosDegree = calcDegreeForCos(quadrant, degree);
			double cos = Math.cos(Math.toRadians(cosDegree)); // cos 값 계산
			
			System.out.println("진행률:" + P + ", 부채꼴 각도:" + degree + ", 사분면:" + quadrant + ", cos각도:" + cosDegree + ", cos계산값:" + cos);
		}
	}
	
	static float calcDegreeForCos(int quadrant, float degree) {
		float ret = 0.0f;
		
		switch (quadrant) {
		case 1:
			ret = 90.0f - degree;
			break;
		case 2:
			ret = 360.0f - degree + 90.0f;
			break;
		case 3:
			ret = 360.0f - degree + 90.0f;
			break;
		case 4:
			ret = 360.0f - degree + 90.0f;
			break;
		}
		
		return ret;
	}

	static int findQuadrant(float degree) { // 음수가 들어오지 않는다는 가정하에
		if (degree <= 90) {
			return 1;
		}
		else if (degree <= 180) {
			return 4;
		}
		else if (degree <= 270) {
			return 3;
		}
		else {
			return 2;
		}
	}
}
