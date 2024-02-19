import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 미해결
public class Main_실버2_20006_랭킹전대기열 {

	static int p, m; // p: 플레이어의 수, m: 방의 정원
	static int error = 10; // 오차 -10 ~ +10
	static List<Room> rooms = new ArrayList<>();
	static int room_priority = 0;

	static class Player {
		int level;
		String nickname;
		public Player(int level, String nickname) {
			super();
			this.level = level;
			this.nickname = nickname;
		}
	}
	
	static class Room implements Comparable<Room>{
		int capacity;
		int minLevel;
		int maxLevel;
		int priority;
		public Room(int minLevel, int maxLevel) {
			super();
			this.capacity = 0;
			this.minLevel = minLevel;
			this.maxLevel = maxLevel;
		}
		@Override
		public int compareTo(Room o) {
			if (this.minLevel == o.minLevel) {
				if (this.maxLevel == o.maxLevel) return this.priority - o.priority;
				return this.maxLevel - o.maxLevel;
			}
			return this.minLevel - o.minLevel;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 받기
		String split [] = in.readLine().split(" ");
		p = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);
		
		for (int i = 0; i < p; i++) {
			split = in.readLine().split(" ");
			entrance(new Player(Integer.parseInt(split[0]), split[1]));
		}
		
	}
	
	public static void entrance(Player player) {
		binarySearchRoom(player.level); // 들어갈 방 찾기
	}
	
	public static int binarySearchRoom(int level) {
		int start = 0;
		int end = rooms.size() - 1;
		
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			
			i
		}
	}
}
