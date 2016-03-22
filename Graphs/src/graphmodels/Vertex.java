package graphmodels;

/**
 * Class to represent a vertex of a graph
 * 
 *
 */

import java.util.*;

public class Vertex {
	public int name; // name of the vertex
	public boolean seen; // flag to check if the vertex has already been visited
	public Vertex parent; // parent of the vertex
	public int distance; // distance to the vertex from the source vertex
	public List<Edge> Adj, revAdj; // adjacency list; use LinkedList or
									// ArrayList
	public int inDegree = 0; // Number of incoming edges
	public int outDegree = 0; // Number of outgoing edges
	public int topNumber = 0; // Topological number of the vertex 

	/**
	 * Constructor for the vertex
	 * 
	 * @param n
	 *            : int - name of the vertex
	 */
	Vertex(int n) {
		name = n;
		seen = false;
		parent = null;
		Adj = new ArrayList<Edge>();
		revAdj = new ArrayList<Edge>(); /* only for directed graphs */
	}

	/**
	 * Method to represent a vertex by its name
	 */
	public String toString() {
		return Integer.toString(name);
	}
	
	/**
	 * Overridden equals method for the Vertex based 
	 * on the topological order
	 */
	@Override
	public boolean equals(Object otherVertexObj){
		
		if(!(otherVertexObj instanceof Vertex)){
			return false;
		}
		
		if(otherVertexObj == this){
			return true;
		}
		
		Vertex otherVertex = (Vertex) otherVertexObj;
		
		if(this.topNumber == otherVertex.topNumber){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Override the Hashcode method 
	 */
	
	/**
	 * CompareTo method for Vertex : For topological ordering 
	 * 
	 */
/*	@Override
	public int compareTo(Vertex otherVertex){
		
		
		return 0;
	}*/
	
	
	
}
