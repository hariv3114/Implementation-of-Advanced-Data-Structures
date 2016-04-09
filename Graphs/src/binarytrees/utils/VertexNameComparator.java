package binarytrees.utils;

import java.util.Comparator;

import graphmodels.Vertex;

public class VertexNameComparator implements Comparator<Vertex>{

	@Override
	/**
	 * Compares 2 Vertex objects based on the integer that represents
	 * their name.
	 * 
	 * 	@param1 : Vertex 1
	 *  @param2 : Vertex 2
	 *  
	 *  @returns : Difference between the Values of their names 
	 *  		   positive if Vertex 1 is greater, Negative if Vertex 2 is greater
	 *  		   0 if they are equal.
	 */
	public int compare(Vertex vert_1, Vertex vert_2) {
		if(vert_1.name > vert_2.name){
			return (vert_1.name - vert_2.name);
		}else if(!(vert_1.name > vert_2.name)){
			return (vert_1.name - vert_2.name);
		}
		return 0;
	}

}
