package W20240311;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_골드4_2110_공유기설치 {

	static int N, C; // N: 집의 개수, C: 공유기의 개수
	static int xArr [];
	
	public static void main(String[] args) throws Exception {
		/* 입력 받기 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);
		
		xArr = new int[N];
		
		for (int i = 0; i < N; i++) {
			xArr[i] = Integer.parseInt(in.readLine());
		}
	}
}
