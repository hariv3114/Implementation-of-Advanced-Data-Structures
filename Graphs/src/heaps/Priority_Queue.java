/**
 * 
 */
package heaps;

import java.util.Queue;

/**
 * @author Harigarakumar
 *
 */
public class Priority_Queue{

	int node_number;
	int height;
	
	/*public int compareTo(Priority_Queue other_Queue) {

		if(this.equals(other_Queue)){
			return 0;
		}else if(this.){
			return 
		}
		
		
		return 0;
	}*/
	
	
	@Override
    public boolean equals(Object o) {
		
		 if((o instanceof Priority_Queue) && o != null){
			 Priority_Queue other_pq = (Priority_Queue) o;
			 if(this.node_number == other_pq.node_number){
				 return true;
			 }else{
				 return false;
			 }
		 }else{
			 return false;
		 }
	}
	
	
	@Override
	public int hashCode(){
		String hash = Integer.toString(this.node_number*this.height)+ Integer.toString(node_number)+Integer.toString(height);
		return Integer.parseInt(hash);
	}
	
	

}
