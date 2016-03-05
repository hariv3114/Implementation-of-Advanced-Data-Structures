package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Given a time in AM/PM format, convert it to military (24-hour) time.
 * 
 * Note: Midnight is 12:00:00AM on a 12-hour clock and 00:00:00 on a 24-hour
 * clock. Noon is 12:00:00PM on a 12-hour clock and 12:00:00 on a 24-hour clock.
 * 
 * Input Format
 * 
 * A time in 12-hour clock format (i.e.: hh:mm:ssAM or hh:mm:ssPM), where
 * 01≤h≤12
 * 
 * Output Format
 * 
 * Convert and print the given time in 24-hour format, where 00≤hh≤2300≤hh≤23.
 * 
 * Sample Input
 * 07:05:45PM
 * 
 * Sample Output  
 * 19:05:45
 * 
 * Explanation
 * 
 * 7 PM is after noon, so you need to add 12 hours to it during conversion. 12 +
 * 7 = 19. Minutes and seconds do not change in 12-24 hour time conversions, so
 * the answer is 19:05:45.
 * 
 *
 */

public class TimeConversion {
	
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String time = in.next();
	        
	        // Set format for input and output
	        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ssa");
	        SimpleDateFormat out = new  SimpleDateFormat("HH:mm:ss");
	        
	        try {
				Date inTime = sdf.parse(time);
				System.out.println(out.format(inTime));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

}
