package W20240429;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main_골드4_5052_전화번호목록 {

	static int N;
	static String [] numbers;
	static String answer;
	static ArrayList<ArrayList<String>> numbersDivideByLength;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			
			answer = "YES";
			numbers = new String[N];
			
			for (int i = 0; i < N; i++) {
				String number = in.readLine();
				numbers[i] = number;
			}
			
			Arrays.sort(numbers);
			
			for (int i = 1; i < N; i++) {
				int prev = i - 1;
				int post = i + 1;
				
				int size = Math.min(numbers[prev].length(), numbers[i].length());
				if (numbers[prev].substring(0, size).equals(numbers[i].subSequence(0, size))) {
					answer = "NO";
					break;
				}
				
				if (post >= N) continue;
				
				size = Math.min(numbers[i].length(), numbers[post].length());
				if (numbers[post].substring(0, size).equals(numbers[i].subSequence(0, size))) {
					answer = "NO";
					break;
				}
			}
			
//			printNumbers();
			System.out.println(answer);
		} // end testCase iter
	}
	
	static void printNumbers() {
		System.out.println("++++++[numbers]++++++++");
		for (int i = 0; i < N; i++) {
			System.out.println(numbers[i]);
		}
		System.out.println("++++++++++++");
	}
}
