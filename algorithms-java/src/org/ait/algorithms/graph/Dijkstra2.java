package org.ait.algorithms.graph;

import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * function Dijkstra(Graph, source): {
 *   create vertex set PQ
 *   for each vertex v in Graph: { // Initialization
 *   	dist[v] ← INFINITY         // Unknown distance from source to v
 *      prev[v] ← UNDEFINED        // Previous node in optimal path from source *      
 *   }
 *      
 *   add source to PQ	// Add only the source to PQ. Orphan vertexes will never be added.
 *   dist[source] ← 0	// Distance from source to source
 *    
 *   while PQ is not empty: {
 *   	u ← vertex in PQ with min dist[u] // Node with the least distance will be selected first
 *    	remove u from PQ
 *    
 *    	// RELAX
 *    	for each neighbor v of u: { 
 *    		alt ← dist[u] + length(u, v)
 *    		if alt < dist[v]: {  // A shorter path to v has been found
 *    			dist[v] ← alt
 *    			prev[v] ← u
 *              
 *              if PQ contains v {
 *              	PQ decrease priority v
 *              } else {
 *              	PQ add v 
 *              }
 *    		}
 *       }
 *    }    
 *    return dist[], prev[]
 * }
 *    
 */

public class Dijkstra2 {

	public static void main(String[] args) {
		int[][] graph = { 
				{ 0, 4, 0, 0, 0, 0, 0, 8, 0, 0 }, 
				{ 4, 0, 8, 0, 0, 0, 0, 11, 0, 0 }, 
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2, 0 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 9, 0, 10, 0, 0, 0, 0 }, 
				{ 0, 0, 4, 0, 10, 0, 2, 0, 0, 0 },
				{ 0, 0, 0, 14, 0, 2, 0, 1, 6, 0 }, 
				{ 8, 11, 0, 0, 0, 0, 1, 0, 7, 0 }, 
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
			};		
 		dijkstra(graph, 0);
	}
	
	private static void dijkstra(int[][] graph, int sourceVertex) {
		int minDist[] = new int[graph.length];
		int prev[] = new int[graph.length];
		PriorityQueue<Integer> verticesPQ = new PriorityQueue<>(graph[0].length, new Comparator<Integer>() {
			@Override
			public int compare(Integer v1, Integer v2) {
				return minDist[v1] - minDist[v2];
			}						
		});
		
		for (int vertex = 0; vertex < minDist.length; vertex++) {
			minDist[vertex] = Integer.MAX_VALUE;
			prev[vertex] = -1;			
		}
		
		verticesPQ.add(sourceVertex);
		minDist[sourceVertex] = 0;
		
		while (!verticesPQ.isEmpty()) {
			int vertex = verticesPQ.poll();
			relax(vertex, graph, minDist, prev, verticesPQ);			
		}
		
		Dijkstra.printSolution(sourceVertex, minDist, prev);
	}
	
	private static void relax(int vertex, int[][] graph, int minDist[], 
			int prev[], PriorityQueue<Integer> verticesPQ) {
		int neighbors[] = graph[vertex];
		for(int i = 0; i < neighbors.length; i++) {
			int disti = neighbors[i];
			if (disti == 0) {
				continue; // no path from vertex to i
			}
			
			int alt = minDist[vertex] + disti; 
			if (alt < minDist[i]) {
				minDist[i] = alt;
				prev[i] = vertex;
				if (verticesPQ.contains(i)) {
					verticesPQ.remove(i);					
				}
				verticesPQ.offer(i);				
			}				
		}		
	}
}
