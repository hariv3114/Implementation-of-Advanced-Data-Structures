/**
 * 
 */
package topologicalsort;

import topologicalsort.Vertex;

/**
 * @author Harigarakumar
 *
 */
public class DFSVertex extends Vertex {
	
	public boolean visited;
	public int discTime;
	public int finTime;
	public char color;
	public int name;
	public int parent;
	
	
	/**
	 * Default constructor for Vertices used by DFS object
	 * @param : DEFAULT name, discovery and finish times, color and parent values
	 *  
	 */
	public DFSVertex(int name,int discTime,int finTime,char color, int parent){
		super(name);
		this.color = color;
		this.discTime = discTime;
		this.finTime = finTime;
		this.visited = false;
		this.parent = parent;
		this.name = name;
		this.Adj = super.Adj;
		this.revAdj = super.revAdj;
	}


	/**
	 * @return the visited
	 */
	public boolean isVisited() {
		return visited;
	}


	/**
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}


	/**
	 * @return the discTime
	 */
	public int getDiscTime() {
		return discTime;
	}


	/**
	 * @param discTime the discTime to set
	 */
	public void setDiscTime(int discTime) {
		this.discTime = discTime;
	}


	/**
	 * @return the finTime
	 */
	public int getFinTime() {
		return finTime;
	}


	/**
	 * @param finTime the finTime to set
	 */
	public void setFinTime(int finTime) {
		this.finTime = finTime;
	}


	/**
	 * @return the color
	 */
	public char getColor() {
		return color;
	}


	/**
	 * @param color the color to set
	 */
	public void setColor(char color) {
		this.color = color;
	}


	/**
	 * @return the name
	 */
	public int getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(int name) {
		this.name = name;
	}


	/**
	 * @return the parent
	 */
	public int getParent() {
		return parent;
	}


	/**
	 * @param parent the parent to set
	 */
	public void setParent(int parent) {
		this.parent = parent;
	}
	
	
	

}
