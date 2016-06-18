package binarytrees.traversals;

public class BST_LCA {

	

	 /* Node is defined as :
	 class Node 
	    int data;
	    Node left;
	    Node right;
	    
	    */

	static TreeNode lca(TreeNode root,int v1,int v2)
	    {

	        if(root != null){
	            
	            
	                if(v1 < 0 || v2 < 0){
	                
	                return root;

	            }
	            
	                 // Check if v1 > root and v2 < root. If so then the root is the LCA
	            else if((v1 <= root.data) && (v2 >= root.data) || (v2 <= root.data) && (v1 >= root.data)){
	                 return root;
	            }
	    
	             else {
	                    // If both v1 and v2 are lesser than root, then recurse through the left subtree of the root    
	                         if((v1 < root.data) && (v2 < root.data)){
	                             if(root.left != null){
	                                 return lca(root.left, v1, v2); 
	                             }
	                              
	                         }
	                   // If both v1 and v2 are greater than root, then recurse through the right subtree of the root
	                        else {
	                            if(root.right != null){
	                                return lca(root.right, v1, v2); 
	                            }
	                            
	                        }
	                 
	             }
	           
	   
	            
	        }
	        return root;
	    }


	
}
