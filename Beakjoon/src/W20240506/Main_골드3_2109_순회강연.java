package W20240506;

import java.io.*;
import java.util.*;

public class Main_골드3_2109_순회강연 {

	static int N;
	static PriorityQueue<Request> requests1;
	static PriorityQueue<Request> requests2;
	
	static class Request{
		int p, d;

		public Request(int p, int d) {
			super();
			this.p = p; // 강연료
			this.d = d; // 강연 일수
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine()); // 강연을 요청한 대학의 개수
		
		// N값으로 0이 들어올 수 있다
		if (N == 0) {
			System.out.println("0");
			return;
		}
		
		requests1 = new PriorityQueue<>(new Comparator<Request>() {
			@Override
			public int compare(Request o1, Request o2) {
				if (o1.d == o2.d) {
					return Integer.compare(o2.p, o1.p);
				}
				return Integer.compare(o2.d, o1.d);
			}
		});
		requests2 = new PriorityQueue<>(new Comparator<Request>() {
			@Override
			public int compare(Request o1, Request o2) {
				return Integer.compare(o2.p, o1.p);
			}
		});
		for (int i = 0; i < N; i++) {
			String split [] = in.readLine().split(" ");
			
			int p = Integer.parseInt(split[0]);
			int d = Integer.parseInt(split[1]);
			requests1.offer(new Request(p, d));
		}
		
		Request top = requests1.poll();
		int answer = top.p;
		int day = top.d;
		while(day > 0 && !(requests1.isEmpty() && requests2.isEmpty())) {
			while (!requests1.isEmpty()) {
				Request cur = requests1.peek();
				if (cur.d >= day) {
					requests2.offer(requests1.poll());
				}
				else break;
			}
			
			day--;
			if (day <= 0 || (requests1.isEmpty() && requests2.isEmpty())) break;
			
			if (requests1.isEmpty()) {
				answer += requests2.poll().p;
			}
			else {				
				Request r1 = requests1.peek();
				if (!requests2.isEmpty()) {
					Request r2 = requests2.peek();
					if (r1.d < day) {
						answer += requests2.poll().p;
					}
					else {
						if (r1.p >= r2.p) {
							answer += requests1.poll().p;
						}
						else {
							answer += requests2.poll().p;
						}
					}
				}
				else {
					if (r1.d < day) continue;
					else {
						answer += requests1.poll().p;
					}
				}
			}

			
		}
		
		System.out.println(answer);
		
	}
}
