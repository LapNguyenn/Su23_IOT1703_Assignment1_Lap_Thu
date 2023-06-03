/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.LinkedList;
import model.Book;
import view.GetValidInput;

/**
 *
 * @author acer
 */
public class LibraryManagementSystem {

    LinkedList<Book> bookList;
    LinkedList<Book> borrowedList;

    public LibraryManagementSystem() {
        bookList = new LinkedList<>();
        borrowedList = new LinkedList<>();
    }
    
    public boolean checkBidExistBookList(String bid){
        for (Book book : bookList) {
            if(book.bid.equalsIgnoreCase(bid)){
                System.out.println("Found " + (char)27 + "[33m" + book.bid + (char)27 + "[0m");
                return true;
            }
        }
        return false;
    }
    public boolean checkBidExistBorrowedList(String bid){
        for (Book book : borrowedList) {
            if(book.bid.equalsIgnoreCase(bid)){
                return true;
            }
        }
        return false;
    }
    public void addBook() {
        String bid = "";
        do {
           bid = GetValidInput.getString("Enter book ID: ", "ID invalid");
        }
        while(checkBidExistBookList(bid));
        String title = GetValidInput.getString("Enter book title: ", "Title invalid");
        String author = GetValidInput.getStringByRegex("Enter author name: ", "Name invalid!", "[0-9A-Za-z\\s.]+");
        int status = 0; // Assuming all books are initially available
        Book book = new Book(bid, title, author, status);
        bookList.add(book);
        
    }

    public void viewBooks() {
        System.out.print((char)27 + "[33m");
        System.out.printf("%-5s| %-12s| %-30s| %s\n","Bid","Title","Author","Status");
        System.out.print((char)27 + "[35m");
        System.out.println("-----------------------------------------------------------");
        for (Book book : bookList) {
            if(book.status == 1){
                System.out.print((char)27 + "[36m");
            }else{
                System.out.print((char)27 + "[32m");
            }
            System.out.printf("%-5s| %-12s| %-30s| %d\n", book.bid, book.title, book.author, book.status);
        }
        System.out.print((char)27 + "[0m");
    }

    public void deleteBook() {
        String bid = GetValidInput.getString("Enter book ID to delete: ", "ID invalid");
        
        if(checkBidExistBookList(bid)){ //If book exists
            if(checkBidExistBorrowedList(bid)){ //If book is borrowed
                System.out.println((char)27 + "[33m" + bid + " is borrowed by some one, do you want to continue delete?" + (char)27 + "[0m");
                String choice = GetValidInput.getStringByRegex("(Y/N): ", "Enter Y/y or N/n", "[YyNn]");
                if(choice.equalsIgnoreCase("Y")){
                    for (Book book : bookList) {
                        if (book.bid.equalsIgnoreCase(bid)) {
                            bookList.remove(book);
                            System.out.println((char)27 + "[32m" + bid + " Book deleted successfully." + (char)27 + "[0m");
                            return;
                        }   
                    }
                }
                else{
                    System.out.println("Not deleted.");
                }
            }
            else {
                for (Book book : bookList) {
                        if (book.bid.equalsIgnoreCase(bid)) {
                        bookList.remove(book);
                        System.out.println((char)27 + "[32m" + bid+" Book deleted successfully." + (char)27 + "[0m");
                        return;
                        }   
                    }
            }
        }
        else{
            System.out.println("Book not found.");
        }
        
    }

    public void borrowBook() {
        String bid = GetValidInput.getString("Enter book ID to borrow: ", "ID invalid");
        for (Book book : bookList) {
            if (book.bid.equalsIgnoreCase(bid)) {
                if (book.status == 0) {
                    book.status = 1;
                    borrowedList.add(book);
                    System.out.println((char)27 + "[32m" + "Book borrowed successfully." + (char)27 + "[0m");
                } else {
                    System.out.println((char)27 + "[31m" + "Book is not available for borrowing." + (char)27 + "[0m");
                }
                return;
            }
        }
        System.out.println((char)27 + "[31m" + "Book does not exist." + (char)27 + "[0m");
    }

    public void returnBook() {
        String bid = GetValidInput.getString("Enter book ID to return: ", "ID invalid");
        if (checkBidExistBookList(bid)) {
            for (Book book : borrowedList) {
                if (book.bid.equalsIgnoreCase(bid)) {
                        book.status = 0;
                        borrowedList.remove(book);
                        System.out.println((char)27 + "[32m" + "Book returned successfully." + (char)27 + "[0m");
                        return;
                }
            }
            System.out.println((char)27 + "[31m" + "Book was not borrowed." + (char)27 + "[0m");
        }
        else System.out.println((char)27 + "[31m" + "Book does not exist." + (char)27 + "[0m");
    }

    public void generateTempValue() {
        bookList.add(new Book("B01", "Physics", "Michael G. Solomon", 0));
        bookList.add(new Book("B02", "Biology", "Andreas M. Antonopoulos", 0));
        bookList.add(new Book("B03", "Southern", "Tiana Laurence", 0));
    }
}

