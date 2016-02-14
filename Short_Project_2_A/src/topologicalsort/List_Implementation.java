package topologicalsort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class List_Implementation {

	/*
	 * Algorithm 1. Remove vertices with no incoming edges, one at a time, along
	 * with their incident edges, and add them to a list.
	 */
	public static List<Vertex> topologicalOrder1(Graph g) {

		// A counter for the topological number
		int top_number = 0;

		// Temp vertex that holds current processed
		Vertex processed = new Vertex(0);
		
		// Temp vertex that holds the next vertex to be processed
		Vertex toBeProcessed = new Vertex(0);
		
		
		// List to be returned by the method
		List<Vertex> topologicalOrderVertices = new ArrayList<Vertex>();

		// Queue to hold the 0 in-degree vertices
		Queue<Vertex> vertsOfZeroInDegree = new ArrayDeque<Vertex>();

		// Create a graph object and specify the structure
		Graph graph = g;

		PriorityQueue<Vertex> topOrder = new PriorityQueue<Vertex>(graph.numNodes, new Comparator<Vertex>() {

			public int compare(Vertex vertex1, Vertex vertex2) {

				return (vertex1.topNumber > vertex2.topNumber ? -1 : 1);
			}
		});

		toBeProcessed = getZeroInDegreeVerts(graph);
		if(toBeProcessed!= null){
				vertsOfZeroInDegree.add(toBeProcessed);
		}

		// While there are nodes with 0 in degree
		// process them for top sort
		while (!vertsOfZeroInDegree.isEmpty()) {
			processed = (Vertex) vertsOfZeroInDegree.poll();
			removeOutEdges(processed, topOrder, top_number);
			graph.verts.remove(processed);
			
			toBeProcessed = getZeroInDegreeVerts(graph);
			if(toBeProcessed!= null){
					vertsOfZeroInDegree.add(toBeProcessed);
			}
		}

		// Add the processed node to the List

		for (Vertex vertex : topOrder) {
			topologicalOrderVertices.add(vertex);
		}

		if (topologicalOrderVertices.size() != graph.numNodes) {
			return null;
		}

		return topologicalOrderVertices;

	}

	
	/** This method takes in an Vertex and removes all its outgoing edges,
	 * thereof removing the incoming edges of other vertices that have an edge
	 * from this vertex
	 * 
	 * @param: 0
	 *             indegree vertex
	 */

	public static void removeOutEdges(Vertex zeroInVert, PriorityQueue<Vertex> topOrder, int top_number) {

		// Temp vertex variable to hold 'To' vertex
		Vertex tempTo;

		while (!zeroInVert.seen) {

			for (Edge outEdge : zeroInVert.Adj) {

				// Remove the edge from the head vertex
				tempTo = outEdge.To;
				tempTo.revAdj.remove(outEdge);

			}
			// Remove the edge from the Tail vertex - Careful do it after the
			// loop

			// Assign the topological number
			zeroInVert.topNumber = ++top_number;

			// Add to Queue
			topOrder.add(zeroInVert);

			zeroInVert.seen = true;
		}

	}

	/**
	 * Method that will iterate through the graph's vertices and queue any
	 * vertex with an in degree of 0 nad remove the same from the graph
	 * 
	 * @param : Graph 
	 */
	public static Vertex getZeroInDegreeVerts(Graph graph) {

		// Iterate the vertices of the graph and push them once they do
		// not have any incoming edges. Also this has to be called every time a
		// node has been processed
		Iterator<Vertex> vertIter = graph.verts.iterator();
		for (Vertex vertex : graph) {
			// Queue a vertex if its indegree is 0
			if (vertex.revAdj.size() == 0) {
				return vertex;
			}
		}
		return null;

	}

}
