package Stack;

/**
 *
 * @author lap21
 */
public class StackArray implements Q1_stack{
    //////////-------DECLARE---------//////////////
    private Object arr[];
    private int top;
    private int maxSize;

    public StackArray() {
        this(50);
    }

    public StackArray(int max) {
        this.maxSize = max;
        this.arr = new Object[this.maxSize];
        this.top = -1;
    }
    
    
            
    
    //////////-------FUNCTION---------//////////////
    @Override//return true if the stack is empty and false otherwise.
    public boolean isEmpty() {
        return (this.top < 0);
    }
    public boolean isFull() {
        return (this.top == this.maxSize);
    }

    @Override//clear the stack.
    public void clear() {
        while (!isEmpty()) {            
            this.pop();
        }
    }

    @Override//insert  a node with value  x  at the top of  the stack.
    public void push(Object x) {
        if(isFull()){
            System.out.println("Stack Full");
            return;
        }
        arr[++top] = x;
    }

    @Override//remove the top element on the stack and return it's value; throw EmptyStackException for empty stack
    public Object pop() {
        if(isEmpty()){
            System.out.println("Empty Stack!");
            return null;
        }
        Object dataPop = arr[top];
        arr[top--] = null;
        return dataPop;
    }

    @Override//return value of a node at the top of the stack; throw EmptyStackException for empty stack
    public Object top() {
        return this.arr[this.top];
    }

    @Override//display all values in the stack from the top to the bottom.
    public void traverse() {
        if(isEmpty()){
            System.out.println("Empty stack");
            return;
        }
        for (Object object : arr) {
            if(object == null){
                break;
            }
            System.out.print(object + " ");
        }
        System.out.println("");
    }

    @Override//Use a stack to convert an integer number in decimal system to binary system and display on the screen
    public String DecToBin(int dec) {
        int stopFlag = top;
        while(dec != 0 && !isFull()){
            this.push(dec%2);
            dec/= 2;
            if(isFull()){
                System.out.println("FULL EMPTY, CAN'T CONTINUE");
            }        
        }
        String bin = "";
        while(top > stopFlag){
            bin+= this.pop();
        }
        return bin;
    }
    
}
