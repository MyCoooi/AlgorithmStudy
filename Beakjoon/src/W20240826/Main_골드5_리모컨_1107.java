package W20240826;

import java.io.*;
import java.util.*;

public class Main_골드5_리모컨_1107 {
	
	static final int CURRENT_CHANNEL = 100;

	static int N, M, answer;
	static boolean isBroken [] = new boolean[10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		
		if (M != 0) {
			String split [] = in.readLine().split(" ");
			for (int m = 0; m < M; m++) {
				isBroken[Integer.parseInt(split[m])] = true;
			}
		}
		
		// 현재 채널에서 +/- 버튼 만으로 채널 이동을 하는 경우
		int sum2 = Math.abs(CURRENT_CHANNEL - N);
		
		// 현재 채널에서 제일 가까운 채널로 건너뛰고 +/- 버튼을 눌러 채널 이동을 하는 경우
		int sum1 = Math.abs(CURRENT_CHANNEL - N);
		int minusMove = Integer.MAX_VALUE;
		int plusMove = Integer.MAX_VALUE;
		if (M != 10) {
			for (int channel = N; channel >= 0; channel--) {
				// channel 채널로 건너뛰어본다
				int move = Integer.toString(channel).length();
				
				// channel 채널로 건너뛸 수 없다면 continue
				if (!canJump(channel)) continue;
				
				// channel 채널로 건너뛸 수 있다면 channel 채널에서 N 채널로 - 버튼을 이용해 이동
				move += N - channel;
				minusMove = Math.min(minusMove, move);
			}
			int channel = N;
			while (true) {
				// channel 채널로 건너뛰어본다
				int move = Integer.toString(channel).length();
				
				if (move + (channel - N) > minusMove) {
					break;
				}
				
				// channel 채널로 건너뛸 수 있다면 channel 채널에서 N 채널로 + 버튼을 이용해 이동
				if (canJump(channel)) {
					move += channel - N;
					plusMove = Math.min(plusMove, move);
					break;
				}
				
				channel++;	
			}
			sum1 = Math.min(plusMove, minusMove);
		}
		
		answer = Math.min(sum1, sum2);
		System.out.println(answer);
	}
	
	static boolean canJump(int channel) {
		String channelToString = Integer.toString(channel);
		
		for (int i = 0; i < channelToString.length(); i++) {
			int n = channelToString.charAt(i) - '0';
			if (isBroken[n]) {
				return false;
			}
		}
		return true;
	}
}
