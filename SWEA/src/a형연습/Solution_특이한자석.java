package a형연습;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_특이한자석 {
	static final int COUNT = 4;
	static final int TOOTH = 8;
	static final int CLOCKWISE = 1;
	static final int COUNTERCLOCKWISE = -1;
	static final int N = 0;
	static final int S = 1;
	
	static int K; // K: 자식을 회전시키는 수
	static int gearArr [][];
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		int T = Integer.parseInt(in.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			
			// 입력 받기
			
			K = Integer.parseInt(in.readLine());
			
			gearArr = new int[COUNT + 1][TOOTH]; // gearArr[0]은 쓰지 않는다
			
			for (int i = 1; i <= COUNT; i++) {
				String split [] = in.readLine().split(" ");
				for (int j = 0; j < TOOTH; j++) {
					gearArr[i][j] = Integer.parseInt(split[j]);
				}
			}
			
			for (int i = 0; i < K; i++) {
				String split [] = in.readLine().split(" ");
				
				int num = Integer.parseInt(split[0]); // 회전시키려는 자석의 번호
				int direction = Integer.parseInt(split[1]); // 회전 방향
				
				// 맞닿아있는 자석 부분의 자성이 같은지확인
				boolean isSame [] = new boolean[COUNT - 1];
				
				for (int j = 1; j < COUNT; j++) {
					isSame[j - 1] = gearArr[j][2] == gearArr[j + 1][6];
				}
				
				// num번 톱니바퀴 회전
				if (direction == CLOCKWISE) {
					rotate_clockwise(num);
				}
				else {
					rotate_counterclockwise(num);
				}
				
				// 그 외 톱니바퀴 회전
				all_rotate(isSame, num, direction);
				
//				System.out.println(Arrays.toString(isSame));
//				System.out.println(Arrays.toString(gearArr[1]));
//				System.out.println(Arrays.toString(gearArr[2]));
//				System.out.println(Arrays.toString(gearArr[3]));
//				System.out.println(Arrays.toString(gearArr[4]));
//				System.out.println("-----------------");

			} // end for
			
			// 점수 계산
			ans = calcScore();
			// 출력
			System.out.println("#" + testCase + " " + ans);
			
		} // end testCase iter
	} // end main()
	
	public static int calcScore() {
		int res = 0;
		
		if (gearArr[1][0] == N);
		else res += 1;
		
		if (gearArr[2][0] == N);
		else res += 2;
		
		if (gearArr[3][0] == N);
		else res += 4;
		
		if (gearArr[4][0] == N);
		else res += 8;
		
		return res;
	}
	
	public static void all_rotate(boolean isSame [], int num, int direction) {
		
		int tmpDirection = direction;
		
		for (int i = num - 1; i >= 1; i--) {
			if (i - 1 >= 3 || isSame[i - 1]) break;
			
			tmpDirection *= -1;
			if (tmpDirection == CLOCKWISE) rotate_clockwise(i);
			else rotate_counterclockwise(i);

		}
		
		tmpDirection = direction;
		
		for (int i = num + 1; i <= COUNT; i++) {
			if (i - 2 >= 3 || isSame[i - 2]) break;
			tmpDirection *= -1;
			if (tmpDirection == CLOCKWISE) rotate_clockwise(i);
			else rotate_counterclockwise(i);
		}
		
	} // end all_rotate()
	
	public static void rotate_clockwise(int num) {
//		System.out.println(num + "톱니바퀴 시계방향 회전");
		
		int lastIdx = TOOTH - 1;
		
		int tmp = gearArr[num][lastIdx];
		for (int i = lastIdx - 1; i >= 0; i--) {
			gearArr[num][i+1] = gearArr[num][i];
		}
		gearArr[num][0] = tmp;
		
	} // end clockwise()
	
	public static void rotate_counterclockwise(int num) {
//		System.out.println(num + "톱니바퀴 반시계방향 회전");
		int lastIdx = TOOTH - 1;
		
		int tmp = gearArr[num][0];
		for (int i = 1; i <= lastIdx; i++) {
			gearArr[num][i-1] = gearArr[num][i];
		}
		gearArr[num][lastIdx] = tmp;
		
	} // end  rotate_counterclockwise()
	
}
