/**
 * 
 */
package topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Harigarakumar
 * 
 *         This class has a defined data structure
 *
 */
public class DFSImplementation {

	/**
	 * @param g
	 * @return Stack of vertices that would come up in topological order
	 */
	public Stack<DFSVertex> topologicalByDfs(Graph g) {

		// Stack of vertices to be returned
		Stack<DFSVertex> topoOrder = new Stack<DFSVertex>();

		// Variable to keep track of discovery and finish times
		int time = 0;

		// Initialize all vertices with 'parent:nil' and 'color:white'
		Map<Integer, DFSVertex> initializedVertices = initializeGraph(g);

		// Call the initial DFS visit on all vertices
		// Helps build the forest in case of disjoint trees

		DFSVertex currProcessedVertex;

		for (Integer currProcessedVertexKey : initializedVertices.keySet()) {
			currProcessedVertex = initializedVertices.get(currProcessedVertexKey);

			// Call the DFSVisit process if the current vertex is white
			if (currProcessedVertex.getColor() == 'W') {
				DFSVisit(currProcessedVertex, topoOrder, ++time, initializedVertices);
			}

		}

		return topoOrder;

	}

	/**
	 * This method iterates over the vertices of the original graph, casts them
	 * into DFSVertex and initializes them
	 * 
	 * @param g
	 * @return Map of initialized Vertices
	 */
	public Map<Integer, DFSVertex> initializeGraph(Graph g) {

		// List of Vertices to be returned
		Map<Integer, DFSVertex> initializedVertices = new HashMap<Integer, DFSVertex>();

		ArrayList<Vertex> vertices = (ArrayList<Vertex>) g.verts;
		DFSVertex currInitialized;
		for (Vertex vertex : vertices) {

			if (vertex != null) {
				currInitialized = new DFSVertex(vertex.name, 0, 0, 'W', 0);
				currInitialized.Adj = vertex.Adj;
				currInitialized.revAdj = vertex.revAdj;
				initializedVertices.put(currInitialized.getName(), currInitialized);
			}
		}

		return initializedVertices;
	}

	/**
	 * Takes in a vertex that has not been processed, processes its descendants
	 * and finally the vertex itself and adds it to the Stack of vertices
	 * 
	 * @param whiteVertex
	 * @param topoOrder
	 * @param time
	 * @param List
	 *            of initialized vertices
	 * 
	 */
	public void DFSVisit(DFSVertex whiteVertex, Stack<DFSVertex> topoOrder, int time,
			Map<Integer, DFSVertex> initializedVertices) {

		// Set discovery time and color
		whiteVertex.setDiscTime(time);
		whiteVertex.setColor('G');

		// Temp vertex variable to hold adjacent vertices
		DFSVertex adjVert;

		for (Edge edge : whiteVertex.Adj) {
			adjVert = initializedVertices.get(edge.To.name);
			if (adjVert.getColor() == 'W') { // unprocessed
				// set parent to current processed vertex
				adjVert.setParent(whiteVertex.getName());
				DFSVisit(adjVert, topoOrder, ++time, initializedVertices);
			}
		}

		// Vertex is processed. Make it black and add it to the Stack
		whiteVertex.setColor('B');
		whiteVertex.setFinTime(++time);
		topoOrder.push(whiteVertex);

	}

}
