package org.ait.algorithms.tree;

public class LCS {

	public static void main(String[] args) {
		Node root = new Node(0);

		root.left = new Node(1);
		root.right = new Node(2);

		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);

		root.left.left.left = new Node(7);
		root.left.left.right = new Node(8);
		root.right.right.right = new Node(9);

		int val1 = 7, val2 = 8;
		System.out.println(String.format("LCS(%d,%d) is: %s", val1, val2, lcs(root, val1, val2)));
	}

	private static Node lcs(Node node, int val1, int val2) {
		StringBuffer v1Found = new StringBuffer();
		StringBuffer v2Found = new StringBuffer();
		Node lcsNode = lcsHelper(node, val1, val2, v1Found, v2Found);
		return (v1Found.length() > 0 && v2Found.length() > 0) ? lcsNode : null;
	}

	private static Node lcsHelper(Node node, int val1, int val2, StringBuffer v1Found, StringBuffer v2Found) {
		if (node == null) {
			return null;
		}

		Node found = null;
		
		if (node.value == val1) {
			v1Found.append(true);
			found = node;			
		}

		if (node.value == val2) {
			v2Found.append(true);
			found = node;			
		}

		Node lcsLeft = lcsHelper(node.left, val1, val2, v1Found, v2Found);
		Node lcsRight = lcsHelper(node.right, val1, val2, v1Found, v2Found);
		
		if (found != null) {
			return found;
		}

		if (lcsLeft != null && lcsRight != null) {
			return node;
		}

		return (lcsLeft == null) ? lcsRight : lcsLeft;
	}

}
