package psclass.basic.tree.binarytree.serialization;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import psclass.basic.tree.binarytree.TreeNode;
import psclass.basic.tree.binarytree.TreeUtil;

/**
 * This class is util class for Binary Tree serialiation and desrialization
 * 
 * @author rajesh
 * 
 */
public class SerDeser {
	
	/**
	 * Serializes the Binary Tree
	 * Approach : Pre-Order and Null Link based
	 * Time  : 
	 * Space : 
	 * @param root
	 * @return
	 */
	public static String serialize1(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		auxSerialize1(root, sb);
		return sb.toString();
	}
	
	private static void auxSerialize1(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("#,");
			return;
		}
		sb.append(root.value+",");
		auxSerialize1(root.left, sb);
		auxSerialize1(root.right, sb);
	}

	public static TreeNode deSerialize1(final String data) {
		Queue<String> queue = new LinkedList<String>();
		Collections.addAll(queue, data.split(","));
		return auxDeSerialize1(queue);
	}
	
	private static TreeNode auxDeSerialize1(Queue<String> queue) {
		String str = queue.remove();
		if (str.equals("#")) {
			return null;
		}
		TreeNode node = new TreeNode(Integer.parseInt(str));
		node.left = auxDeSerialize1(queue);
		node.right = auxDeSerialize1(queue);
		return node;
	}

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getBinaryTree();
		TreeUtil.display2(root);
		String serStr1 = serialize1(root);
		TreeUtil.display2(deSerialize1(serStr1));
	}
}