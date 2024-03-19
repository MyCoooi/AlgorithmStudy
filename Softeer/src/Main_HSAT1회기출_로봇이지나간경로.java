import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_HSAT1회기출_로봇이지나간경로 {
	static final char VISITED = '#';
	static final char NOT_VISITED= '.';
	static final char LEFT_TURN = 'L'; // 왼쪽으로 90도 회전
	static final char RIGHT_TURN = 'R'; // 오른쪽으로 90도 회전
	static final char GO_2 = 'A'; // 바라보는 방향으로 2칸 전진
	
	static int H, W; // H: 격자판 세로 길이, W: 격자판 가로 길이
	static char map [][];
	static int deltas [][] = {{-1,0},{1,0},{0,-1},{0,1}}; // 상,하,좌,우
	static char directionIcons [] = {'^', 'v', '<', '>'}; // 상,하,좌,우
	static boolean visited [][];
	static String ansCmds;
	static char ansDirection;
	
	static class Position {
		int r, c;

		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

	public static void main(String[] args) {
		
		input();
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				if (map[i][j] == VISITED) dfs(i, j);
			}
		}
	}
	
	static void dfs(int curR, int curC) {
		for (int d = 0; d < deltas.length; d++) {
			int nr = curR + deltas[d][0];
			int nc = curC + deltas[d][1];
			
			if (!isIn(nr, nc)) continue;
			
			if (!visited[nr][nc] && map[nr][nc] == VISITED) {
				dfs(nr, nc);
			}
		}
		
		visited[curR][curC] = false;
	}
	
	
	static boolean isIn(int r, int c) {
		return r > 0 && c > 0 && r <= H && c <= W;
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
			visited = new boolean[H + 1][W + 1]; // map[][]과 마찬가지로 0행 0열은 쓰지 않는다
			
			for (int i = 1; i <= H; i++) {
				String inputStr = in.readLine();
				for (int j = 1; j <= W; j++) {
					map[i][j] = inputStr.charAt(j);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
