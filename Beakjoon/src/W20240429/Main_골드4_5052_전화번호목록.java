package W20240429;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_골드4_5052_전화번호목록 {

	static int N;
	static String numbers [];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			
			numbers = new String[N];
			
			for (int i = 0; i < N; i++) {
				numbers[i] = in.readLine();
			}
			
			// 전화번호의 길이에 따라 오름차순
			Arrays.sort(numbers, new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					return Integer.compare(s1.length(), s2.length());
				}
				
			});
			
			System.out.println(Arrays.toString(numbers));
			
			
		} // end testCase iter
	}
}
