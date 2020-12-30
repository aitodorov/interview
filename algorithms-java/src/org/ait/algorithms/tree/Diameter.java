package org.ait.algorithms.tree;

public class Diameter {

	public static void main(String[] args) {
		Node root = new Node(0);
		
		root.left = new Node(1);
		root.right = new Node(2);
		
		root.right.left = new Node(3);
		root.right.right = new Node(4);
		
		root.right.left.left = new Node(5);
		root.right.left.right = new Node(6);
		root.right.right.left = new Node(7);
		root.right.right.right = new Node(8);
		
		Result result = new Result();
		diameter(root, result);		
		System.out.println(result.value);
	}
	
	private static int diameter(Node node, Result result) {
		if (node == null) {
			return 0;
		}
		
		int leftMaxHeight = diameter(node.left, result);
		int rightMaxHeight = diameter(node.right, result);
		
		result.update(leftMaxHeight + rightMaxHeight);
		
		return Math.max(leftMaxHeight, rightMaxHeight) + 1;
	}
	
	private static class Result {
		int value;
		void update(int newValue) {
			if (newValue > value) {
				value = newValue;
			}
		}
	}

}
