package psclass.basic.tree.binarytree;

public class TreeNodeCount {
	/**
	 * Adhoc strategy : Based on DFS(Depth First Search)
	 * Time  : O(n)
	 * Space : O(h)
	 * where h is height of the Tree
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
	
	public static void main(String[] args) {
		TreeNode root = TreeUtil.getBinaryTree();
		int count = findTreeNodeCount1(root);
		System.out.println(count);
	}
}
