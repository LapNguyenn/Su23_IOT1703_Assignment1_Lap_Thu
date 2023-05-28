/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author lap21
 */
public class Stack {
    private Node arr[];
    private int top;
    private int maxSize;    
    public Stack() {
        this(50);
    }

    public Stack(int max) {
        this.maxSize = max;
        this.arr = new Node[this.maxSize];
        this.top = -1;
    }
    public boolean isEmpty() {
        return (this.top < 0);
    }
    public boolean isFull() {
        return (this.top == this.maxSize);
    }
    public void push(Node x) {
        if(isFull()){
            System.out.println("Stack Full");
            return;
        }
        arr[++top] = x;
    }
    public Node pop() {
        if(isEmpty()){
            System.out.println("Empty Stack!");
            return null;
        }
        Node dataPop = arr[top];
        arr[top--] = null;
        return dataPop;
    }
}
