/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.manage;
import java.io.BufferedReader;
import java.util.Scanner;

/**
 *
 * @author acer
 */
public class Lab3_main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        manage manage = new manage();

        
        while(true){

                System.out.print("Do you want to do ex-number(ex: 1->13, 0 to exit): ");
                int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    manage.Ex1("Exercise 1: The sum of all numbers from 1 to n.");
                    break;
                case 2:
                    manage.Ex2("Exercise 2: The minimum element in the array");
                    break;
                case 3:
                    manage.Ex3("Exercise 3: The sum of all element in the array");
                    break;
                case 4:
                    manage.Ex4("Exercise 4: An array is a palindrome?");
                    break;
                case 5:
                    manage.Ex5("Exercise 5: Search for a target in a sorted array using binary search");
                    break;
                case 6:
                     manage.Ex6("Exercise 6: Find GCD");
                     break;
                case 7:
                    manage.Ex7("Exercise 7: The power function");
                    break;
                case 8:
                    manage.Ex8("Exercise 8: The factorial function");
                    break;
                case 9:
                    manage.Ex9("Exercise 9: Fibonacci");
                    break;
                case 10:
                    manage.Ex10("Exexrcise 10: Sum of the first n reciprocals");
                    break;
                case 11:
                    manage.Ex11("Exexrcise 11: Stirling numbers of the first kind");
                    break;
                case 12:
                    manage.Ex12("Exercise 12: Tree height");
                    break;
                case 13:
                    manage.Ex13("Exercise 13: Tree size");
                    break;
                case 0:
                    System.exit(0);
            }
        }

    }

    
    
}
