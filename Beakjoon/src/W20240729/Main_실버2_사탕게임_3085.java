package W20240729;

import java.util.*;
import java.io.*;

public class Main_실버2_사탕게임_3085 {
	
	static int N;
	static char candy [][];
	static int deltas [][] = {{0,1},{1,0}}; // 오른쪽, 아래
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		candy = new char[N][N];
		ans = 0;
		
		for (int i = 0; i < N; i++) {
			String input = in.readLine();
			for (int j = 0; j < N; j++) {
				candy[i][j] = input.charAt(j);
			}
		}
		
		// 최대 49*50*2*2500 = 12,250,000번 연산
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solve(i, j);
			}
		}
		
		// 답 출력
		System.out.println(ans);
	}
	
	public static void solve(int r, int c) {
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			// nr,nc 가 보드내 유효한 위치값인지 확인
			if (!isIn(nr, nc)) continue;
			
			char originCandyColor = candy[r][c];
			char targetCandyColor = candy[nr][nc];
			// r,c 칸에 있는 캔디와 nr,nc 칸에 있는 캔디의 색이 다르다면 색을 바꿔본다 
			if (originCandyColor != targetCandyColor) {
				candy[r][c] = targetCandyColor;
				candy[nr][nc] = originCandyColor;
				
				// 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)의 길이를 찾는다
				int mcn = findMaxConsecutiveNumberSubSequence();
				
				// 값을 비교하여 더 큰 값을 답으로 저장한다
				ans = Math.max(ans, mcn);
				
				// 캔디를 되돌려놓는다
				candy[r][c] = originCandyColor;
				candy[nr][nc] = targetCandyColor;
			}
		}
	}
	
	public static int findMaxConsecutiveNumberSubSequence() {
		int mcn  = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (int d = 0; d < deltas.length; d++) {
					int nr = r;
					int nc = c;
					int leng = 1;
					while (true) {						
						nr = deltas[d][0] + nr;
						nc = deltas[d][1] + nc;
						
						if (!isIn(nr, nc)) break;
						
						if (candy[r][c] == candy[nr][nc]) {
							leng++;
						}
						else {
							break;
						}
					}
					mcn = Math.max(mcn, leng);
				}
			}
		}
		return mcn;
	}
	
	public static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}