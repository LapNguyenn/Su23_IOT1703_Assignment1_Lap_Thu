/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Book;
import view.GetValidInput;

/**
 *
 * @author acer
 */
public class LibraryManagementSystem {

    LinkedList bookList = new LinkedList();
    LinkedList borrowedList = new LinkedList();

    public LibraryManagementSystem() {
        bookList = new LinkedList();
        borrowedList = new LinkedList();
    }
    public String checkDataExistBookList(String title, String author){
        for (Node book = bookList.getHead(); book != null; book = book.next) {
            if(book.data.title.equalsIgnoreCase(title) && book.data.author.equalsIgnoreCase(author)){
                return book.data.bid;
            }
        }
        return null; 
    }
    public boolean checkBidExistBookList(String bid){
        for (Node book = bookList.getHead(); book != null; book = book.next) {
            if(book.data.bid.equalsIgnoreCase(bid)){
                return true;
            }
        }
        return false;
    }
    public boolean checkBidExistBorrowedList(String bid){
        for (Node book = borrowedList.getHead(); book != null; book = book.next) {
            if(book.data.bid.equalsIgnoreCase(bid)){
                return true;
            }
        }
        return false;
    }
    public void addBook() {
        String bid = "";
        boolean check = true;
        do {
           bid = GetValidInput.getString("Enter book ID: ", "ID invalid");
           check = checkBidExistBookList(bid);
           if(check){
               System.out.println((char)27 + "[31m" + bid + " existing in list!" + (char)27 + "[0m");
           }
        }
        while(check);
        String title = GetValidInput.getString("Enter book title: ", "Title invalid");
        String author = GetValidInput.getStringByRegex("Enter author name: ", "Name invalid!", "[0-9A-Za-z\\s.]+");
        int status = 0; // Assuming all books are initially available
        Book book = new Book(bid, title, author, status);
        String checkData = checkDataExistBookList(title, author);
        if(checkData != null){
            System.out.println((char)27 + "[33m" + "This book is already exist with bid " + checkData);
            System.out.println("Do you want to continue adding?");
            String choice = GetValidInput.getStringByRegex("(Y/N): ", "Enter Y/y or N/n", "[YyNn]");
            if(choice.equalsIgnoreCase("Y")){
                bookList.add(book);
            }else{
                System.out.println("Not added.");
            }
        }else{
            bookList.add(book);
        }
    }

    public void viewBooks() {
        bookList.printList();
    }

    public void deleteBook() {
        String bid = GetValidInput.getString("Enter book ID to delete: ", "ID invalid");
        
        if(checkBidExistBookList(bid)){ //If book exists
            if(checkBidExistBorrowedList(bid)){ //If book is borrowed
                System.out.println((char)27 + "[33m" + bid + " is borrowed by some one, do you want to continue delete?" + (char)27 + "[0m");
                String choice = GetValidInput.getStringByRegex("(Y/N): ", "Enter Y/y or N/n", "[YyNn]");
                if(choice.equalsIgnoreCase("Y")){
                    for (Node book = bookList.getHead(); book != null; book = book.next) {
                        if (book.data.bid.equalsIgnoreCase(bid)) {
                            bookList.remove(book.data);
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
                for (Node book = bookList.getHead(); book != null; book = book.next) {
                        if (book.data.bid.equalsIgnoreCase(bid)) {
                        bookList.remove(book.data);
                        System.out.println((char)27 + "[32m" + bid+" Book deleted successfully." + (char)27 + "[0m");
                        return;
                        }   
                    }
            }
        }
        else{
            System.out.println((char)27 + "[31m" + "Book " + bid + " not found."+ (char)27 + "[0m");
        }
        
    }

    public void borrowBook() {
        String bid = GetValidInput.getString("Enter book ID to borrow: ", "ID invalid");
        for (Node book = bookList.getHead(); book != null; book = book.next) {
            if (book.data.bid.equalsIgnoreCase(bid)) {
                if (book.data.status == 0) {
                    book.data.status = 1;
                    borrowedList.add(book.data);
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
            for (Node book = borrowedList.getHead(); book != null; book = book.next) {
                if (book.data.bid.equalsIgnoreCase(bid)) {
                        book.data.status = 0;
                        borrowedList.remove(book.data);
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

