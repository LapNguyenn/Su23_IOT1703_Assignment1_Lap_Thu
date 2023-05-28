/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;
import tree.Node;
/**
 *
 * @author lap21
 */
public class Queue {
    ////////-----DECLARE-----///////////
    protected  Node head, tail;
    
    public Queue() {
        this.head = this.tail = null;
    }

    public Queue(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }
    public boolean isEmpty() {
        return (this.head == null);
    }
    public void enqueue(Node x) {
        if(isEmpty()){
            head = tail = x;
        }else{
            this.tail.next = x;
            this.tail = x;
        }
    }
    public Node first() {
        return this.head;
    }
    public Node dequeue() {
        Node firstNode = this.head;
        Node tempNode = this.head.next;
        this.head = null;
        this.head = tempNode;
        return firstNode;
    }   
}
