/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_csd201;

import java.util.LinkedList;
import java.util.Scanner;

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

    public void addBook(String bid, String title, String author, int status) {
        Book book = new Book(bid, title, author, status);
        bookList.add(book);
    }

    public void viewBooks() {
        System.out.println("Bid\t| Title\t\t| Author\t\t| Status");
        System.out.println("---------------------------------------------");
        for (Book book : bookList) {
            System.out.printf("%s\t| %s\t\t| %s\t\t| %d\n", book.bid, book.title, book.author, book.status);
        }
    }

    public void deleteBook(String bid) {
        for (Book book : bookList) {
            if (book.bid.equals(bid)) {
                bookList.remove(book);
                System.out.println("Book deleted successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void borrowBook(String bid) {
        for (Book book : bookList) {
            if (book.bid.equals(bid)) {
                if (book.status == 0) {
                    book.status = 1;
                    borrowedList.add(book);
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Book is not available for borrowing.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String bid) {
        for (Book book : borrowedList) {
            if (book.bid.equals(bid)) {
                book.status = 0;
                borrowedList.remove(book);
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System Menu");
            System.out.println("1. Add book");
            System.out.println("2. View books");
            System.out.println("3. Delete book");
            System.out.println("4. Borrow book");
            System.out.println("5. Return book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    String bid = scanner.next();
                    System.out.print("Enter book title: ");
                    String title = scanner.next();
                    System.out.print("Enter author name: ");
                    String author = scanner.next();
                    scanner.nextLine();
                    int status = 0; // Assuming all books are initially available
                    lms.addBook(bid, title, author, status);
                    break;
                case 2:
                    lms.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter book ID to delete: ");
                    bid = scanner.next();
                    lms.deleteBook(bid);
                    break;
                case 4:
                    System.out.print("Enter book ID to borrow: ");
                    bid = scanner.next();
                    lms.borrowBook(bid);
                    break;
                case 5:
                    System.out.print("Enter book ID to return: ");
                    bid = scanner.next();
                    lms.returnBook(bid);
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
    
}
