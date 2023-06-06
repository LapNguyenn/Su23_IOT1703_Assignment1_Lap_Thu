/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetValidInput {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static int getInt(String msg, String err, int min, int max) {
        // regex to match any double or float 
        String regex = "^(\\d+)[.](\\d+)$";
        while (true) {
            try {
                System.out.print(msg);
                String input = in.readLine();
                if (input.matches(regex)) {
                    System.out.println((char)27 + "[31m" + "Input must be an integer!" + (char)27 + "[0m");
                } else {
                    int intOutput = Integer.parseInt(input);
                    if (intOutput < min || intOutput > max) {
                        System.out.println((char)27 + "[31m" + "Input must be in range [" + min + "," + max + "]" + (char)27 + "[0m");
                    } else {
                        return intOutput;
                    }
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println((char)27 + "[31m" + err + (char)27 + "[0m");
            }
        }
    }

    public static String getString(String msg, String err) {
        while (true) {
            try {
                System.out.print(msg);
                String input = in.readLine();
                if(input.equals("")) {
                    System.out.println((char)27 + "[31m" + "Input can't be empty" + (char)27 + "[0m");
                }
                else
                    return input;
            } catch(IOException e) {
                System.out.println((char)27 + "[31m" + err + (char)27 + "[0m");
            }
        }
        
    }

    public static String getStringByRegex(String msg, String err, String regex) {
        while (true) {
            try {
                System.out.print(msg);
                String str = in.readLine();
                if (str.matches(regex)) {
                    return str;
                }
            } catch (IOException ex) {
                System.out.println((char)27 + "[31m" + "IOException" + (char)27 + "[0m");
            }
            System.out.println((char)27 + "[31m" + err + (char)27 + "[0m");
        }
    }

    
}