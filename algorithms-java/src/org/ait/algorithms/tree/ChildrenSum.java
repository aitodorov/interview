package org.ait.algorithms.tree;

public class ChildrenSum {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(2);
		root.left.right = new Node(2);
		root.left.left = new Node(1);
		root.right.right = new Node(2);
		//root.right.left = new Node(1);
				
		System.out.println(isChildrenSum(root, true));
	}
	
	private static boolean isChildrenSum(Node node, boolean isRoot) {
		if (node == null) {
			return !isRoot;
		}
		
		if (node.left == null && node.right == null) {
			return true;
		}
		
		if (getValue(node.left) + getValue(node.right) != node.value) {
			return false;			
		}
		
		return isChildrenSum(node.left, false) && isChildrenSum(node.right, false);		
	}
	
	private static int getValue(Node n) {
		return n == null ? 0 : n.value;
	}

}
