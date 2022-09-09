package lcode.random.ps;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	int val;
	Node left, right;

	Node(int value) {
		val = value;
	}
}

public class zigzag {

	/**
	 * Time: O(N), Each node is visited once.
	 * Space: O(N), Need approx N/2 space to store nodes while iteration.
	 *
	 * @param root
	 */
	public static void zigzagTraversal(Node root) {
		Stack<Node> s1Bucket = new Stack<Node>();
		Stack<Node> s2Bucket = new Stack<Node>();
		s1Bucket.push(root);
		boolean l2r = false;

		while (!s1Bucket.empty()) {
			Node node = s1Bucket.pop();
			System.out.print(node.val + ", ");

			if (l2r) {
				if (node.left != null)
					s2Bucket.push(node.left);
				if (node.right != null)
					s2Bucket.push(node.right);
			} else {
				if (node.right != null)
					s2Bucket.push(node.right);
				if (node.left != null)
					s2Bucket.push(node.left);
			}
			if (s1Bucket.empty()) {
				s1Bucket = s2Bucket;
				s2Bucket = new Stack<Node>();
				l2r = !l2r;
			}
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);

		zigzagTraversal(root);
	}
	//sort a linked list without space- without space- n space and nlogn time, bubble sort time is high. do it with merge sort.
	//find peak element from a list(AL)
	//repeated files in a linux file system
}
