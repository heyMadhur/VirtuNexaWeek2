package com.virtunexa;

import com.virtunexa.Database.DatabaseManager;

import java.util.Scanner;

public class CLIFrontend {
    public static void start() {
        Scanner sc= new Scanner(System.in);

        System.out.println("-------- Welcome to VirtuNexa Binary Converter --------");

        System.out.print("\nEnter your username: ");
        String username = sc.nextLine();

        System.out.println("\nInstructions-:");
        System.out.println("1. Do not use spaces in Binary Number.");
        System.out.println("2. To view conversion history, type \"history\".");
        System.out.println("3. To exit, type \"exit\".");

        while(true) {
            System.out.print("\nEnter input: ");
            String input = sc.next();
            if(input.equalsIgnoreCase("exit")) {
                System.out.println("\n\nHope you liked it.....");
                System.out.println("Developed By- Madhur Gupta");
                System.out.println("Exiting...");
                sc.close();
                System.exit(1);
            } else if (input.equalsIgnoreCase("history")) {
                // Display conversion history
                DatabaseManager.showConversionHistory();
            } else {
                try {
                    int decimal= BinaryConverter.toDecimel(input);
                    System.out.println("Decimal Equivalent is: "+decimal);

                    DatabaseManager.insertConversion(username, input, decimal);

                } catch (IllegalArgumentException e) {
                    System.out.println("Error: "+e.getMessage());
                }
            }
        }

    }
}
