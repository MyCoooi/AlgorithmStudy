package A형기출;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main_실버1_9934_완전이진트리 {
	
	static int K, nodeNum;
	static Stack<Node> stack = new Stack<>();
	static Node root;
	static int visitedBuildingArr [];
	
	static class Node {
		int buildingN;
		Node left;
		Node right;
		public Node(int buildingN) {
			super();
			this.buildingN = buildingN;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 받기
		K = Integer.parseInt(in.readLine());
		nodeNum = (int)Math.pow(2, K) - 1; // 노드의 갯수
		visitedBuildingArr = new int[nodeNum];
				
		String split [] = in.readLine().split(" ");
		for (int i = 0; i < nodeNum; i++) {
			int visitedBuilding = Integer.parseInt(split[i]);
			visitedBuildingArr[i] = visitedBuilding;
		}
		
		// 완전 이진 트리 생성
		root = makeTree(0, nodeNum - 1);
		
		// 출력
		bfs(root);
		
	}
	
	static void bfs(Node root) {
		
		Queue<Node> q = new ArrayDeque<>();
		
		q.offer(root);
		while (!q.isEmpty()) {
			
			int size = q.size();
			
			while (size != 0) {
				Node cur = q.poll();
				
				System.out.print(cur.buildingN + " ");
				
				if (cur.left != null) q.offer(cur.left);
				if (cur.right != null) q.offer(cur.right);
				size--;
			}
			
			System.out.println();
		}
	}
	
	static Node makeTree(int startIdx, int endIdx) {
		int rootIdx = (startIdx + endIdx) / 2;
		Node head;
		
		if (startIdx == endIdx) {
			head =  new Node(visitedBuildingArr[rootIdx]);
		}
		else if (endIdx - startIdx == 1) {
			head = new Node(visitedBuildingArr[rootIdx]);
			head.left = new Node(visitedBuildingArr[rootIdx - 1]);
		}
		else if (endIdx - startIdx == 2) {
			head = new Node(visitedBuildingArr[rootIdx]);
			head.left = new Node(visitedBuildingArr[rootIdx - 1]);
			head.right = new Node(visitedBuildingArr[rootIdx + 1]);
		}
		else {
			head = new Node(visitedBuildingArr[rootIdx]);
			head.left = makeTree(startIdx, rootIdx - 1);
			head.right = makeTree(rootIdx + 1, endIdx);
		}
		
		return head;
	}
}
