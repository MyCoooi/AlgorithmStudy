package W20240304;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_골드4_1062_가르침 {

	static int N, K;
	static String input [];
	
	public static void main(String[] args) throws Exception {
		input();
		
		
	}
	
	static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		K = Integer.parseInt(split[1]);
		
		input = new String[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = in.readLine();
		}
		
	}
}
