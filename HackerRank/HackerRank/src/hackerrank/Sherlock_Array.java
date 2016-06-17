package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Русский \| 中文 Watson gives Sherlock an array of length . Then he asks him to
 * determine if there exists an element in the array such that the sum of the
 * elements on its left is equal to the sum of the elements on its right. If
 * there are no elements to the left/right, then the sum is considered to be
 * zero. Formally, find an , such that, 12i-1 i+1i+2N.
 * 
 * Input Format The first line contains , the number of test cases. For each
 * test case, the first line contains , the number of elements in the array .
 * The second line for each test case contains space-separated integers,
 * denoting the array .
 * 
 * Output Format For each test case print YES if there exists an element in the
 * array, such that the sum of the elements on its left is equal to the sum of
 * the elements on its right; otherwise print NO.
 * 
 * Constraints
 * 
 * 
 * i
 * 
 * Sample Input
 * 
 * 2 3 1 2 3 4 1 2 3 3 Sample Output
 * 
 * NO YES Explanation For the first test case, no such index exists. For the
 * second test case, , therefore index satisfies the given conditions.
 * 
 * 
 */

public class Sherlock_Array {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner input = new Scanner(System.in);

		// No. of Testcases
		int testCases = Integer.parseInt(input.nextLine());

		// Iterate for every testcase
		for (int i = 1; i <= testCases; i++) {

			// Number of inputs
			int inArrLen = Integer.parseInt(input.nextLine());

			// Read next line of input
			String inputArr = input.nextLine();

			// Extract input as as Array
			String[] inputArray = inputArr.split(" ");

			// Initialise an int array for the given size
			int[] intArray = new int[inputArray.length];

			// Iterate through the String nd extract the integers
			for (int j = 0; j < inputArray.length; j++) {
				intArray[j] = Integer.parseInt(inputArray[j]);
			}

			if (doesItSplit(intArray)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}

	// Method to check if there exists an index in the array that splits the sum
	// on either sides equally
	public static boolean doesItSplit(int[] inputArray) {

		int sum = 0;

		// Find Sum of array elements
		for (int j = 0; j < inputArray.length; j++) {
			sum += inputArray[j];
		}

		// Subtract sum from leftmost index parallely saving the sum from the
		// left index.
		// Point where the diminished sum and the leftArray sum is equal gives
		// us the required index

		int leftSum = 0;
		int rightSum = sum;

		for (int k = 0; k < inputArray.length; k++) {

			// Decrease right sum by left index value
			rightSum -= inputArray[k];

			// If at given index the right sum is equal to the left sum, we
			// infer that this index splits the array into equal sums
			if (rightSum == leftSum) {
				return true;
			} else {
				leftSum += inputArray[k];
			}
		}

		return false;
	}

}