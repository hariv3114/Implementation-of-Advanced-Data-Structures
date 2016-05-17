package hackerrank.stringbased;

/**
 * Pangrams 
 * 
 * Roy wanted to increase his typing speed for programming contests.
 * So, his friend advised him to type the sentence
 * "The quick brown fox jumps over the lazy dog" repeatedly, because it is a
 * pangram. (Pangrams are sentences constructed by using every letter of the
 * alphabet at least once.)
 * 
 * After typing the sentence several times, Roy became bored with it. So he
 * started to look for other pangrams.
 * 
 * Given a sentence s, tell Roy if it is a pangram or not.
 * 
 * Input Format
 * 
 * Input consists of a string ss.
 * 
 * Constraints Length of s can be at most 10^3 (1≤|s|≤10^3)(1≤|s|≤10^3) and it
 * may contain spaces, lower case and upper case letters. Lower-case and
 * upper-case instances of a letter are considered the same.
 * 
 * Output Format
 * 
 * Output a line containing pangram if s is a pangram, otherwise output not
 * pangram.
 * 
 **/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Pangrams {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		String inputString = "";
		inputString = inputScanner.nextLine();
		if(inputString != null){
			if (isPangrams(inputString)) {
				System.out.println("not pangram");
			} else {
				System.out.println("pangram");
			}
		}
	}

	/* Method takes in a String and returns boolean if its a Pangram or not */

	public static boolean isPangrams(String testString) {

		HashSet<Character> alphabetSet = new HashSet<Character>();
		char[] testArray = testString.toCharArray();
		for (int i = 0; i < testArray.length; i++) {
			if (isAlpha(testArray[i])) {
				alphabetSet.add(Character.toLowerCase(testArray[i]));
			}
		}
		if (!(alphabetSet.size() < 26)) {
			return false;
		}
		return true;
	}

	/** Method that takes in a character and returns true if its an alphabet **/
	public static boolean isAlpha(char a) {
		if (a != ' ') {
			// Ascii range of alphabets is UpperCase (65,90) and Lowercase
			// (97,122)
			if ((a > 64 && a < 91) || (a > 96 && a < 123)) {

				return true;
			}
		}
		return false;
	}
}
