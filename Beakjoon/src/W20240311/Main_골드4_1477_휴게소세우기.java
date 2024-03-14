package W20240311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_골드4_1477_휴게소세우기 {
	
	static int N, M, L; // N: 현재 휴게소 개수, M: 더 지으려고 하는 휴게소의 개수, L: 고속도로의 길이
	static int [] alreadyBuildedRestAreas;

	public static void main(String[] args) throws Exception {
		input();
		
		
	}
	
	static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		L = Integer.parseInt(split[2]);
		
		alreadyBuildedRestAreas = new int[N];
		
		split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) alreadyBuildedRestAreas[i] = Integer.parseInt(split[i]);
		
		// 오름차순 정렬
		Arrays.sort(alreadyBuildedRestAreas);
	}
}
