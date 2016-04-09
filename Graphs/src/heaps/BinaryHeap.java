// Ver 1.0:  Wed, Feb 3.  Initial description.
package heaps;

import java.util.Comparator;

import binarytrees.utils.VertexNameComparator;
import graphmodels.Vertex;

public class BinaryHeap<T> implements PQ<T> {
	public T[] pq;
	public Comparator<T> c;

	// increment this every time you add an element to the heap
	int sizeOfHeap;

	// Name based comparator for Vertices
	VertexNameComparator vertComp = new VertexNameComparator();

	/** Build a priority queue with a given array q */
	public BinaryHeap(T[] q, Comparator<T> comp) {
		pq = q;
		c = comp;
		// update Size of Heap
		sizeOfHeap = pq.length-1;
		buildHeap();
	}

	/** Create an empty priority queue of given maximum size */
	public BinaryHeap(int n, Comparator<T> comp) {
		PQ[] binHeap = new PQ[n];
		pq = (T[]) binHeap;
		sizeOfHeap = pq.length - 1;
		c = comp;
	}

	public void insert(T x) {

		// if there is overflow increase size
		if (pq.length - 1 == sizeOfHeap) {
			increaseHeapSize(pq.length);
		}

		// Call the add method to percolate up
		add(x);
	}

	/**
	 * Called on the heap. Removes the root node which is the mininmum.
	 * 
	 */
	public T deleteMin() {
		return remove();
	}

	public T min() {

		return peek();
	}

	/**
	 * Emulates the percolateUp concept of a Heap.Iteratively compared to the
	 * parent to check for heap condition and eventually placing it in the
	 * proper spot.
	 * 
	 * Heap size increases by 1.
	 * 
	 * @param :
	 *            x - element to be added to the heap
	 */
	public void add(T x) {

		// Including a new element has increased the size
		sizeOfHeap++;

		// Copy the element to 0 position
		pq[0] = x;
		pq[pq.length - 1] = x;
		percolateUp(sizeOfHeap);
	}

	public T remove() {

		// return the topmost element and percolate down

		T min = pq[1];
		pq[1] = pq[sizeOfHeap--];
		percolateDown(1);
//		buildHeap();
		return min;
	}

	/**
	 * return the topmost element (For a min heap)
	 */

	public T peek() {
		T min = (T) pq[1];
		return min;
	}

	/**
	 * pq[i] may violate heap order with parent
	 * 
	 * Method takes position of the new element and checks iteratively with its
	 * parent for the heap property. Swap if the property if violated. Min Heap
	 * is considered here
	 * 
	 * @param i
	 *            - size of the heap, position of the new element
	 */
	void percolateUp(int i) {

		// Temporary Vertex variable to aid in swap
		Vertex swap_temp_vert;

		if (i > 0) {
			Vertex vert_i = (Vertex) pq[i];
			Vertex vert_i_parent = (Vertex) pq[i % 2];

			// compare the 2 vertices. swap if violates heap order (Since its
			// Min-Heap, if new element is smaller than parent percolate up)
			if ((vertComp.compare(vert_i, vert_i_parent)) < 0) {
				swap(i, i % 2);
				percolateUp(i % 2);
			}
		}

	}

	/** pq[i] may violate heap order with children */
	void percolateDown(int i) {

		// Take the value at i
		T x;
		Vertex x_vert ;
		Vertex tempVert;
		int tempVertIndex;

		// Iterate as long as the we reach the leaf level
		while (2 * i <= sizeOfHeap) {
			 x = pq[i];
			 x_vert = (Vertex) x;
			// case of 1 child ...last leaf
			if (2 * i == sizeOfHeap) {
				tempVert = (Vertex) pq[2 * i];
				if (tempVert != null && x_vert != null) {
					if ((vertComp.compare(x_vert, tempVert) > 0)) {
						swap(i, 2 * i);
					}
				}

			}
			// It has both the leaves
			else {
				tempVertIndex = minOfSiblings(2 * i, ((2 * i) + 1));
				tempVert = (Vertex) pq[tempVertIndex];
				if (tempVert != null && x_vert != null) {
					if ((vertComp.compare(x_vert, tempVert) > 0)) {
						swap(i, tempVertIndex);
					}
				}
			}
			i++;
		}
	}

	/** Create a heap. Precondition: none. */
	void buildHeap() {
		for (int nodeIndex = 1; nodeIndex <= (sizeOfHeap / 2); nodeIndex++) {
			percolateDown(nodeIndex);
		}

	}

	/*
	 * sort array A[1..n]. A[0] is not used. Sorted order depends on comparator
	 * used to buid heap. min heap ==> descending order max heap ==> ascending
	 * order
	 */
	public static <T> void heapSort(T[] A,
			Comparator<T> comp) { /* to be implemented */
	}

	/* Utility method to increase heap size */
	public void increaseHeapSize(int newSize) {
		T[] tempHeap = (T[]) new PQ[newSize];
		System.arraycopy(pq, 0, tempHeap, 0, newSize - 1);
		pq = tempHeap;
	}

	/**
	 * Utility method to find min(can be modified for max) of the two siblings
	 * in 2-tree
	 * 
	 * @param leftChild and Right Child index
	 * @return index of the node with minimum value 
	 */
	public int minOfSiblings(int leftChildNode, int rightChildNode) {

		Vertex left = (Vertex) pq[leftChildNode];
		Vertex right = (Vertex) pq[rightChildNode];

		if ((vertComp.compare(left, right)) >= 0) {
			return rightChildNode;
		} else {
			return leftChildNode;
		}

	}

	/* Utility method to swap 2 objects in the BinaryHeap */

	public void swap(int i, int i_parent) {

		T temp;
		temp = pq[i];
		pq[i] = pq[i_parent];
		pq[i_parent] = temp;

	}

	/** Print the Heap using Delete min or from the Array */
	public void printHeap() {
		for (int i = 1; i <= pq.length; i++) {
			deleteMin();
		}
	}

}
