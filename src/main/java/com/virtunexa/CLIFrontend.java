package com.virtunexa;

import java.util.Scanner;

public class CLIFrontend {
    public static void start() {
        Scanner sc= new Scanner(System.in);

        System.out.println("-------- Welcome to VirtuNexa Binary Converter --------");

        System.out.println("\nInstructions-:\n1. Do not use spaces in Binary Number.\n2. To exit type \"exit\"");

        while(true) {
            System.out.print("\nEnter a Binary Number: ");
            String binary= sc.next();
            if(binary.equals("exit")) {
                System.out.println("\n\nHope you liked it.....");
                System.out.println("Developed By- Madhur Gupta");
                System.out.println("Exiting...");
                sc.close();
                System.exit(1);
            }
            try {
                int decimal= BinaryConverter.toDecimel(binary);
                System.out.println("Decimal Equivalent is: "+decimal);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: "+e.getMessage());
            }
        }

    }
}
