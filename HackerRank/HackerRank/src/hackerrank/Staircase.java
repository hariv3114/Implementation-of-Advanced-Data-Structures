package hackerrank;

import java.util.Scanner;

/**
 * 
 * Your teacher has given you the task of drawing a staircase structure. Being
 * an expert programmer, you decided to make a program to draw it for you
 * instead. Given the required height, can you print a staircase as shown in the
 * example?
 * 
 * Input You are given an integer N depicting the height of the staircase.
 * 
 * Output Print a staircase of height N that consists of # symbols and spaces.
 * For example for N=6, here's a staircase of that height:
 * 
 *      # 
 *     ## 
 *    ### 
 *   #### 
 *  ##### 
 * ######
 * 
 */

public class Staircase {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=1; i <=n; i++){
			
			if(n!=i){
				System.out.print(String.format("%"+(n-i)+"s"," "));
			}
			System.out.println(String.format("%"+(i)+"s"," ").replaceAll(" ", "#"));
		}
	}
}
