import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_실버2_20006_랭킹전대기열 {

	static int  p, m; // p: 플레이어의 수, m: 방의 정원
	static List<Room> rooms = new ArrayList<>();
	
	static class Player implements Comparable<Player> {
		int level;
		String nickname;
		public Player(int level, String nickname) {
			super();
			this.level = level;
			this.nickname = nickname;
		}
		@Override
		public int compareTo(Player o) {
			return this.nickname.compareTo(o.nickname);
		}
	}
	
	static class Room {
		int minLevel;
		int maxLevel;
		List<Player> players;
		public Room(int minLevel, int maxLevel) {
			super();
			this.minLevel = minLevel;
			this.maxLevel = maxLevel;
			players = new ArrayList<>();
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 입력 받기
		String split [] = in.readLine().split(" ");
		p = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);
		
		StringTokenizer st;
		for (int i = 0 ; i < p; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int level = Integer.parseInt(st.nextToken());
			String nickname = st.nextToken();	
			entranceRoom(level, nickname); // 플레이어 입장 ~
		}
		
		// 방 정보 출력
		for (int i = 0; i < rooms.size(); i++) {
			Collections.sort(rooms.get(i).players); // 플레이어 사전순으로 오름차순 정렬
			if (rooms.get(i).players.size() != m) {
				sb.append("Waiting!\n");
			}
			else {
				sb.append("Started!\n");
			}
			for (int j = 0; j < rooms.get(i).players.size(); j++) {
				sb.append(rooms.get(i).players.get(j).level + " " + rooms.get(i).players.get(j).nickname + "\n");
			}
		}
		System.out.println(sb);
		
	} // end main()
	
	private static void entranceRoom(int level, String nickname) {
		
		// 들어갈 방 찾기
		boolean check = false;
		int i;
		for (i = 0; i < rooms.size(); i++) {
			Room room = rooms.get(i);
			if (room.minLevel <= level && level <= room.maxLevel && room.players.size() < m) {
				rooms.get(i).players.add(new Player(level, nickname));
				check = true;
				break;
			}
		}
		
		if (!check) { // 매칭이 가능한 방이 없다면
			makeRoom(level, nickname); // 새로운 방을 만들고 플레이어 입장
		}
		
	} // end entranceRoom()
	
	public static void makeRoom(int level, String nickname) {
		Room newRoom = new Room(level - 10, level + 10);
		newRoom.players.add(new Player(level, nickname));
		rooms.add(newRoom);
	} // end makeRoom()

}
