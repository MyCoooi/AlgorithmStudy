package W20240506;

import java.io.*;
import java.util.*;

public class Solution_D5_7753_오나의여신님 {
	
	static final char SUYEON = 'S';
	static final char GOD = 'D';
	static final char STONE = 'X';
	static final char DEVIL = '*';
	static final char GROUND = '.';
	
	static int N, M;
	static char [][] map;
	static int deltas [][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static Queue<Position> devilHandQ, suyeonQ;
	static boolean [][] devilHandVisited, suyeonVisited;
	
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
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String split [] = in.readLine().split(" ");
			
			N = Integer.parseInt(split[0]); // 지도의 세로 길이
			M = Integer.parseInt(split[1]); // 지도의 가로 길이
			devilHandQ = new ArrayDeque<>();
			devilHandVisited = new boolean[N][M];
			suyeonQ = new ArrayDeque<>();
			suyeonVisited = new boolean[N][M];
			map = new char[N][M];
			
			for (int i = 0; i < N; i++) {
				String input = in.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = input.charAt(j);
					
					// 수연이와 악마의 손아귀 위치 저장
					if (map[i][j] == SUYEON) {
						suyeonQ.offer(new Position(i, j));
						suyeonVisited[i][j] = true;
						map[i][j] = GROUND; // 수연이의 위치는 suyeonQ로 따로 관리하므로 map에 수연이의 위치를 표시할 필요 x
					}
					else if (map[i][j] == DEVIL) {
						devilHandQ.offer(new Position(i, j));
						devilHandVisited[i][j] = true;
					}
				}
			}
			
			int answer = solve();
			if (answer == -1) sb.append("#" + tc + " " + "GAME OVER" + "\n");
			else sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb);
	}
	
	static int solve() {
		int time = -1;
		
		while(true) {
			time++;
			
			devilHandInvoke(); // 악마의 손아귀 스킬 발동
			
			// 수연이가 1초 후 이동할 수 있는 곳 저장
			int size = suyeonQ.size();
			while(size != 0) {
				Position cur = suyeonQ.poll();
				
				for (int d = 0; d < deltas.length; d++) {
					int nr = deltas[d][0] + cur.r;
					int nc = deltas[d][1] + cur.c;
					
					if (!isIn(nr, nc) || suyeonVisited[nr][nc]) continue;
					
					if (map[nr][nc] == GOD) { // 여신에게 갈 수 있으면 시간 반환 후 종료
						time++;
						return time;
					}
					
					if (map[nr][nc] != DEVIL && map[nr][nc] != STONE) {
						suyeonQ.offer(new Position(nr, nc));
						suyeonVisited[nr][nc] = true;
					}
				}
				
				size--;
			}
			
			if (suyeonQ.isEmpty()) return -1; // 수연이가 여신에게 갈 수 없으므로 -1 반환
		}
	}
	
	static void devilHandInvoke() {
		int size = devilHandQ.size();
		while(size != 0) {
			Position cur = devilHandQ.poll();
			
			for (int d = 0; d < deltas.length; d++) {
				int nr = deltas[d][0] + cur.r;
				int nc = deltas[d][1] + cur.c;
				
				if (!isIn(nr, nc) || devilHandVisited[nr][nc]) continue;
				
				if (map[nr][nc] != STONE && map[nr][nc] != GOD) {
					map[nr][nc] =  DEVIL;
					devilHandQ.offer(new Position(nr, nc));
					devilHandVisited[nr][nc] = true;
				}
			}
			size--;
		}
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
	
	static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
