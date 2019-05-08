package org.ait.algorithms.graph;

import java.util.List;
import java.util.ArrayList;

public class EdgeWeightedDigraph {
	private List<DirectedEdge>[] adj;
	
	EdgeWeightedDigraph(int vertexesNum) {
		adj = new List[vertexesNum];
		for (int v = 0; v < adj.length; v++) {
			adj[v] = new ArrayList<>();
		}
	}
	
	void addEdge(DirectedEdge edge) {
		int from = edge.getFrom();
		validateVertex(from);
		int to = edge.getTo();
		validateVertex(to);
		adj[from].add(edge);
	}
	
	int getVerticesCount() {
		return adj.length;
	}
	
	List<DirectedEdge> adjList(int i) {
		return adj[i];		
	}
	
	private void validateVertex(int vertex) {
		if (vertex < 0 || vertex >= adj.length) {
			throw new IllegalArgumentException("vertex " + vertex + " is not between 0 and " + (adj.length - 1));
		}
	}
	
}
