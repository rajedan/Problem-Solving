package psclass.basic.tree.binarytree;

/**
 * Represents a Binary Tree Node
 * @author rajesh
 *
 */
public class TreeNode {
	public Integer value;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode() {}
	
	public TreeNode(Integer value) {
		this.value = value;
	}
	TreeNode(Integer value, TreeNode left, TreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
}
