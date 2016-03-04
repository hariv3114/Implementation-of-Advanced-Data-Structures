package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Given an array of integers, calculate which fraction of the elements are
 * positive, negative, and zeroes, respectively. Print the decimal value of each
 * fraction.
 * 
 * Input Format
 * 
 * The first line, N, is the size of the array. The second line contains N
 * space-separated integers describing the array of numbers
 * (A1,A2,A3,⋯,ANA1,A2,A3,⋯,AN).
 * 
 * Output Format
 * 
 * Print each value on its own line with the fraction of positive numbers first,
 * negative numbers second, and zeroes third.
 * 
 * Sample Input
 * 
 * 6 
 * -4 3 -9 0 4 1
 * 
 * 
 * Sample Output
 * 
 * 0.500000 0.333333 0.166667
 * 
 * Explanation 
 * There are 3 positive numbers, 2 negative numbers, and 1 zero in
 * the array. The fraction of the positive numbers, negative numbers and zeroes
 * are 3/6=0.500000, 26=0.33333326=0.333333 and
 * 16=0.16666716=0.166667, respectively.
 * 
 * Note: This challenge introduces precision problems. The test cases are scaled
 * to six decimal places, though answers with absolute error of up to 10−410−4
 * are acceptable.
 * 
 */

public class Plus_Minus {

    public static void main(String[] args) {
    	float pos_count=0.0f, neg_count =0.0f;
        Scanner in = new Scanner(System.in); 
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        
        /* Read through the array, use ternary to increase positive and negative counters as you see the respective number. */
        float a=0;
        for(int a_i=0; a_i<n; a_i++){
        	 
        	// The zero count is mutually exclusive
        	 if(arr[a_i]!= 0){
        		 a = (0 < arr[a_i]) ? pos_count++ : neg_count++;
        	 }
        }
        System.out.println((pos_count/n));
        System.out.println((neg_count/n));
        System.out.println(((n-(pos_count+neg_count))/n));
    }
}

