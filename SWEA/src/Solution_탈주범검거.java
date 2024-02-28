import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// dfs로 풀면 이미 방문한 곳의 time값이 제일 적은 게 아닐 수 있으므로
// 이미 방문한 곳이라 하더라도 다시 탐색해야 한다.
// 따라서 시간초과가 난다..
// bfs로 풀기!!
public class Solution_탈주범검거 {
	static final int FOURWAYS = 1;
	static final int UP_DOWN = 2;
	static final int LEFT_RIGHT = 3;
	static final int UP_RIGHT = 4;
	static final int DOWN_RIGHT = 5;
	static final int DOWN_LEFT = 6;
	static final int UP_LEFT = 7;
	
	static int N, M; // N: 지하 터널 지도의 세로 크기, M: 가로 크기
	static int R, C; // R: 맨홀 뚜껑이 위치한 세로 위치, C: 맨홀 뚜껑이 위치한 가로 위치
	static int L; // L: 탈출 후 소요된 시간
	static int map [][];
	static boolean visited [][];
	
	static class Position {
		int r, c;
		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			
			// 입력 받기
			String split [] = in.readLine().split(" ");
			N = Integer.parseInt(split[0]);
			M = Integer.parseInt(split[1]);
			R = Integer.parseInt(split[2]);
			C = Integer.parseInt(split[3]);
			L = Integer.parseInt(split[4]);
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				split = in.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(split[j]);
				}
			}
			
			bfs(new Position(R, C));
			System.out.println("#" + testCase + " " + count());
		} // end testCase iter
	} // end main()
	
	public static void bfs(Position start) {
		Queue<Position> q = new ArrayDeque<>();
		
		q.offer(start);
		visited[start.r][start.c] = true;
		int time = 1;
		while (time <= L && !q.isEmpty()) {
			
			int size = q.size();
			
			while (size > 0) {
				Position cur = q.poll();
				
				// 시간이 L만큼 경과했으면 탐색 끝!(그 다음 노드의 시간은 L + 1일 것이므로)
				if (time == L) return;
				
				// 연결된(갈 수 있는) 노드 큐에 삽입
				int deltas [][] = {{-1,0},{1,0},{0,-1},{0,1}}; // 상, 하, 좌, 우
				
				for (int d = 0; d < 4; d++) {
					int nr = cur.r + deltas[d][0];
					int nc = cur.c + deltas[d][1];
					
					if (!isIn(nr, nc) || map[nr][nc] == 0 || visited[nr][nc]) continue;
					
					if (d == 0 && (map[cur.r][cur.c] == FOURWAYS || map[cur.r][cur.c] == UP_DOWN
							|| map[cur.r][cur.c] == UP_LEFT || map[cur.r][cur.c] == UP_RIGHT)) { // 상
						if (canGo_up(nr, nc)) {
							q.offer(new Position(nr, nc));
							visited[nr][nc] = true;
						}
					}
					if (d == 1 && (map[cur.r][cur.c] == FOURWAYS || map[cur.r][cur.c] == UP_DOWN
							|| map[cur.r][cur.c] == DOWN_LEFT || map[cur.r][cur.c] == DOWN_RIGHT)) { // 하
						if (canGo_down(nr, nc)) {
							q.offer(new Position(nr, nc));
							visited[nr][nc] = true;
						}
					}
					if (d == 2 && (map[cur.r][cur.c] == FOURWAYS || map[cur.r][cur.c] == LEFT_RIGHT
							|| map[cur.r][cur.c] == DOWN_LEFT || map[cur.r][cur.c] == UP_LEFT)) { // 좌
						if (canGo_left(nr, nc)) {
							q.offer(new Position(nr, nc));
							visited[nr][nc] = true;
						}
					}
					if (d == 3 && (map[cur.r][cur.c] == FOURWAYS || map[cur.r][cur.c] == LEFT_RIGHT
							|| map[cur.r][cur.c] == DOWN_RIGHT || map[cur.r][cur.c] == UP_RIGHT)) { // 우
						if (canGo_right(nr, nc)) {
							q.offer(new Position(nr, nc));
							visited[nr][nc] = true;
						}
					}
				} // end for()
				size--;
			} // end while()
			time++;
		} // end while ()
	} // end bfs()
	
	public static boolean canGo_right(int nr, int nc) {
		if (map[nr][nc] == LEFT_RIGHT || map[nr][nc] == DOWN_LEFT
				|| map[nr][nc] == UP_LEFT || map[nr][nc] == FOURWAYS) return true;
		return false;
	} // end canGo_right();
	
	public static boolean canGo_left(int nr, int nc) {
		if (map[nr][nc] == LEFT_RIGHT || map[nr][nc] == DOWN_RIGHT
				|| map[nr][nc] == UP_RIGHT || map[nr][nc] == FOURWAYS) return true;
		return false;
	} // end canGo_left()
	
	public static boolean canGo_up(int nr, int nc) {
		if (map[nr][nc] == UP_DOWN || map[nr][nc] == DOWN_RIGHT
				|| map[nr][nc] == DOWN_LEFT || map[nr][nc] == FOURWAYS) return true;
		return false;
	} // end canGo_up()
	
	public static boolean canGo_down(int nr, int nc) {
		if (map[nr][nc] == UP_DOWN || map[nr][nc] == UP_RIGHT
				|| map[nr][nc] == UP_LEFT || map[nr][nc] == FOURWAYS) return true;
		return false;
	} // end canGo_down()
	
	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	} // end isIn()
	
	public static int count() {
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j]) {
					res++;
				}
			}
		}
		return res;
	} // end count()
	
	
	
}
