# Binary Converter Application

## Overview

This project is a Java-based application designed to convert binary numbers into their decimal equivalents. It’s a simple tool that not only performs the conversion but also keeps track of your conversion history by storing each conversion along with your username. The project uses Maven for dependency management and building, and an H2 database (in file mode) for storing conversion records.

## Features

- **Binary to Decimal Conversion:**  
  Quickly convert binary numbers (like "1010") to their decimal form (like 10).

- **Conversion History:**  
  Every conversion you make is saved along with your username and the date/time of the conversion. You can view your entire conversion history at any time.

- **User-Friendly CLI:**  
  The application runs from the command line, guiding you through the process with simple instructions.

- **Error Handling:**  
  The program checks your input to make sure it’s a valid binary number and provides clear feedback if something’s off.

## Setup

### Prerequisites

- **Java JDK:** Version 22 or later is required.
- **Maven:** Used to compile, package, and run the project.
- **H2 Database:** The application uses H2 in file mode, and Maven manages this dependency automatically.

### Installation Steps

1. **Download or Clone the Repository:**  
   Get the project files onto your computer.

2. **Navigate to the Project Directory:**  
   Open your terminal or PowerShell and use the `cd` command to move into the project folder (where the `pom.xml` file is located).

3. **Build the Project:**  
   Run the following command to compile the code and package it:
   ```bash
   mvn clean package
   ```
   This command creates a JAR file in the `target` directory.

4. **Run the Application:**  
   To run the application with all necessary dependencies, use the following command in PowerShell:
   ```powershell
   mvn --% exec:java -Dexec.mainClass=com.virtunexa.Main
   ```
   (Note: In CMD you might need different quoting or configuration, but I’ve confirmed that PowerShell works well.)

## Usage

Once the application is running, you’ll see a welcome message and some simple instructions. Here’s how it works:

1. **Enter Your Username:**  
   The application first asks for your username to keep track of your conversion history.

2. **Conversion Instructions:**
    - **To Convert:** Simply type a binary number (e.g., `1010`) when prompted.
    - **View History:** Type `history` to see all your previous conversions.
    - **Exit:** Type `exit` to close the application.

### Example Interaction

```
-------- Welcome to VirtuNexa Binary Converter --------

Enter your username: Madhur Gupta

Instructions:
1. Do not use spaces in the binary number.
2. To view conversion history, type "history".
3. To exit, type "exit".

Enter input: 1010
Decimal Equivalent is: 10

Enter a Binary Number: history
----- Conversion History -----
ID: 1 | User: Madhur Gupta | Binary: 1010 | Decimal: 10 | Date: 2025-02-23 11:29:00
------------------------------

Enter input: exit
Hope you liked it.....
Developed By- [Your Name]
Exiting...
```

## Additional Information

- **Error Handling:**  
  If you enter an invalid binary number (anything other than 0s and 1s), the application will alert you and prompt you to try again.

- **Data Storage:**  
  All conversion records are saved in an H2 database file located in the `./data` directory within the project folder. This file is automatically created when the application runs.

## Final Thoughts

This application is meant to be both a learning tool and a practical utility. It demonstrates how to build a simple, user-friendly Java application that combines conversion logic with persistent data storage. If you have any questions or feedback, please feel free to reach out.