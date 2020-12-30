package org.ait.algorithms.graph;

import java.util.PriorityQueue;
import java.util.Comparator;

public class Dijkstra3 {

	public static void main(String[] args) {		
		EdgeWeightedDigraph graph = new EdgeWeightedDigraph(7);
		graph.addEdge(new DirectedEdge(0, 1, 2));
		graph.addEdge(new DirectedEdge(1, 3, 3));
		graph.addEdge(new DirectedEdge(3, 5, 1));
		graph.addEdge(new DirectedEdge(0, 5, 5));
		graph.addEdge(new DirectedEdge(0, 2, 2));
		graph.addEdge(new DirectedEdge(2, 4, 1));
		graph.addEdge(new DirectedEdge(4, 5, 1));
		
		dijkstra(graph, 0);
	}
	
	private static void dijkstra(EdgeWeightedDigraph graph, int sourceVertex) {
		int distTo[] = new int[graph.getVerticesCount()];
		int prev[] = new int[graph.getVerticesCount()];
		PriorityQueue<Integer> verticesPQ = new PriorityQueue<>(graph.getVerticesCount(), new Comparator<Integer>() {
			@Override
			public int compare(Integer v1, Integer v2) {
				return distTo[v1] - distTo[v2];
			}						
		});
		
		for (int vertex = 0; vertex < distTo.length; vertex++) {
			distTo[vertex] = Integer.MAX_VALUE;
			prev[vertex] = -1;
			//verticesPQ.add(vertex);
		}
		
		verticesPQ.add(sourceVertex);
		distTo[sourceVertex] = 0;
		
		while (!verticesPQ.isEmpty()) {
			int vertex = verticesPQ.poll();
			for (DirectedEdge edge : graph.adjList(vertex)) {
				relax(edge, verticesPQ, distTo, prev);								
			}						
		}	
		
		Dijkstra.printSolution(sourceVertex, distTo, prev);
	}
	
	private static void relax(DirectedEdge edge, PriorityQueue<Integer> verticesPQ, int distTo[], int prev[]) {
		int startVertex = edge.getFrom(), endVertex = edge.getTo();
		
		if (distTo[endVertex] > distTo[startVertex] + edge.getWeight()) {
			distTo[endVertex] = distTo[startVertex] + edge.getWeight();
			prev[endVertex] = startVertex;
			if (verticesPQ.contains(endVertex)) {
				verticesPQ.remove(endVertex);
			} 
			verticesPQ.offer(endVertex);
		}		
	}

}
