package W202410;

import java.io.*;
import java.util.*;

public class Main_실버5_날짜계산_1476 {
	
	static int input [];
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		input = new int[3];
		String split [] = in.readLine().split(" ");
		for (int i = 0; i < 3; i++) {
			input[i] = Integer.parseInt(split[i]);
		}
		
		ans = 1;
		while (!check()) {
			ans++;
		}
		
		System.out.println(ans);
	}
	
	public static boolean check() {
		int e = (ans - 1) % 15 + 1;
		int s = (ans - 1) % 28 + 1;
		int m = (ans - 1) % 19 + 1;
		if (input[0] == e && input[1] == s && input[2] == m) {			
			return true;
		}
		return false;
	}
}
