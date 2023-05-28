/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_csd201;

/**
 *
 * @author acer
 */
public class Book {
    String bid;
    String title;
    String author;
    int status;

    public Book(String bid, String title, String author, int status) {
        this.bid = bid;
        this.title = title;
        this.author = author;
        this.status = status;
    }
}
