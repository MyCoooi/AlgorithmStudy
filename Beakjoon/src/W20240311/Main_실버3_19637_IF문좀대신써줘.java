package W20240311;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// fail
public class Main_실버3_19637_IF문좀대신써줘 {
	
	static int N, M; // N: 칭호의 개수, M: 칭호를 출력해야 하는 캐릭터들의 개수
	static int bounds []; // 칭호의 전투력
	static String names []; // 칭호
	static int characters [];
	
	public static void main(String[] args) throws Exception {
		input();
		for (int i = 0; i < M; i++) {
			String ans = binarySearch(characters[i]);
			System.out.println(ans);
		}
	}
	
	static String binarySearch(int tg) {
		int start = 0;
		int end = N - 1;
		int mid = -1;
		int ansMid = -1;
		int value = Integer.MAX_VALUE;
		
		while (start <= end) {
			mid = (start + end) / 2;
			
			int curBound = bounds[mid];
			
			if (curBound < tg) start = mid + 1;
			else { // curBound >= tg
				if (value > curBound) {
					value = curBound;
					ansMid = mid;
				}
				else if (value == curBound) ansMid = Math.min(ansMid, mid);
				
				end = mid - 1;
			}
		}
		
		
		if (ansMid != -1) return names[ansMid];
		else return names[mid];
	}
	
	static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		names = new String[N];
		bounds = new int[N];
		characters = new int[M];
		
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			String name = split[0];
			int bound = Integer.parseInt(split[1]);
			names[i] = name;
			bounds[i] = bound;
		}
		
		for (int i = 0; i < M; i++) {
			String input = in.readLine();
			characters[i] = Integer.parseInt(input);
		}
	}
}
