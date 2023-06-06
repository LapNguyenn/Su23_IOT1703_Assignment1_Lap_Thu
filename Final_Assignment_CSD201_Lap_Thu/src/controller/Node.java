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
public class Node {
    public Book data;
    public Node next;
    
    public Node(Book info) {
        this.data = info;
        this.next = null;
    }
}
