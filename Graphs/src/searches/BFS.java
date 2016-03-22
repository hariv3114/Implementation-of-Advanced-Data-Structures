package searches;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import graphmodels.Edge;
import graphmodels.Graph;
import graphmodels.Vertex;

/**
 * @author Harigarakumar
 *
 */
public class BFS {

	Queue<Vertex> bfsQueue;
	int graphVertCount = 0;
	int bfsVertCount = 0;
	List<Vertex> bfsOrderVerts;

	/**
	 * This method will take the graph as an input and run a Breadth First
	 * Search on the same
	 * 
	 * @param inputGraph
	 * @return void : Prints the Vertices in the order of the Breadth First Search
	 */
	public void runBFS(Graph inputGraph) {

		bfsQueue = new LinkedList<Vertex>();
		graphVertCount = inputGraph.numNodes;
		bfsOrderVerts = new LinkedList<Vertex>();

		// We pick the first vertex as the source of the graph
		if (inputGraph.verts.get(0) != null) {
			bfsQueue.add(inputGraph.verts.get(0));
		} else {
			bfsQueue.add(inputGraph.verts.get(1));
		}


		while (!bfsQueue.isEmpty()) {
			Vertex next = (Vertex) bfsQueue.poll();
			if (!next.seen) {
				bfsVertCount++;
				next.seen = true;
				for (Edge adjEdge : next.Adj) {
					bfsQueue.add(adjEdge.To);
				}
				bfsOrderVerts.add(next);
			}
		}
		
		if(graphVertCount > bfsVertCount){
			System.out.println("The graph is Disconnected. BFS on one of the trees is ");
		}
		System.out.println("The BFS order is : ");
		for (Vertex vertex : bfsOrderVerts) {
			System.out.print(vertex.name+" ");
		}
	}
}


