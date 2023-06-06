/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LibraryManagementSystem;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 *
 * @author acer
 */
public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        lms.generateTempValue();
        while(true){
            displayMenu();
            int choice = GetValidInput.getInt("Enter your choice: ", "Input can't be a string", 0, 5);
            switch (choice) {
                case 1:                  
                    lms.addBook();
                    break;
                case 2:
                    lms.viewBooks();
                    break;
                case 3:                   
                    lms.deleteBook();
                    break;
                case 4:
                    lms.borrowBook();
                    break;
                case 5:
                    lms.returnBook();
                    break;
                case 0:
                    System.exit(0);
                    break;
                   
            }
        } 
    }

    private static final void displayMenu() {
            System.out.format("\nLibrary Management System Menu\n"
                    + "1. Add book\n"
                    + "2. View books\n"
                    + "3. Delete book\n"
                    + "4. Borrow book\n"
                    + "5. Return book\n"
                    + "0. Exit\n");
    }
}
