package org.ait.algorithms.tree;

public class LeftView {

	static int maxDepth = -1;
	
	public static void main(String[] args) {	
		Node root = new Node(0);
		root.right = new Node(1);
		root.right.right = new Node(2);
		root.right.right.right = new Node(3);
		root.right.right.left = new Node(4);
		root.right.right.left.right = new Node(5);
		root.left = new Node(6);
		root.right.left = new Node(7);
		
		printLeftView(root, 0);
	}
	
	static void printLeftView(Node node, int depth) {
		if (node == null) {
			return;
		}
		
		if (depth > maxDepth) {
			System.out.println(node);
			maxDepth = depth;
		}
		
		printLeftView(node.left, depth + 1);
		printLeftView(node.right, depth + 1);
		
	}

}
