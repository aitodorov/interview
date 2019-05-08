package org.ait.algorithms.tree;

import org.ait.algorithms.tree.TreeToDlll.DLL;

public class TreeToDLL2 {

	public static void main(String[] args) {
		Node root = new Node(0);
		root.right = new Node(1);
		root.right.right = new Node(2);
		root.right.right.right = new Node(3);
		root.right.right.left = new Node(4);
		root.right.right.left.left = new Node(10);
		root.right.right.left.right = new Node(5);
		root.left = new Node(6);
		root.right.left = new Node(7);
		DLL b = treeToDLL(null, null, root);
		DLL t = null;
		while(b != null) {
			System.out.print(b + " ");
			b = b.prev;
			if (b != null) {
				t = b;
			}
		}
		System.out.println();
		while(t != null) {
			System.out.print(t + " ");
			t = t.next;
		}
	}
	
	private static DLL treeToDLL(DLL top, DLL bottom, Node node) {
		if (node == null) {
			return bottom;
		}
		
		if (top == null) {
			top = bottom = new DLL(node.value);
		} else {
			DLL dll = new DLL(node.value);
			bottom.next = dll;
			dll.prev = bottom;
			bottom = dll;
		}
		
		bottom = treeToDLL(top, bottom, node.left);
		return treeToDLL(top, bottom, node.right);		
	}

}
