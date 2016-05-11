package hackerrank.stringbased;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/***
 * Problem Statement (Copyright belong to Hackerrank Inc.)
 * 
 * Shashank likes strings in which consecutive characters are
 * different. For example, he likes ABABA, while he doesn't like ABAA. Given a
 * string containing characters AA and BB only, he wants to change it into a
 * string he likes. To do this, he is allowed to delete the characters in the
 * string.
 * 
 * Your task is to find the minimum number of required deletions.
 * 
 * Input Format
 * 
 * The first line contains an integer TT, i.e. the number of test cases. The
 * next TT lines contain a string each.
 * 
 * Output Format
 * 
 * For each test case, print the minimum number of deletions required.
 * 
 * Constraints
 * 
 * 1≤T≤101≤T≤10 1≤1≤ length of string ≤105≤105 Sample Input
 * 
 * 5 AAAA BBBBB ABABABAB BABABA AAABBB Sample Output
 * 
 * 3 4 0 0 4 Explanation
 * 
 * AAAA ⟹⟹ A, 3 deletions BBBBB ⟹⟹ B, 4 deletions ABABABAB ⟹⟹ ABABABAB, 0
 * deletions BABABA ⟹⟹ BABABA, 0 deletions AAABBB ⟹⟹ AB, 4 deletions because to
 * convert it to AB we need to delete 2 A's and 2 B's
 * 
 * 
 * 
 ***/

public class StringDeletions {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // Scan the inputs from command line
        Scanner scanner = new Scanner(System.in);
         
        int testCases = Integer.parseInt(scanner.next());
        
        // Loop into the number of inputs
        for(int i =0; i < testCases; i++){
            String input = scanner.next();
            System.out.println(deletionCount(input.toCharArray()));
        }     
     }
    
    public static int deletionCount(char[] inputStringAsArray){
        int count = 0;
        System.out.println("");
        for(int i = 1; i < inputStringAsArray.length-1; i++){
            if((inputStringAsArray[i] == inputStringAsArray[i+1])){
                count++;
            }
            System.out.println("I: "+i);
        }
        return count;
    }
}
