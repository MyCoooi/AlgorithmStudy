package W202409;

import java.io.*;
import java.util.*;

public class Main_골드_강의실_1374 {
	
	static int N;
	static Time times [];
	
	static class Time implements Comparable<Time> {
		int startTime, endTime;
		
		public Time(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(Time o) {
			if (this.endTime == o.endTime) {
				return Integer.compare(this.startTime, o.startTime);
			}
			else {
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
			 
			 int number = Integer.parseInt(split[0]);
			 int startTime = Integer.parseInt(split[1]);
			 int endTime = Integer.parseInt(split[2]);
			 
			 times[number - 1] = new Time(startTime, endTime);
		 }
		 
		 Arrays.sort(times);
		 
		 printTimes();
	}
	
	public static void printTimes() {
		for (int i = 0; i < N; i++) {
			System.out.println(times[i].startTime + "," + times[i].endTime);;
		}
	}
}
