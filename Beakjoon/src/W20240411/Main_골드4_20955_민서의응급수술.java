package W20240411;

import java.io.*;
import java.util.*;

public class Main_골드4_20955_민서의응급수술 {

	static int N, M;
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 뉴런의 개수
		M = Integer.parseInt(st.nextToken()); // 시냅스의 개수
		
		graph = new ArrayList<>(N + 1);
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<Integer>());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
	}
}
