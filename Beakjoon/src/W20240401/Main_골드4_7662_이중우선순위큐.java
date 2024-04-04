package W20240401;

import java.util.*;
import java.io.*;

/*
 * <주의>
 * 1. 동일한 정수가 삽입될 수 있다!!!
 * 2. 삭제 연산에서 최댓값(최솟값)이 둘 이상인 경우, 하나만 삭제
 * 3. 큐가 비어있을 때, D 연산을 하면 무시
 */
public class Main_골드4_7662_이중우선순위큐 {
	
	static final int MAXVALUE = 1;
	static final int MINVALUE = -1;
	
	static int K; // 연산의 개수
	
	static class Tree {
		Node root, min, max;
		// get
		public Integer getMin() {
			if (min == null) return null;
			return min.value;
		}
		public Integer getMax() {
			if (max == null) return null;
			return max.value;
		}
		// delete
		public void deleteMin() {	
			if (min.cnt > 1) min.cnt -= 1;
			else {
				if (min == max) min = max = null;
				Node parent = min.rightParent;
				parent.left = min.right;
			}
		}
		public void deleteMax() {
			if (max.cnt > 1) max.cnt -= 1;
			else {
				if (min == max) min = max = null;
				Node parent = max.leftParent;
				parent.right = max.left;
				
			}
		}
		// insert
		public void insert(int value) {
			if (this.isEmpty()) {
				root = new Node(value);
				min = root;
				max = root;
				return;
			}
			
			Node target = root;
			while(true) {
				if (target.value == value) {
					target.cnt += 1;
					return;
				}
				else if (target.value < value) {
					if (target.right == null) {
						target.right = new Node(value);
						target.right.leftParent = target;
						if (max == target) max = target.right;
						return;
					}
					else target = target.right;
				}
				else { // value < target.value 
					if (target.left == null) {
						target.left = new Node(value);
						target.left.rightParent = target;
						if (min == target) min = target.left;
						return;
					}
					else target = target.left;
				}
			}
		}
		// isEmpty
		public boolean isEmpty() {
			return root == null;
		}
	}
	
	static class Node {
		Node left, right, leftParent, rightParent;
		int value, cnt; // cnt: 동일 정수가 삽입될 때 +1
		public Node(int value) {
			super();
			this.value = value;
			this.cnt = 1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(in.readLine());
			
			Tree doubleQ = new Tree();
			
			for (int i = 0; i < K; i++) {
				String split [] = in.readLine().split(" ");
				char cmd = split[0].charAt(0); // 어떤 연산인지?
				int n = Integer.parseInt(split[1]); // 연산의 타겟값
				
				if (cmd == 'I') doubleQ.insert(n);
				else if (cmd == 'D' && n == MAXVALUE) doubleQ.deleteMax();
				else doubleQ.deleteMin();
			}
			
			Integer min = doubleQ.getMin();
			Integer max = doubleQ.getMax();
			if (min == null && max == null) sb.append("EMPTY\n");
			else sb.append(max + " " + min + "\n");
		}
		System.out.print(sb);
	}
	
}
