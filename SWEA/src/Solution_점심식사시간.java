import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

// 유형: 완탐(부분집합) - 사람 분배
public class Solution_점심식사시간 {
	
	static int N;
	static ArrayList<int[]> personList; // 사람의 r, c 좌표, 1번 계단까지 가는  이동 시간, 2번 계단까지 가는 이동 시간 저장
	static int stairArr [][]; // 계단의 r, c좌표, 계단의 길이 저장
	static int pNumbers []; // 사람들의 번호 저장
	static PriorityQueue<int []> oneStair; // 1번계단에 들어갈 사람 번호, 이동 시간 저장
	static PriorityQueue<int []> twoStair; // 2번계단에 들어갈 사람 번호, 이동 시간 저장
	static int minTime; // 이동이 완료되는 최소 시간
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			input();
			calcDistance();
			// 사람들을 1번 계단으로 갈 그룹과 2번 계단으로 갈 그룹으로 나누기(부분집합)
			for (int i = 0; i <= personList.size(); i++) divide(personList.size() , i);
			System.out.println("#" + tc + " " + minTime);
		}
		
	}
	
	static void start() {
		// 1번 계단으로 간 사람들이 다 내려오는데 걸린 최소 시간
		int oneStairTime = go(oneStair, 0);
		// 2번 계단으로 간 사람들이 다 내려오는데 걸린 최소 시간
		int twoStairTime = go(twoStair, 1);
		// 둘 중 더 큰 값이 사람들이 다 내려오는데 걸린 최소 시간임
		int time = Math.max(oneStairTime, twoStairTime);
		
		// 이동이 완료되는 최소 시간 구하기
		minTime = Math.min(minTime, time);
	}
	
	/** 사람들이 아래층으로 내려가는데 걸린 최소 시간 반환*/
	static int go(PriorityQueue<int []> stair, int sNum) {
		
		if (stair.isEmpty()) return 0;
		
		int done = stair.size();
		// 현재 계단에 올라와있는 사람들의 번호, 남은 거리 정보 저장
		Deque<int []> onStairQ = new ArrayDeque<>();
		// 현재 계단 입구에 도착한 사람들의 번호, 남은 거리 정보 저장
		Queue<int []> stairEntranceQ = new ArrayDeque<>();
		// 이동 완료한 사람들의 번호 저장
		Queue<Integer> arrivedQ = new ArrayDeque<>();
		// 대기 중인 사람들의 번호, 남은 거리 정보 저장
		Queue<int []> waitingQ = new ArrayDeque<>();
		
		int time = stair.peek()[1] - 1;
		while(arrivedQ.size() < done) { // 모든 사람들이 아래층으로 이동완료 했으면 끝!
			
			time++;
			
			// 계단을 내려가고 있는 사람들은 1칸 더 내려간다
			int size = onStairQ.size();
			while(!onStairQ.isEmpty() && --size >= 0) {
				
				int cur [] = onStairQ.poll(); // cur[0]: 사람 번호, cur[1]: cur[0]번째 사람이 계단을 내려가는데 남은 시간
				if (cur[1] - 1 == 0) { // 1칸 더 내려갔을 때 남은 거리가 없다면
					arrivedQ.offer(cur[0]); // 도착!
				}
				else { // 아직 남은 거리가 있다면
					onStairQ.offer(new int[] {cur[0], cur[1] - 1}); // 남은 거리를 -1 해준다
				}
				
			}
			
			// 계단 위에 사람이 추가로 더 올라갈 수 있으면, 대기 중인 사람이 있는지 부터 확인
			while(!waitingQ.isEmpty() && onStairQ.size() < 3) {
				int cur [] = waitingQ.poll();
				onStairQ.offer(cur); // 대기 중인 사람이 있으면 계단 내려가기 시작!
			}
			
			// 계단 위에 사람이 추가로 더 올라갈 수 있으면, 계단 입구에 도착한 사람이 있는지 확인
			while(!stairEntranceQ.isEmpty() && onStairQ.size() < 3) {
				int cur [] = stairEntranceQ.poll();
				onStairQ.offer(cur); // 계단 입구에 도착해있는 사람이 있다면 계단 내려가기 시작!
			}
			
			// 계단을 내려가야 하지만, 계단 위에 사람이 3명 있어서 못 올라가는 경우 대기큐에 삽입
			while(!stairEntranceQ.isEmpty() && onStairQ.size() == 3) {
				int cur [] = stairEntranceQ.poll();
				waitingQ.offer(cur);
			}
			
			// time 시간에 계단에 도착한 사람이 있으면 stairEntranceQ에 넣는다
			while (!stair.isEmpty() && stair.peek()[1] == time) {
				int pNum = stair.poll()[0];
				stairEntranceQ.offer(new int[] {pNum, stairArr[sNum][2]});
			}
			
		}
		
		return time;
	}
	
	/** nCm 구하기 */
	static void divide(int n, int m) {
		// 1. 플래그 배열 설정
		int flag [] = new int[n];
		int cnt = 0;
		while(++cnt <= m) flag[n - cnt] = 1;		
		
		do {
			
			oneStair = new PriorityQueue<>((m1, m2) -> Integer.compare(m1[1], m2[1]));
			twoStair = new PriorityQueue<>((m1, m2) -> Integer.compare(m1[1], m2[1]));
			
			for (int i = 0; i < n; i++) {
				// 2. 1번 계단에 들어갈 사람들 조합 구하기
				if (flag[i] == 1) oneStair.offer(new int[] {pNumbers[i], personList.get(pNumbers[i])[2]});
				// 3. 2번 계단에 들어갈 사람들 조합 구하기
				else twoStair.offer(new int[] {pNumbers[i], personList.get(pNumbers[i])[3]});
			}
			
			// 이동 시작
			start();
			
		} while(np(flag));
		
	}
	
	static boolean np(int p []) {
		final int SIZE = p.length;
		
		int i = SIZE - 1;
		while(i > 0 && p[i - 1] >= p[i]) i--;
		if (i == 0) return false;
		
		int j = SIZE - 1;
		while(p[i - 1] >= p[j]) j--;
		
		swap(i - 1, j, p);
		
		int k = SIZE - 1;
		while(i < k) swap(i++, k--, p);
		
		return true;
	}
	
	static void swap(int a, int b, int p []) {
		int tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;
	}
	
	/** 각 사람과 1번 계단 , 2번 계단까지 가는 이동시간 구하기 */
	static void calcDistance() {
		for (int i = 0; i < personList.size(); i++) {
			for (int j = 0; j < stairArr.length; j++) {
				int pr = personList.get(i)[0];
				int pc = personList.get(i)[1];
				int sr = stairArr[j][0];
				int sc = stairArr[j][1];
				
				int time = Math.abs(pr - sr) + Math.abs(pc - sc);
				personList.get(i)[j + 2] = time;
			}
		}
	}
	
	public static void input() throws Exception {
		N = Integer.parseInt(in.readLine());
		
		personList = new ArrayList<>();
		stairArr = new int[2][3];
		minTime = Integer.MAX_VALUE;
		int stairCnt = 0;
		
		for (int i = 0; i < N; i++) {
			String split [] = in.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int v = Integer.parseInt(split[j]);
				// 사람 정보 저장
				if (v == 1) personList.add(new int[] {i, j, 0, 0});
				// 계단 정보 저장
				else if (v > 1) stairArr[stairCnt++] = new int[] {i, j, v}; 
			}
		}
		
		// 사람들의 번호 저장
		pNumbers = new int[personList.size()];
		for (int i = 0; i < personList.size(); i++) pNumbers[i] = i;
	}
	
}
