// Ver 1.0:  Wed, Feb 3.  Initial description.
package heaps;

import java.lang.reflect.Array;
import java.util.Comparator;

public class BinaryHeap<T> implements PQ<T> {
	T[] pq;
	Comparator<T> c;
	int sizeOfHeap;

	/** Build a priority queue with a given array q */
	BinaryHeap(T[] q, Comparator<T> comp) {
		pq = q;
		c = comp;
		//update Size of Heap
		sizeOfHeap = pq.length-1;
		buildHeap();
	}

	/** Create an empty priority queue of given maximum size */
	BinaryHeap(int n, Comparator<T> comp) { 
		PQ[] binHeap = new PQ[n];
		pq = (T[]) binHeap;
		sizeOfHeap = pq.length -1;
		c = comp;
	}

	public void insert(T x) {
		add(x);
	}

	public T deleteMin() {
		return remove();
	}

	public T min() {
		return peek();
	}

	/**
	 *  Emulates the percolateUp concept of a Heap.Initially added to the leftmost 
	 *  available leaf spot. Iteratively compared to the parent to check for heap condition
	 *  and eventually placing it in the proper spot.
	 *  
	 *  Heap size increases by 1.
	 *  
	 *  @param : x - element to be added to the heap
	 */
	public void add(T x) { /* to be implemented */
	}

	public T remove() { /* to be implemented */
		return null;
	}

	public T peek() { /* to be implemented */
		return null;
	}

	/** pq[i] may violate heap order with parent */
	void percolateUp(int i) { /* to be implemented */
	}

	/** pq[i] may violate heap order with children */
	void percolateDown(int i) { /* to be implemented */
	} 

	/** Create a heap. Precondition: none. */
	void buildHeap() {
	}

	/*
	 * sort array A[1..n]. A[0] is not used. Sorted order depends on comparator
	 * used to buid heap. min heap ==> descending order max heap ==> ascending
	 * order
	 */
	public static <T> void heapSort(T[] A,
			Comparator<T> comp) { /* to be implemented */
	}
}
