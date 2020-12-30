package org.ait.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

public class PrimMST {
	private static int graph[][];
	private static boolean[] isInMST;
	private static List<Integer> notVisited;
	private static int[] pathTo;
	private static int[] minWeight;	

	public static void main(String[] args) {

		graph = new int[][] 
			{{0, 2, 0, 6, 0}, 
            {2, 0, 3, 8, 5}, 
            {0, 3, 0, 0, 7}, 
            {6, 8, 0, 0, 9}, 
            {0, 5, 7, 9, 0}};

		isInMST = new boolean[graph.length];
		notVisited = new ArrayList<>();
		pathTo = new int[graph.length];
		minWeight = new int[graph.length];

		for (int i = 0; i < graph.length; i++) {
			minWeight[i] = Integer.MAX_VALUE;
		}

		minWeight[0] = 0;
		pathTo[0] = -1;

		MST(0);
		printMST();
	}

	private static void MST(int startNode) {
		visitNode(startNode);

		while (!notVisited.isEmpty()) {
			int minNode = removeMin();
			visitNode(minNode);	
		}
	}

	private static void visitNode(int node) {
		isInMST[node] = true;
		for (int i = 0; i < graph.length; i++) {
			if (graph[node][i] != 0 && !isInMST[i] && minWeight[i] > graph[node][i] ) {
				System.out.println(i + " --- " + graph[node][i]);
				minWeight[i] = graph[node][i];
				pathTo[i] = node;
				notVisited.add(i);
			}			
		}
	}

	private static int removeMin() {
		int index = 0;
		int min = minWeight[notVisited.get(0)];
		for (int i = 1; i < notVisited.size(); i++) {
			if (min > minWeight[notVisited.get(i)]) {
				min = minWeight[notVisited.get(i)];
				index = i;
			}
		}
		return notVisited.remove(index);
	}
	
	private static void printMST() {
		System.out.println("Edge \tWeight");
		for (int i = 1; i < graph.length; i++)
			System.out.println(pathTo[i] + " - " + i + "\t" + graph[i][pathTo[i]]);
	}
}
