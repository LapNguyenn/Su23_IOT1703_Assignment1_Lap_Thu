/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Book;

/**
 *
 * @author lap21
 */
public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public Node getHead() {
        return head;
    }
    
    boolean isEmpty(){
        return this.head == null;
    }
    public int getSize(){
        return this.size;
    }
    public void add(Book data){
        Node newNode = new Node(data);
        Node currentNode = this.head;
        if(isEmpty()){
            this.head = newNode;
            this.head.next = null;
            return;
        }
        while (true) {            
            if(currentNode.next == null){
                currentNode.next = newNode;
                this.size++;
                break;
            }else{
                currentNode = currentNode.next;
            }
        }
    }
    public void remove(Book x) {
        Node currentNode = this.head;
        if(currentNode.data == x){
            this.head = this.head.next;
            return;
        }
        while (true) {            
            if(currentNode.next.data == x){
                currentNode.next = currentNode.next.next;
                this.size--;
                break;
            }else{
                currentNode = currentNode.next;
            }
        }
    }
    void printList(){
        System.out.print((char)27 + "[35m");
        System.out.println("///////////////////////////////////////////////////////////////////");
        System.out.print((char)27 + "[33m");
        System.out.printf("%-5s| %-15s| %-35s| %s\n","Bid","Title","Author","Status");
        System.out.print((char)27 + "[35m");
        System.out.println("-------------------------------------------------------------------");
        for (Node book = this.head; book != null; book = book.next) {
            if(book.data.status == 1){
                System.out.print((char)27 + "[36m");
            }else{
                System.out.print((char)27 + "[32m");
            }
            System.out.printf("%-5s| %-15s| %-35s| %d\n", book.data.bid, book.data.title, book.data.author, book.data.status);
        }
        System.out.print((char)27 + "[35m");
        System.out.println("///////////////////////////////////////////////////////////////////");
        System.out.print((char)27 + "[0m");
    }
}
