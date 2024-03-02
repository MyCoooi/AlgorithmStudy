import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_무선충전 {
	
	static int M, A; // M: 총 이동 시간, A: BC의 개수
	static User userArr [];
	static BC bcArr [];
	static int deltas [][] = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 정지, 상, 우, 하, 좌
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int maxChargeAmount; // 모든 사용자가 충전한 양의 최댓값
	
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
		public BC(int c, int r, int range, int p) {
			super();
			this.c = c;
			this.r = r;
			this.range = range;
			this.p = p;
		}
		public boolean canConnect(int pr, int pc) {
			int dist = Math.abs(this.r - pr) + Math.abs(this.c - pc);
			if (dist > range) return false;
			return true;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(in.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			input();
			for (int time = 0; time <= M; time++) calcChargeAmountSum(time);
			System.out.println("#" + testCase + " " + maxChargeAmount);
		}
	}
	
	public static void calcChargeAmountSum(int time) {
		
		// 0번, 1번 사람 이동
		move(0, time);
		move(1, time);
		
		// 한 사람당 충전 가능한 BC를 충전량 기준으로 내림차순 저장해두면 된다
		PriorityQueue<int []> pq [] = new PriorityQueue[2];
		for (int i = 0; i < 2; i++) pq[i] = new PriorityQueue<>((m1, m2) -> Integer.compare(m2[1], m1[1]));
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < A; j++) {
				BC curBc = bcArr[j];
				
				if (curBc.canConnect(userArr[i].r, userArr[i].c)) { // 충전 가능한 범위 내에 있으면
					pq[i].offer(new int[] {j, curBc.p}); // 큐에 삽입
				}
			}
		}
		
		if (pq[0].size() == 0 && pq[1].size() == 0); // 두 사람 다 충전할 수 있는 BC가 없을 때
		else if (pq[1].size() == 0) { // 0번 사람만 충전할 수 있는 BC가 있을 때
			maxChargeAmount += pq[0].poll()[1];
		}
		else if (pq[0].size() == 0) { // 1번 사람만 충전할 수 있는 BC가 있을 때
			maxChargeAmount += pq[1].poll()[1];
		}
		else { // 두 사람 다 충전할 수 있는 BC가 있을 때
			if (pq[0].peek()[0] == pq[1].peek()[0]) { // BC가 겹치고
				if (pq[0].size() > 1 && pq[1].size() > 1) { // 두 사람 다 충전할 수 있는 BC가 2개 이상일 때
					pq[0].poll();
					maxChargeAmount += pq[1].poll()[1];
					maxChargeAmount += Math.max(pq[0].poll()[1], pq[1].poll()[1]);
				}
				else if (pq[0].size() > 1) { // 0번 사람은 충전할 수 있는 BC가 2개 이상이고 1번 사람은 충전할 수 있는 BC가 1개라면
					maxChargeAmount += pq[0].poll()[1];
					maxChargeAmount += pq[0].poll()[1];
				}
				else if (pq[1].size() > 1) { // 1번 사람은 충전할 수 있는 BC가 2개 이상이고 0번 사람은 충전할 수 있는 BC가 1개라면
					maxChargeAmount += pq[1].poll()[1];
					maxChargeAmount += pq[1].poll()[1];
				}
				else { // 두 사람 다 충전할 수  있는 BC가 1개일 때
					maxChargeAmount += pq[0].poll()[1];
				}
			}
			else { // BC가 겹치지 않으면
				maxChargeAmount += pq[1].poll()[1];
				maxChargeAmount += pq[0].poll()[1];
			}
		}
		
		return;
	}
	
	static void move(int uNum, int time) {
		
		// 사용자가 지도 밖을 나가는 경우는 없으므로 범위를 확인할 필요x
		int nr = userArr[uNum].r + deltas[userArr[uNum].moveInfo[time]][0];
		int nc = userArr[uNum].c + deltas[userArr[uNum].moveInfo[time]][1];
		
		// 사용자의 위치 갱신
		userArr[uNum].r = nr;
		userArr[uNum].c = nc;
		
	}
	
	public static void input() throws Exception {
		String split [] = in.readLine().split(" ");
		M = Integer.parseInt(split[0]);
		A = Integer.parseInt(split[1]);
		
		userArr = new User[2];
		userArr[0] = new User(1, 1);
		userArr[1] = new User(10, 10);
		bcArr = new BC[A];
		maxChargeAmount = 0;
		
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
