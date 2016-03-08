package hackerrank.postwarmup;

import java.util.Scanner;

public class Sherlocks_Beast {
	
public static void main(String args[]){
	
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int a0 = 0; a0 < t; a0++){
        int n = in.nextInt();
        
        int mod_3 = n % 3;
      
        if(!(n<3)){
              if(mod_3 == 0){
            for(int i =0;i<n;i++){
                System.out.print("5");
            }
            System.out.println("");
        }else if(mod_3 == 1){
            
        	if((n-10) >= 0){
        		for(int i =0;i<n-10;i++){
        			System.out.print("5");
        		}
        		System.out.println("3333333333");
        	}else{
        		System.out.println("-1");
        	}
        	
        }else if(mod_3 == 2){
            
        	if((n-5) >= 0){
        		for(int i =0;i<n-10;i++){
        			System.out.print("5");
        		}
        		System.out.println("33333");
        	}
        	else{
        		System.out.println("-1");
        	}
        	
           
             
        }
        }else{
            System.out.println("-1");
        }
        
        
    }
	
}

}
