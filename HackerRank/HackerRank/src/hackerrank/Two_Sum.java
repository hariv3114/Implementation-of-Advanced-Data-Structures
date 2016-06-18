package hackerrank;

import java.util.Hashtable;
import java.util.concurrent.CompletableFuture.AsynchronousCompletionTask;

/***
 * Problem statement @author : Leetcode
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author Harigarakumar
 *
 */

public class Two_Sum {

	public static void main(String[] args) {

		int[] input = { 1, 2, 3, 4, 5 };
		int target = 9;
		
		int[] result = twoSum(input, target);
		System.out.println(result[0]+" , "+ result[1]);
		
	}

	
	  public static int[] twoSum(int[] nums, int target) {
	        
		  int[] res = new int[2];
		  
		  Hashtable<Integer,Integer> inputHashTable = new Hashtable<Integer,Integer>();
		  
		  for(int j=0;j < nums.length; j++){
			  inputHashTable.put(nums[j], j);
		  }
		  
		  for(int i = 0; i < nums.length; i++){
			  if(inputHashTable.containsKey(target-nums[i])){
				  res[0] = i;
				  res[1] = inputHashTable.get(target-nums[i]); 
				  
			  }
		  }
		  
		  return res; 
		  
	    }
	
}
