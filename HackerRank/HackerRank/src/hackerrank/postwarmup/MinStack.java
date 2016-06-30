package hackerrank.postwarmup;

/***
 * 
 * Min case yet to be completely handled
 * 
 * */

public class MinStack {

    /** initialize your data structure here. */
    
    int[] stack;
    int top =0;
    int maxLen =0;
    int minElem =0;
    
    public MinStack() {
        this.stack = new int[10];
    }
    
    public void push(int x) {
        
        // Check for Stack Limit
        if(this.top == (this.maxLen-1)){
            increaseArraySize();
        }
        
        // Push the element to the top
        this.stack[top] = x;
        
        // Update the top
        this.top = this.top + 1;
        
        // Update Min
        if(x < this.minElem){
            this.minElem = x;
        }
        
    }
    
    public void pop() {
        this.top = this.top -1;
    }
    
    public int top() {
        return this.stack[this.top-1];
    }
    
    public int getMin() {
        return this.minElem;
    }
    
    /** When the stack size approaches limit we double the size and copy the contents to the new array **/
    public void increaseArraySize(){
        int[] newArray = new int[this.maxLen*2];
        
        this.maxLen = this.maxLen * 2;
        
        /* Copy contents of old array to new */
        for(int i = 0; i < this.stack.length; i++){
            newArray[i] = this.stack[i];
        }
        
        this.stack = newArray;
    }
    
 
}
