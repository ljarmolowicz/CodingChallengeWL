package com.ljarmolowicz.challenge;

import static com.ljarmolowicz.challenge.Wrapper.wrap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class WordWrapChallenge {
    
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter the text you need wrapped:");
        
        String input = scanner.nextLine();
        
        Integer length = null;
        
        while (length == null) {
            System.out.print("Please enter the max length per line: ");
            
            try {
                length = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Line length must be an integer value.");
                scanner.next();
            }
        }
        
        System.out.println("Here is your wrapped text:");
        System.out.println(wrap(input, length));
    }
    
}
