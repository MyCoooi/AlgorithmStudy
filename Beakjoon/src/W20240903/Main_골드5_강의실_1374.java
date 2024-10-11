package W20240903;

import java.io.*;
import java.util.*;

import javax.naming.ldap.StartTlsRequest;

public class Main_골드5_강의실_1374 {

	static int N;
	static Time [] times;
	static int [] maxEndTimePerClass;
	
	static class Time implements Comparable<Time> {
		int startTime;
		int endTime;
		
		Time(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(Time o) {
			if (this.endTime == o.endTime) {
				return Integer.compare(this.startTime, o.startTime);
			} else {
				return Integer.compare(this.endTime, o.endTime);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		times = new Time[N];

		for (int i = 0; i < N; i++) {
			String split [] = in.readLine().split(" ");
			int num = Integer.parseInt(split[0]);
			int startTime = Integer.parseInt(split[1]);
			int endTime = Integer.parseInt(split[2]);
			
			times[num - 1] = new Time(startTime, endTime);
		}
		
		// 종료 시간이 빠른 순서대로 정렬
		Arrays.sort(times);
		
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			int curEndTime = times[i].endTime;
			int curStartTime = times[i].startTime;
			if (q.isEmpty()) {
				q.addFirst(curEndTime);
			} else {
				if (q.getFirst() <= curStartTime) {
					q.addLast(curEndTime);
					q.pollFirst();
				} else {
					q.addLast(curEndTime);
				}
			}
		}
		
		// 답 출력
		System.out.println(q.size());
	}
}
