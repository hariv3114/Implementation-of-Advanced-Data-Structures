package binarytrees;

import binarytrees.BST.Entry;

/**
 * 
 * @author Harigarakumar
 * 
 * Related problem statements
 * --------------------------
 * Given an AVL tree, write a function to verify whether it is a valid AVL tree.
 * The tree may violate AVL tree conditions in any of the following ways: 
 * 		ordering condition - BST condition
 * 		null value stored as element - All non-null nodes 
 * 		balance condition - |h(left) - h(right)| <= 1
 *
 */

public class AVLTree<T extends Comparable<? super T>> extends BST<T>{
	
	class AVLEntry<E> extends Entry<E>{
		int height;
		AVLEntry(E x, AVLEntry<E> l, AVLEntry<E> r, AVLEntry<E> p) {
		    super(x,l,r,p);
		    height = 0;
		}
	    }
	
	public <E> boolean verifyAVLTree(AVLEntry<E> root){
		
		boolean result = false;
		
		return result;
	}

}
