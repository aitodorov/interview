package org.ait.algorithms.tree;

public class TopView {

	static int xCoordMin = 0;
	static int xCoordMax = 0;
	public static void main(String[] args) {
		Node root = new Node(0);
		root.right = new Node(1);
		root.right.right = new Node(2);
		root.right.right.right = new Node(3);
		root.right.right.left = new Node(4);
		root.right.right.left.right = new Node(5);
		root.left = new Node(6);
		root.right.left = new Node(7);
		
		System.out.println(root);
		printTopView(root, 0);
	}
	
	static void printTopView(Node node, int xCoord) {
		if (node == null) {
			return;
		}
		
		if (xCoord > xCoordMax) {
			System.out.println(node);
			xCoordMax = xCoord;
		} else if (xCoord < xCoordMin) {
			System.out.println(node);
			xCoordMin = xCoord;			
		}
		printTopView(node.left, xCoord - 1);
		printTopView(node.right, xCoord + 1);
	}

}
