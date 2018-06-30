package psclass.basic.tree.binarytree.assignment;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import psclass.basic.tree.binarytree.TreeNode;

/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 * description/ <br>
 * Given a non-empty special binary tree consisting of nodes with the
 * non-negative value, where each node in this tree has exactly two or zero
 * sub-node. If the node has two sub-nodes, then this node's value is the
 * smaller value among its two sub-nodes.
 * 
 * Given such a binary tree, you need to output the second minimum value in the
 * set made of all the nodes' value in the whole tree.
 * 
 * If no such second minimum value exists, output -1 instead.
 * 
 * @author rajesh
 * 
 */
public class SecondMinNodeInBtree {
	
	/**
	 * Naive Approach
	 * @param root
	 */
	private static int getSecondMinNode1(TreeNode root) {
		if (root == null) {
			return -1;
		}
		TreeNode current = null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		HashSet<Integer> set = new HashSet<Integer>();
		queue.add(root);
		while (!queue.isEmpty()) {
			current = queue.remove();
			set.add(current.value);
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}
		return set.size() > 1 ? (Integer)set.toArray()[1] : -1;
	}
	
	private static TreeNode createTree() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		return root;
	}
	
	public static void main(String[] args) {
		System.out.println(getSecondMinNode1(createTree()));
	}
}
