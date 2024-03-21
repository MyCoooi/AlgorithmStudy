import java.io.BufferedReader;
import java.io.InputStreamReader;

// fail
public class Main_HSAT1회기출_로봇이지나간경로 {
	static final char VISITED = '#';
	static final char NOT_VISITED= '.';
	
	static int H, W, cnt, firstR, firstC; // H: 격자판 세로 길이, W: 격자판 가로 길이, cnt: 사수가 명령했을 때 로봇이 지나간 곳 개수
	static char map [][];
	static int deltas2 [][] = {{-2,0},{2,0},{0,-2},{0,2}}; // 상,하,좌,우
	static int deltas1 [][] = {{-1,0},{1,0},{0,-1},{0,1}}; // 상,하,좌,우
	static String rotateCmd [][] = {{"","LL","L","R"},{"LL","","R","L"},{"R","L","","LL"},{"L","R","LL",""}}; // 상,하,좌,우
	static char directionIcons [] = {'^', 'v', '<', '>'}; // 상,하,좌,우
	static boolean visited [][];
	static String ansCmds;
	static int ansCoord [];
	static char ansDirection, firstDirection;
	
	static class Robot {
		int direction = -1;
		int r, c;

		public Robot(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

	public static void main(String[] args) {
		
		input();
		
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				if (map[i][j] == VISITED) start(i, j);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(ansCoord[0] + " " + ansCoord[1] + "\n");
		sb.append(ansDirection + "\n");
		sb.append(ansCmds);
		
		System.out.println(sb);
	}
	
	static void start(int startR, int startC) {
		Robot robot = new Robot(startR, startC);
		dfs(robot, "", true);
	}
	
	static void dfs(Robot robot, String tmpCmds, boolean isFirst) {
		visited[robot.r][robot.c] = true;
		
		int tmpr = -1, tmpc = -1;
		for (int d = 0; d < deltas2.length; d++) {
			int nr = robot.r + deltas2[d][0]; // 2칸 전진
			int nc = robot.c + deltas2[d][1]; // 2칸 전진
			
			if (!isIn(nr, nc)) continue;
			
			if (!visited[nr][nc] && map[nr][nc] == VISITED) {
				tmpr = robot.r + deltas1[d][0]; // 1칸 전진
				tmpc = robot.c + deltas1[d][1]; // 1칸 전진
				
				// 2칸을 전진하려면 우선 1칸부터 전진해야 함 -> 1칸 전진한 곳 유효성 체크
				if (map[tmpr][tmpc] == VISITED) {
					visited[tmpr][tmpc] = true;
					if (isFirst) { // 처음 로봇의 방향, 위치 저장 및 설정
						firstDirection = directionIcons[d];
						firstR = robot.r;
						firstC = robot.c;
						robot.direction = d;
					}
					else { // 처음이 아니라면 회전시켜야 한다
						while(robot.direction != d) { // 회전을 시켜야 하면 회전을 시킨다
							tmpCmds += rotateCmd[robot.direction][d];
						}
						// 앞으로 2칸 직진
						tmpCmds += "A";
						// 로봇 위치, 방향 갱신
						robot.r = nr; 
						robot.c = nc;
						robot.direction = d;
					}
					dfs(robot, tmpCmds, false);
				}
				
			}
		}

		if (count() == cnt) { // 사수가 한 것처럼 로봇을 모두 움직였을 때
			// 명령어 개수가 최소인 것을 답으로 한다
			if ("".equals(ansCmds) || ansCmds.length() > tmpCmds.length()) {	
				ansCmds = tmpCmds;
				ansCoord[0] = firstR;
				ansCoord[1] = firstC;
				ansDirection = firstDirection;
			}
			
		}
		
		visited[robot.r][robot.c] = false;
		if (tmpr != -1 && tmpc != -1) visited[tmpr][tmpc] = false;
	}
	
	static boolean isIn(int r, int c) {
		return r > 0 && c > 0 && r <= H && c <= W;
	}
	
	static int count() {
		int ret = 0;
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) if (visited[i][j]) ret++;
		}
		return ret;
	}

	static void input() {
		try {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			String split [] = in.readLine().split(" ");
			H = Integer.parseInt(split[0]);
			W = Integer.parseInt(split[1]);
			
			map = new char[H + 1][W + 1]; // 0행 0열은 쓰지 않는다
			ansCmds = "";
			ansDirection = ' ';
			ansCoord = new int[2];
			visited = new boolean[H + 1][W + 1]; // map[][]과 마찬가지로 0행 0열은 쓰지 않는다
			cnt = 0;
			
			for (int i = 1; i <= H; i++) {
				String inputStr = in.readLine();
				for (int j = 1; j <= W; j++) {
					map[i][j] = inputStr.charAt(j - 1);
					if (map[i][j] == VISITED) cnt++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
