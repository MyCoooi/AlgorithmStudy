package W20240819;

import java.io.*;
import java.util.*;

public class Main_골드5_가위바위보_32133 {
	
	static final char rsp [] = {'R', 'S', 'P'};
	
	static int N, M, K, answerDoneRound = 100;
	static char whatThrow [][];
	static boolean isLose [];
	static String answerWhatThrow = "";
	static Map<Character, Character> winType;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		K = Integer.parseInt(split[2]);
		
		whatThrow = new char[N][M];
		isLose = new boolean[N];
		winType = new HashMap<>();
		winType.put('R', 'P');
		winType.put('S', 'R');
		winType.put('P', 'S');
		
		for (int n = 0; n < N; n++) {
			String str = in.readLine();
			for (int m = 0; m < M; m++) {
				whatThrow[n][m] = str.charAt(m);
			}
		}
		
		dfs(1, "");
		
		if (answerDoneRound == 100) {
			System.out.println(-1);
		} else {			
			System.out.println(answerDoneRound);
			System.out.println(answerWhatThrow);
		}
	}
	
	static void dfs(int round, String str) {
		// 기저 조건
		if (round > M || answerDoneRound <= round) {
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			char type = rsp[i];
			int cnt = 0;
			List<Integer> losePeople = new ArrayList<>(); 
			for (int j = 0; j < N; j++) {
				if (isLose[j]) continue;
				
				char rivalType = whatThrow[j][round - 1];
				
				// 대결
				if (winType.get(type) == rivalType) {
					cnt++;
				} else {
					isLose[j] = true;
					losePeople.add(j);
				}
			}
			if (cnt != 0 &&cnt <= K) {
				if (answerDoneRound > round) {
					answerDoneRound = round;
					answerWhatThrow = str + type;
				}
			}
			else if(cnt != 0) {
				dfs(round + 1, str + type);
			}
			for (int k = 0; k < losePeople.size(); k++) {
				isLose[losePeople.get(k)] = false;
			}
		}
	}
	
}
