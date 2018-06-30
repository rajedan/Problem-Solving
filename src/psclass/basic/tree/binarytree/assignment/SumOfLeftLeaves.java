package psclass.basic.tree.binarytree.assignment;

import java.util.LinkedList;
import java.util.Queue;

import psclass.basic.tree.binarytree.TreeNode;
import psclass.basic.util.MyInteger;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 * <br>
 * Find the sum of all left leaves in a given binary tree.
 * 
 * @author rajesh
 *
 */
public class SumOfLeftLeaves {
	public static int sumOfLeftLeaves1(TreeNode root) {
		MyInteger count = new MyInteger(0);
		auxSumOfLeftLeaves(root, count);
        return count.getValue();
    }

	/**
	 * Auxiliary method to count sum of all left leaves value
	 * @param root
	 * @param count
	 */
	private static void auxSumOfLeftLeaves(TreeNode root, MyInteger count) {
		if (root == null) {
			return;
		}
		if (root.left != null && root.left.left == null && root.left.right == null) {
			count.setValue(count.getValue() + root.left.value);
		} else {
			auxSumOfLeftLeaves(root.left, count);
		}
		if (root.right == null) {
			return;
		} else {
			auxSumOfLeftLeaves(root.right, count);
		}
	}
	
	public static void test(MyInteger count) {
		count.setValue(2);
	}

	private static TreeNode createBinaryTree() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		return root;
	}
	
	/**
	 * Without Recursion
	 * @param root
	 * @return
	 */
	public static int sumOfLeftLeaves2(TreeNode root) {
		int count = 0;
		if (root == null) {
			return count;
		}
		if (root.left == null && root.right == null) {
			return count;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.remove();
			if (node.left != null && node.left.left == null && node.left.right == null) {
				count += node.left.value;
			}
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
		}
		return count;
    }
	
	public static void main(String[] args) {
		int count = sumOfLeftLeaves1(createBinaryTree());
		System.out.println(count);
		count = sumOfLeftLeaves2(createBinaryTree());
		System.out.println(count);
	}
}
