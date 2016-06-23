package hackerrank.postwarmup;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Vaild_Parantheses {

    public static void main(String[] args) {
                
        //STDIN to read input
//        Scanner stdio = new Scanner(System.in);
        
//        int tests = stdio.nextInt();
        boolean result = false;
        String testString = "";
        char[] testParantheses;
        // Iterate through no of testcases
//        for(int i=1; i <= tests; i++){
            
            // Receive test string
//            testString = stdio.nextLine();
            
            testString = "{{[[[(())]]}}";
            testString = "{[(])}";
//        }{
            
            // Split input into a char array
            testParantheses = testString.toCharArray();
//            		.split("");
                      
            //result = isParanValid(testParantheses);
            if(isParanValid(testParantheses)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            
//        }
        
    }
    
    // Method to determine validity of the parantheses in a string
    public static boolean isParanValid(char[] testParan){
        Stack<Character> paranStack = new Stack<Character>();
        
        // Odd length string have an inherent mismatch
        if((testParan.length % 2)  != 0){
            return false;
        }
        
        // Iterate over the array and push open brackets and compare close brackets with last pushed brackets
        for(int j =0; j < testParan.length; j++){
            
            // If any of { or [ or ( push into stack
            if((testParan[j] == '{') || (testParan[j] == '(') || (testParan[j] == '[')){
                paranStack.push(testParan[j]);
            }
            else{
                
                // If not empty pop last element and compare 
                if(!paranStack.isEmpty()){
                    if(!(paranStack.pop() == testParan[j])){
                        return false;
                    }
                }
                // You have a close bracket with the Stack empty then its a invalid condition
                else{
                    return false;
                }
              }
           }
        
        if(paranStack.isEmpty()){
            return true;
        }else{
           return false; 
        }
           
        }
         
   
    
    
}