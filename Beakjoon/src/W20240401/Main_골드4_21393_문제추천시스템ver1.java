package W20240401;

import java.io.*;
import java.util.*;

public class Main_골드4_21393_문제추천시스템ver1 {

	static int N, P;
	
	static class DoubleQ {
		PriorityQueue<int []> min;
		PriorityQueue<int []> max;
		HashMap<Integer, Integer> map = new HashMap<>();
		public DoubleQ() {
			min = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					int level1 = map.get(o1);
					int level2 = map.get(o2);
					if (level1 == level2) return Integer.compare(o1, o2);
					return Integer.compare(level1, level2);
				}
			});
			max = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					int level1 = map.get(o1);
					int level2 = map.get(o2);
					if (level1 == level2) return Integer.compare(o2, o1);
					return Integer.compare(level2, level1);
				}
			});
			map = new HashMap<>();
		}
		
		public void insert(int pNum) {
			min.offer(pNum);
			max.offer(pNum);
		}
		
		public void remove(int pNum) {
			map.replace(pNum, 0);
		}
		
		public int getHard() {
			while(!max.isEmpty() && map.get(max.peek()) == 0) {
				max.poll();
			}
			return max.peek();
		}
		
		public int getEasy() {
			while(!min.isEmpty() && map.get(min.peek()) == 0) {
				min.poll();
			}
			return min.peek();
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		
		DoubleQ doubleQ = new DoubleQ();
		
		for (int i = 0; i < N; i++) {
			String split [] = in.readLine().split(" ");
			int pNum = Integer.parseInt(split[0]);
			map.put(pNum, Integer.parseInt(split[1]));
			doubleQ.insert(pNum);
		}
		
		P = Integer.parseInt(in.readLine());
		for (int i = 0; i < P; i++) {
			String split [] = in.readLine().split(" ");
			String cmd = split[0];
			if ("recommend".equals(cmd)) {
				char x = split[1].charAt(0);
				if (x == '1') sb.append(doubleQ.getHard() + "\n");
				else sb.append(doubleQ.getEasy() + "\n");
			}
			else if ("add".equals(cmd)) {
				int pNum = Integer.parseInt(split[1]);
				map.put(pNum, Integer.parseInt(split[2]));
				doubleQ.insert(pNum);
			}
			else if ("solved".equals(cmd)) {
				int pNum = Integer.parseInt(split[1]);
				doubleQ.remove(pNum);
			}
		}
		System.out.println(sb);
	}
}
