package W20240326;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_실버1_16194_카드구매하기2 {
	
	static int N; // 구매하려고 하는 카드 개수
	static int [] price; // 각 카드팩의 가격

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		price = new int[N + 1]; // 인덱스 0은 쓰지 않는다(카드는 1개부터 존재하므로)
		
		String split [] = in.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			price[i] = Integer.parseInt(split[i]);
		}
		
		
		
	}
}
