package W202410;

import java.util.*;
import java.io.*;

public class Main_실버4_보물_1026 {
	
	static int N, S;
	static int [] listA, listB;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		S = 0;
		listA = new int[N];
		listB = new int[N];
		
		String splitA [] = in.readLine().split(" ");
		String splitB [] = in.readLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			listA[i] = Integer.parseInt(splitA[i]);
			listB[i] = Integer.parseInt(splitB[i]);
		}
		
		// 오름차순 정렬
		Arrays.sort(listA);
		Arrays.sort(listB);
		
		for (int i = 0; i < N; i++) {
			S += listA[N-1-i] * listB[i];
		}
		
		System.out.println(S);
	}
}
