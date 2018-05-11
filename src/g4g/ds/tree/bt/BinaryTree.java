package g4g.ds.tree.bt;


/**
 * Represents a Binary Tree Node
 * @author rajesh
 *
 */
class Node {
	int key;
	Node left;
	Node right;
	
	Node(int key){
		this.key = key;
	}
}

public class BinaryTree {
	
	private Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	BinaryTree(int key) {
		root = new Node(key);
	}
	@Override
	public String toString() {
		return super.toString();
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		
	}
}
