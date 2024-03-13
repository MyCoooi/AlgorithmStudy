package W20240311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_실버3_19637_IF문좀대신써줘 {
	
	static int N, M; // N: 칭호의 개수, M: 칭호를 출력해야 하는 캐릭터들의 개수
	static ArrayList<Integer> bounds; // 칭호의 전투력
	static ArrayList<String> names; // 칭호
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		names = new ArrayList<>();
		bounds = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			String name = split[0];
			int bound = Integer.parseInt(split[1]);
			
			if (!bounds.isEmpty() && bounds.get(bounds.size()-1) == bound) continue;
			
			names.add(name);
			bounds.add(bound);
		}
		
		for (int i = 0; i < M; i++) {
			String input = in.readLine();
			String ans = binarySearch(Integer.parseInt(input));
			sb.append(ans + "\n");
		}

		System.out.print(sb);
	}
	
	static String binarySearch(int tg) {
		int start = 0;
		int end = names.size() - 1;
		int mid = -1;
		int ansMid = -1;
		int value = Integer.MAX_VALUE;
		
		while (start <= end) {
			mid = (start + end) / 2;
			
			int curBound = bounds.get(mid);
			
			if (curBound == tg) return names.get(mid);
			else if (curBound < tg) start = mid + 1;
			else { // curBound > tg
				if (value > curBound) {
					value = curBound;
					ansMid = mid;
				}
				
				end = mid - 1;
			}
		}
		
		if (ansMid == -1) return names.get(mid);
		else return names.get(ansMid);
	}

}