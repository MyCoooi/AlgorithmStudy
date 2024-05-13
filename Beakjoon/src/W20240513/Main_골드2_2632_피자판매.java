package W20240513;

import java.util.*;
import java.io.*;

public class Main_골드2_2632_피자판매 {
	
	static int pizzaSize, answer;
	static Pizza aPizza, bPizza;
	
	static class Pizza {
		int cnt; // 피자 조각의 개수
		Queue<Integer> pieceOfPizzaSize;
		public Pizza(int cnt) {
			this.cnt = cnt;
			pieceOfPizzaSize = new ArrayDeque<>();
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		pizzaSize = Integer.parseInt(in.readLine());
		
		String split [] = in.readLine().split(" ");
		aPizza = new Pizza(Integer.parseInt(split[0]));
		bPizza = new Pizza(Integer.parseInt(split[1]));
		answer = 0;
		
		for (int i = 0; i < aPizza.cnt; i++) {
			int size = Integer.parseInt(in.readLine());
			aPizza.pieceOfPizzaSize.offer(size);
		}
		for (int i = 0; i < bPizza.cnt; i++) {
			int size = Integer.parseInt(in.readLine());
			bPizza.pieceOfPizzaSize.offer(size);
		}
		
		System.out.println(answer);
	}
}
