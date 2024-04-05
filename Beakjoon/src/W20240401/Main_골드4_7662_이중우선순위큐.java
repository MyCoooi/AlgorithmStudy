package W20240401;

import java.util.*;
import java.io.*;

/*
 * <주의>
 * 1. 동일한 정수가 삽입될 수 있다!!!
 * 2. 삭제 연산에서 최댓값(최솟값)이 둘 이상인 경우, 하나만 삭제
 * 3. 큐가 비어있을 때, D 연산을 하면 무시
 */
public class Main_골드4_7662_이중우선순위큐 {
	
	static final int MAXVALUE = 1;
	static final int MINVALUE = -1;
	
	static int K; // 연산의 개수
	
	static class DoubleQ {
		PriorityQueue<Integer> max;
		PriorityQueue<Integer> min;
		public DoubleQ() {
			super();
			this.max = new PriorityQueue<>();
			this.min = new PriorityQueue<>();
		}
		public void insert(int n) {
			
		}
		public void deleteMax() {
			
		}
		public void deleteMin() {
			
		}
		public int getMin() {
			
		}
		public int getMax() {
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(in.readLine());
			
			for (int i = 0; i < K; i++) {
				String split [] = in.readLine().split(" ");
				char cmd = split[0].charAt(0); // 어떤 연산인지?
				int n = Integer.parseInt(split[1]); // 연산의 타겟값
				
				DoubleQ doubleQ = new DoubleQ();
				
				if (cmd == 'I') doubleQ.insert(n);
				else if (cmd == 'D' && n == MAXVALUE) doubleQ.deleteMax();
				else doubleQ.deleteMin();
			}
			
			Integer min = doubleQ.getMin();
			Integer max = doubleQ.getMax();
			if (min == null && max == null) sb.append("EMPTY\n");
			else sb.append(max + " " + min + "\n");
		}
		System.out.print(sb);
	}
	
}
