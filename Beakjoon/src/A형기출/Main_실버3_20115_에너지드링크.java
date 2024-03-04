package A형기출;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_실버3_20115_에너지드링크 {

	static int N; // 에너지 드링크의 수
	static double drinks [];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 받기
		N = Integer.parseInt(in.readLine());
		String split [] = in.readLine().split(" ");
		drinks = new double[N];
		for (int i = 0; i < N; i++) drinks[i] = Integer.parseInt(split[i]);
		
		Arrays.sort(drinks); // 오름차순 정렬 O(NlogN)
		
		// 최대로 만들 수 있는 드링크의 양 계산
		// 전략: 양이 최대인 드링크에 각 드링크 양의 1/2을 모두 붓는다
		int maxDrinkIdx = N - 1;
		for (int i = 0; i < N - 1; i++) {
			drinks[maxDrinkIdx] += 0.5 * drinks[i];
		}
		
		System.out.println(drinks[maxDrinkIdx]);
	}
}
