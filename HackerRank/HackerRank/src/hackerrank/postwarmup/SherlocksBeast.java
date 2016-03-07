package hackerrank.postwarmup;

import java.util.Scanner;

/**
 * 
 * Sherlock Holmes suspects his archenemy, Professor Moriarty, is once again
 * plotting something diabolical. Sherlock's companion, Dr. Watson, suggests
 * Moriarty may be responsible for MI6's recent issues with their supercomputer,
 * The Beast.
 * 
 * Shortly after resolving to investigate, Sherlock receives a note from
 * Moriarty boasting about infecting The Beast with a virus; however, he also
 * gives him a clue—a number, NN. Sherlock determines the key to removing the
 * virus is to find the largest Decent Number having NN digits.
 * 
 * A Decent Number has the following properties:
 * 
 * Its digits can only be 3's and/or 5's. The number of 3's it contains is
 * divisible by 5. The number of 5's it contains is divisible by 3. If there are
 * more than one such number, we pick the largest one. Moriarty's virus shows a
 * clock counting down to The Beast's destruction, and time is running out fast.
 * Your task is to help Sherlock find the key before The Beast is destroyed!
 * 
 * Constraints 1≤T≤20 1≤N≤100000
 * 
 * 
 * Input Format
 * 
 * The first line is an integer, T, denoting the number of test cases.
 * 
 * The TT subsequent lines each contain an integer, NN, detailing the number of
 * digits in the number.
 * 
 * Output Format
 * 
 * Print the largest Decent Number having N digits; if no such number exists,
 * tell Sherlock by printing -1.
 * 
 * Sample Input
 * 
 * 4 1 3 5 11
 * 
 * Sample Output
 * 
 * -1 555 33333 55555533333
 * 
 * 
 * Explanation
 * 
 * For N=1N, there is no decent number having 1 digit (so we print −1). For N=3,
 * 555555 is the only possible number. The number 55 appears three times in this
 * number, so our count of 55's is evenly divisible by 33 (Decent Number
 * Property 3). For N=5, 3333333333 is the only possible number. The number 33
 * appears five times in this number, so our count of 33's is evenly divisible
 * by 55 (Decent Number Property 2). For N=11, 5555553333355555533333 and all
 * permutations of these digits are valid numbers; among them, the given number
 * is the largest one
 * 
 * 
 * Note : The int will not hold more than 10 digits, use long.
 * 
 *
 */

public class SherlocksBeast {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		SherlocksBeast sBeast = new SherlocksBeast();
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(sBeast.decentNumber(n));
		}
	}

	/**
	   * This method takes in N and returns the above mentioned 'Decent Number' which is 
	   * n digits long
	   * 
	   * @param n
	   * @return Decent Number of length n.
	   */
	  
	  public long decentNumber(int n){
		  long decNum = -1;
		  int num5 = 5;
		  int num3 = 3;
		  int max = -1;
		  
		  // Modulo values of n
		  int n_mod_5 = -1; // Number of 3's
		  int n_mod_3 = -1; // Number of 5's
		  

		  if(n < 3) // If less than 3 return -1
		  {
			  return decNum;
		  }
		  else{
			  n_mod_3 = n % 3;
			  n_mod_5 = n % 5;
		  }
		  
		// if true we can fill entirely with 5's coz u have a multiple of 3 and that would be the largest number (Greedy)
		  if(n_mod_3 == 0) 
		  {
			  decNum = createNumWithDigits(n,num5);
		  }
		  else {
			  
			  if(n_mod_5 == 0) // Divisible by 5 , so we can fill entirely with 3's
			  {
				  decNum = createNumWithDigits(n, num3);
			  }
			  else if ((n_mod_5 % 3) == 0){ // a multiple of combination of 5+3 digits
				  decNum = concatNumbers(createNumWithDigits(n/3, num5), createNumWithDigits(n_mod_5, num3));
			  }
			  
			  else{
				  decNum = buildDecentNumber(n);
			  }
		  }
		  
		  
		  return decNum;
	  }

	/**
	 * Takes in the length of a number to be made of given digits only.
	 * 
	 * @param numLength
	 * @param digit
	 * @return Number made with digit of length numLength
	 */
	public int createNumWithDigits(int numLength, int digit) {

		int numOfDigits = -1;
		StringBuilder digitAsString = new StringBuilder();

		for (int i = 1; i <= numLength; i++) {
			digitAsString.append(digit);
		}

		numOfDigits = Integer.parseInt(digitAsString.toString());
		return numOfDigits;
	}

	/**
	 * Given 2 numbers this method will return the concatenation of them.
	 * 
	 * Can be overloaded to include more than 2 numbers.
	 * 
	 * @param num_a
	 * @param num_b
	 * @return num_anum_b
	 */
	public long concatNumbers(int num_a, int num_b) {
		long conCatNums = -1;

		conCatNums = Integer.parseInt(Integer.toString(num_a).concat(Integer.toString(num_b)));

		return conCatNums;
	}
	
	/**
	 *  Build a decent number by incrementally subtract from 'N', 3 or 5 and checking the if the modulo
	 *  is divisible by 5 or 3 respectively
	 *  11 = ((11 -3) - 3 ) is divisible by 5. Hence the decent number would be 3*5+3*+5*3
	 *  
	 * 
	 * @param n
	 * @return
	 */
	public long buildDecentNumber(int n) {
		long numBuilt = 0;
		int index_3 = 0;
		int index_5 = 0;

		while (n > 0) {
			n -=  3;
			if ((n) % 5 == 0) {
				index_5++;
				n-=5;
			}
			index_3++;
		}
		
		numBuilt = concatNumbers(createNumWithDigits(index_5*5, 5), createNumWithDigits(index_3*3, 3));
		
		return numBuilt;
	}
}
