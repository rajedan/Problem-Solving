package psclass.basic.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
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
	
	public static void display(TreeNode root) {
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
	
	public static void main(String[] args) {
		TreeNode root = getBinaryTree();
		display(root);
	}
}
