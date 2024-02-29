import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_무선충전 {
	static final int SIZE = 10;
	static final int NOTMOVE = 0;
	static final int UP = 1;
	static final int RIGHT = 2;
	static final int DOWN = 3;
	static final int LEFT = 4;
	
	static int M, A; // M: 총 이동 시간, A: BC의 개수
	static User userArr [];
	static BC bcArr [];
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int ans; // 모든 사용자가 충전한 양의 최댓값
	
	static class User {
		int r, c;
		int moveInfo [];
		public User(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			moveInfo = new int[M + 1];
			moveInfo[0] = 0; // 0초에는 이동하지 않는다
		}
	}
	
	static class BC {
		int r, c, range, p;
		public BC(int r, int c, int range, int p) {
			super();
			this.r = r;
			this.c = c;
			this.range = range;
			this.p = p;
		}
		public boolean canConnect(int pr, int pc) {
			int dist = Math.abs(this.r - pr) + Math.abs(this.c - pc);
			if (dist > p) return false;
			return true;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(in.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			input();
			for (int time = 0; time <= M; time++) calcChargeAmountSum(time);
			System.out.println(ans);
		}
	}
	
	public static void calcChargeAmountSum(int time) {
		
		
		
	}
	
	public static void input() throws Exception {
		String split [] = in.readLine().split(" ");
		M = Integer.parseInt(split[0]);
		A = Integer.parseInt(split[1]);
		
		userArr = new User[2];
		userArr[0] = new User(1, 1);
		userArr[1] = new User(10, 10);
		bcArr = new BC[A];
		ans = -1;
		
		for (int i = 0; i < 2; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < M; j++) userArr[i].moveInfo[j + 1] = Integer.parseInt(split[j]);
		}
		
		for (int i = 0; i < A; i++) {
			split = in.readLine().split(" ");
			bcArr[i] = new BC(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
		}
	}
}
