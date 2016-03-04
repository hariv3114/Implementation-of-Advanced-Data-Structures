package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.Math;

public class ArrayDiagonalSum {

    public static void main(String[] args) {
    	
    	int prim_diag_sum = 0;
    	int sec_diag_sum = 0;
    	
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        
        /* Calculate the primary diagonal */
        for (int i = 0,j=0; i < a.length; i++) {
        	prim_diag_sum = prim_diag_sum + a[i][j];
        	j++;
		}
        
        /* Calculate the secondary diagonal */
        for(int s_i=n-1,s_j=0; s_i >= 0; s_i--){
        	sec_diag_sum = sec_diag_sum + a[s_i][s_j];
        	s_j++;
        }
        
        /* Calculate the absolute difference */
        int abs_diff = Math.abs(prim_diag_sum-sec_diag_sum);
        
        System.out.println(+abs_diff);
    }
}