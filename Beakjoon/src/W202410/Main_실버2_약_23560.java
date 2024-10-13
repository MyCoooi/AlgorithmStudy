package W202410;

import java.io.*;
import java.util.*;

public class Main_실버2_약_23560 {
	
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
	
		System.out.println(2 * (int)Math.pow(3, N - 1));
	}
}
