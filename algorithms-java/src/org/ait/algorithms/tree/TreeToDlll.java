package org.ait.algorithms.tree;

public class TreeToDlll {

	static DLL top;
	static DLL bottom;
	
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
		
		treeToDLL(root);
		DLL b = bottom;
		DLL t = top;
		while(b != null) {
			System.out.print(b + " ");
			b = b.prev;
		}	
		System.out.println();
		while(t != null) {
			System.out.print(t + " ");
			t = t.next;
		}
	}
	
	private static void treeToDLL(Node node) {
		if (node == null) {
			return;
		}
		
		if (top == null) {
			top = bottom = new DLL(node.value);
		} else {
			DLL dll = new DLL(node.value);
			bottom.next = dll;
			dll.prev = bottom;
			bottom = dll;
		}
		
		treeToDLL(node.left);
		treeToDLL(node.right);
	}
	
	static class DLL {
		int value;
		DLL next;
		DLL prev;
		
		DLL(int value) {
			this.value = value;			
		}
		
		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

}
