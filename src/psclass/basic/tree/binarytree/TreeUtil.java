package psclass.basic.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
	private enum NodeType {
		ROOT("Root"), LEFT("L"), RIGHT("R");
		private final String type;

		NodeType(String type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return type;
		}
		
		public String value() {
			return type;
		}
	}
	public static TreeNode getBinaryTree() {
		TreeNode root = new TreeNode(1);
		TreeNode tmp = root;
		tmp.left = new TreeNode(2);
		tmp.right = new TreeNode(3);
		tmp.left.left = new TreeNode(4);
		tmp.left.right = new TreeNode(5);
		tmp.right.left = new TreeNode(6);
		tmp.right.right = new TreeNode(7);
		return root;
	}
	
	public static void display1(TreeNode root) {
		if (root == null) {
			System.out.println("null");
			return;
		}
		TreeNode current = root;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			current = queue.remove();
			System.out.print(current.value);
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}
	}
	
	/**
	 * Displays the Binary Tree with proper depth
	 */
	public static void display2(TreeNode root) {
		if (root == null) {
			System.out.println("No Node Found to Print!");
			return;
		}
		auxDisplay(root, 0, NodeType.ROOT.value());
		//int noOfSpace = 3;
		//System.out.println(root.value+"("+NodeType.ROOT.name()+")");
		//auxDisplay(root.left, noOfSpace, "L");
		//auxDisplay(root.right, noOfSpace, "R");
	}
	
	private static void auxDisplay(TreeNode node, int noOfSpace, String nodeType) {
		if (node == null) {
			return;
		}
		for (int i = 0; i < noOfSpace; i++) {
			System.out.print(" ");
		}
		System.out.println(node.value+"("+nodeType+")");
		auxDisplay(node.left, noOfSpace+3, NodeType.LEFT.value());
		auxDisplay(node.right, noOfSpace+3, NodeType.RIGHT.value());
	}

	public static void main(String[] args) {
		TreeNode root = getBinaryTree();
		//display1(root);
		display2(root);
	}
}
