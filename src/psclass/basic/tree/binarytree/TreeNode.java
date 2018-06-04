package psclass.basic.tree.binarytree;

public class TreeNode {
	Integer value;
	TreeNode left;
	TreeNode right;
	
	TreeNode() {}
	
	TreeNode(Integer value) {
		this.value = value;
	}
	TreeNode(Integer value, TreeNode left, TreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
}
