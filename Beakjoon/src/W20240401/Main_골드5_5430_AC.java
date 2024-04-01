package W20240401;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_골드5_5430_AC {

	static int N;
	static ArrayDeque<Integer> nums;
	static String cmd;
	static String direction;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {			
			cmd = in.readLine();
			N = Integer.parseInt(in.readLine());
			String input = in.readLine();
			String subStr = input.substring(1, input.length() - 1);
			String split [] = subStr.split(",");
			
			nums = new ArrayDeque<>();
			direction = "first";
			
			if (N != 0) {				
				for (int i = 0; i < split.length; i++) nums.offerLast(Integer.parseInt(split[i]));
			}
			
			solve();
		}
		
		// 결과 출력
		System.out.println(sb);
		
	}

	private static void solve() {
		for (int i = 0; i < cmd.length(); i++) {
			if (cmd.charAt(i) == 'R') {
				reverse();
			}
			else if (cmd.charAt(i) == 'D') {
				boolean canBeImplemented = delete();
				
				if (!canBeImplemented) { // 명령을 수행했을 때 에러가 발생했다면
					sb.append("error\n");
					return;
				}
			}
		}
		
		// 모든 명령을 정상적으로 수행했다면
		sb.append("[");
		while(!nums.isEmpty()) {
			if ("first".equals(direction)) {				
				sb.append(nums.pollFirst());
			}
			else {
				sb.append(nums.pollLast());
			}
			if (nums.size() != 0) sb.append(",");
		}
		sb.append("]\n");
	}

	private static boolean delete() {
		if (nums.isEmpty()) return false;
		
		if ("first".equals(direction)) nums.pollFirst();
		else nums.pollLast();
		return true;
	}

	private static void reverse() {
		direction = (direction == "first") ? "last" : "first";
	}
}
