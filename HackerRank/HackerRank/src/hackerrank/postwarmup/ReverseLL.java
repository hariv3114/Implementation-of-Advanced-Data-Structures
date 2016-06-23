/**
 * 
 */
package hackerrank.postwarmup;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Harigarakumar
 *
 */
public class ReverseLL {
	
	static ReverseLL thisClass = new ReverseLL(); 
	
	public static void main(String[] args){
		
		Node head = thisClass.new Node(1);
		Node next_1 = thisClass.new Node(2);
		Node next_2 = thisClass.new Node(3);
		Node next_3 = thisClass.new Node(4);
		Node next_4 = thisClass.new Node(5); 

		// Mapping
		head.next = next_1;
		next_1.next = next_2;
		next_2.next = next_3;
		next_3.next = next_4;
		next_4.next = null;

		thisClass.print(head);
		thisClass.print(reverse(head));
		
	}

	//inner class for node
	class Node{

		int data;
		Node next;

		//Constructor
		public Node(int data){
			this.data = data;
			this.next = null;
		}

		//Constructor with next and data set
		Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}


	/***
	* Method to reverse a LinkedList
	*
	* @param : LinkedList to be reversed
	* @return : reversed LinkedList
	*/
	public static Node reverse(Node head){


		// Single node or no node check
		if(head.next == null || head == null){
			return head;
		}

		Node prev = head;
		Node curr = head.next;
		Node next = head.next.next;

		//Set current head to null
		head.next = null;

		Node temp;

		while(next.next != null){

			curr.next = prev;

			prev = curr;
			curr = next;
			next = next.next;
		}

		curr.next = prev;
		next.next = curr;

		return next;
	}
	
	/**
	 *  Print all the nodes of a Linked List 
	 * 
	 * @param head
	 * 
	 */
	
	void print(Node head){

		Node node = head;

		while(node.next != null){
			System.out.print(node.data+", ");
			node = node.next;
		}

		System.out.print(node.data);
		System.out.println();

	}
}
