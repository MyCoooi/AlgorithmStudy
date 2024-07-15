package W20240715;

import java.util.*;
import java.io.*;

public class Main_실버3_1004_천사 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		int [] departures = new int[2];
		int [] arrivals = new int[2];
		for (int tc = 1; tc <= T; tc++) {
			String split [] = in.readLine().split(" ");
			
			departures[0] = Integer.parseInt(split[0]); // 출발지 X 좌표
			departures[1] = Integer.parseInt(split[1]); // 출발지 Y 좌표
			arrivals[0] = Integer.parseInt(split[2]); // 도착지 X 좌표
			arrivals[1] = Integer.parseInt(split[3]); // 도착지 Y 좌표
			
			split = in.readLine().split(" ");
			int N = Integer.parseInt(split[0]); // 행성계 갯수
			
			int ans = 0;
			for (int n = 0; n < N; n++) {
				split = in.readLine().split(" ");
				
				int planetX = Integer.parseInt(split[0]); // 행성의 X 좌표
				int planetY = Integer.parseInt(split[1]); // 행성의 Y 좌표
				int planetR = Integer.parseInt(split[2]); // 행성의 반지름
				
				// 출발지와 도착지가 해당 행성안에 들어가있는지 체크
				boolean departCheck = insideCheck(departures[0], departures[1], planetX, planetY, planetR);
				boolean arrivCheck = insideCheck(arrivals[0], arrivals[1], planetX, planetY, planetR);
				
				if (departCheck && !arrivCheck) ans++;
				else if (!departCheck && arrivCheck) ans++;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static boolean insideCheck(int dotX, int dotY, int planetX, int planetY, int planetR) {
		double dist = Math.sqrt(Math.pow(dotX - planetX, 2) + Math.pow(dotY - planetY, 2)); // 점과 행성의 중심점까지의 거리
		
		if (dist < (double)planetR) {
			return true;
		}
		return false;
	}
}
