package psclass.basic.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeCount {
	/**
	 * Adhoc strategy : Based on DFS(Depth First Search)
	 * Time  : O(n)
	 * Space : O(h)
	 * where h is height of the Tree
	 * Note that the space it takes is stack space not heap space
	 * @param root
	 * @return
	 */
	private static int findTreeNodeCount1(TreeNode root) {
		int count = 0;
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		count = findTreeNodeCount1(root.left) + findTreeNodeCount1(root.right) + 1;
		return count;
	}
	
	/**
	 * Using Level Order traversal(Using LinkedQueue which have O(1) for
	 * inserting and removing element at start and in the end respectively) 
	 * Time  : O(n) 
	 * Space : O(n) 
	 * * This is recommended way because we use Linked
	 * Queue and it gets stored in heap area and hence overhead of space is less
	 * compare to stack area(as we have seen in solution 1)
	 * 
	 * @param root
	 * @return
	 */
	private static int findTreeNodeCount2(TreeNode root) {
		TreeNode current = null;
		int nodeCount = 0;
		Queue<TreeNode> queue =  new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			current = queue.remove();
			nodeCount++;
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}
		return nodeCount;
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeUtil.getBinaryTree();
		int count = findTreeNodeCount1(root);
		System.out.println(count);
		count = findTreeNodeCount2(root);
		System.out.println(count);
	}
}
