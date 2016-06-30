package hackerrank.postwarmup;

import javax.naming.ldap.HasControls;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LL_Cycle {
	
	
	
	public static void main(String args[]){
	
		ListNode head =new ListNode(3);
		ListNode _1 =new ListNode(2);
		ListNode _2 =new ListNode(0);
		ListNode _3 =new ListNode(4);
		head.next = _1;
		_1.next = _2;
		_2.next = _3;
		_3.next = _1;
		
		System.out.println(hasCycle(head));
		
	}
	
	    public static boolean hasCycle(ListNode head) {
	        
	        ListNode node = head;
	        ListNode _p1, _p2;
	        
	        // Check for head not null and head only Node
	        if(node == null || node.next == null){
	            return false;
	        }
	        
	        _p1 = node;
	        _p2 = node.next.next;
	        
	        while((_p1 != null) && (_p2 != null)){
	
	            
	            System.out.println("1 : "+_p1.val+" 2: "+_p2.val);
	            
	            if(_p1.val == _p2.val){
	                return true;
	            }
	            
	            _p1 = _p1.next;
	            _p2 = _p2.next.next;
	        }
	        
	        return false;
	        
    }
    
    
}