package hackerrank;

import java.util.Scanner;

/**
 * 
 * A Discrete Mathematics professor has a class of NN students. Frustrated with
 * their lack of discipline, he decides to cancel class if fewer than K
 * students are present when class starts.
 * 
 * Given the arrival time of each student, determine if the class is canceled.
 * 
 * Input Format
 * 
 * The first line of input contains TT, the number of test cases.
 * 
 * Each test case consists of two lines. The first line has two space-separated
 * integers, N (students in the class) and K (the cancellation threshold). The
 * second line contains NN space-separated integers (a1,a2,…,aNa1,a2,…,aN)
 * describing the arrival times for each student.
 * 
 * Note: Non-positive arrival times (ai≤0) indicate the student arrived
 * early or on time; positive arrival times (ai>0) indicate the student
 * arrived ai minutes late.
 * 
 * Output Format
 * 
 * For each test case, print the word YES if the class is canceled or NO if it
 * is not.
 * 
 * Constraints
 * 
 * 1≤T≤10 1≤N≤1000 1≤K≤N  −100≤ai≤100,where
 * i∈[1,N]−100≤ai≤100,where i∈[1,N] Note If a student arrives exactly on time
 * (ai=0), the student is considered to have entered before the class
 * started.
 * 
 * Sample Input
 * 
 * 2
 * 4 3
 * -1 -3 4 2
 * 4 2 
 * 0 -1 2 1 
 * 
 * Sample Output
 * YES N0
 *
 */

public class ProfessorsProblem {
	
	public static void main(String args[]){
		
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		
		// Reiterate T times the input loop to gather all the test cases
		// I intend to printout the Result inside the loop
		
		for(int t_i=0;t_i < t; t_i++){
			
			int n = input.nextInt();
			int k = input.nextInt();
			int attnd_count = 0;
			// Gather attendance values for this test case
			for(int n_i=0; n_i < n;n_i++){
				int next = input.nextInt();
				if(next <= 0){
					attnd_count++;
				}
			}
			if(attnd_count < k){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
		}
		
		// close the Scanner
		input.close();
	}
	

}
