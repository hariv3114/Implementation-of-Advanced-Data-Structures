/**
 * 
 */
package hackerrank.postwarmup;

import java.util.Scanner;

/**
 * @author Harigarakumar
 *
 */

/**
 * Problem Statement:
 * 
 * Given an integer, NN, traverse its digits (dd1,dd2,...,ddn) and determine how
 * many digits evenly divide NN (i.e.: count the number of times NN divided by
 * each digit ddi has a remainder of 00). Print the number of evenly divisible
 * digits.
 * 
 * Note: Each digit is considered to be unique, so each occurrence of the same
 * evenly divisible digit should be counted (i.e.: for N=11, the answer is 33).
 * 
 * Input Format
 * 
 * The first line is an integer, T, indicating the number of test cases. The TT
 * subsequent lines each contain an integer, N.
 * 
 * Constraints 1≤T≤15 0<N<10^9 Output Format
 * 
 * For every test case, count and print (on a new line) the number of digits in
 * NN that are able to evenly divide NN.
 * 
 * Sample Input
 * 
 * 2 12 1012 Sample Output
 * 
 * 2 3 Explanation
 * 
 * The number 1212 is broken into two digits, 11 and 22. When 1212 is divided by
 * either of those digits, the calculation's remainder is 00; thus, the number
 * of evenly-divisible digits in 1212 is 22.
 * 
 * The number 10121012 is broken into four digits, 11, 00, 11, and 22. 10121012
 * is evenly divisible by its digits 11, 11, and 22, but it is not divisible by
 * 00 as division by zero is undefined; thus, our count of evenly divisible
 * digits is 33.
 * 
 *
 */
public class Find_Digits {


    public static void main(String[] args) {
     
    	long num = 0;
    	int even_div_digits = 0;
        Find_Digits find = new Find_Digits();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextInt();
            
            find.displayEvenDivDigits(n);
             
        }
    }
    
    /**
     * Takes an input number, counts the number of digits of its composition 
     * that divides it equally and displays the same.
     * @param n
     */
    public void displayEvenDivDigits(long n){
    	
    	int evenDivDigits = 0; // counter of digits that evenly divide 
    	long curr_digit = 0;    // var that holds the current digit
    	long n_dup = n;
    	while(n_dup > 0){
    		curr_digit = n_dup%10;
    		if(!(curr_digit==0)){
    			if((n % curr_digit) == 0){
    				evenDivDigits++;
    			}
    		}
    		n_dup/=10;
    	}
    	System.out.println(evenDivDigits);
    }
    

}
