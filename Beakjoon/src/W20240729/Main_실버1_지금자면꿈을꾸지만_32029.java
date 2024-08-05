package W20240729;

import java.io.*;
import java.util.*;

public class Main_실버1_지금자면꿈을꾸지만_32029 {

	static int N, A, B;
	static int deadline [];
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split [] = in.readLine().split(" ");
		N = Integer.parseInt(split[0]); // 과제의 개수
		A = Integer.parseInt(split[1]); // 과제 수행 시간
		B = Integer.parseInt(split[2]); // 잠 잘 수 있는 시간 = B * X
		deadline = new int[N];
		ans = 0;
		
		split = in.readLine().split(" ");
		for (int n = 0; n < N; n++) {
			deadline[n] = Integer.parseInt(split[n]);
		}
		
		// 오름차순 정렬
		Arrays.sort(deadline);
		
		for (int X = 0; X <= A - 1; X++) {
			// 잠을 B*X만큼 잤을 때 해결할 수 있는 최대 과제 수
			int num = calculateMaxNum(X);
			ans = Math.max(ans, num);
		}
		System.out.println(ans);
	}
	
	public static int calculateMaxNum(int X) {
		int sleepTime = B * X; // 잠자는 시간
		int implTime = A; // 과제 수행 시간
		int maxDoneAssignmentNum = 0;
		
		// 언제 잠을 자야할까? 잠을 자는 동안 만료되는 과제가 최소이면서 최대한 빨리 잘 수 있을 때 자야한다.
		for (int whenSleep = 0; whenSleep < N; whenSleep++) {
			int doneAssignmentNum = 0;
			int time = 0;
			int tmpImplTime = implTime;
			boolean isDone [] = new boolean[N];
			
			int num = 0;
			while (true) {
				if (num == whenSleep) {
					time += sleepTime;
					tmpImplTime -= X;
				}
				
				time += tmpImplTime;
				
				boolean check = false;
				for (int n = 0; n < N; n++) {
					if (isDone[n]) continue;
					
					if (deadline[n] >= time) {
						doneAssignmentNum++;
						isDone[n] = true;
						check = true;
						break;
					}
					else continue;
				}
				if (!check) break;
				num++;
			}
			
			maxDoneAssignmentNum = Math.max(maxDoneAssignmentNum, doneAssignmentNum);
			
			if (X == 0) {
				break;
			}
		}
		
		return maxDoneAssignmentNum;
	}

}
