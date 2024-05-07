package W20240506;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 아직 안함!!
public class Main_골드3_2109_순회강연 {

	static int N;
	static Request [] requests;
	
	static class Request {
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
		
		requests = new Request[N];
		for (int i = 0; i < N; i++) {
			String split [] = in.readLine().split(" ");
			
			int p = Integer.parseInt(split[0]);
			int d = Integer.parseInt(split[1]);
			requests[i] = new Request(p, d);
		}
		
		Arrays.sort(requests, new Comparator<Request>() {

			@Override
			public int compare(Request o1, Request o2) {
				return Integer.compare(o1.d, o2.d);
			}
			
		});
		
		for (int i = 0; i < N; i++) {
			System.out.println(requests[i].p + "," + requests[i].d);
		}
		
	}
}
