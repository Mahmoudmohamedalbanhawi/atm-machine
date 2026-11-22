package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double balance = 2500.75;
        int correctPin = 1234;
        short attempts = 0;
        boolean isAuthenticated = false;


        while (attempts < 3) {

            System.out.print("Please enter your PIN: ");
            int pin = scanner.nextInt();

            if (pin == correctPin) {
                isAuthenticated = true;
                System.out.println("Welcome to the ATM Simulator!");
                break;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Please try again.");
            }
        }

// Check authentication
        if (!isAuthenticated) {

            System.out.println("Your account has been locked.");

        } else {

            int option;

            do {
                System.out.println(
                        "========= ATM =========\n" +
                                "1. Check Balance\n" +
                                "2. Deposit\n" +
                                "3. Withdraw\n" +
                                "4. Show Account Status\n" +
                                "5. Exit\n" +
                                "======================="
                );

                System.out.print("Please select an option: ");
                option = scanner.nextInt();

                switch (option) {

                    case 1:
                        System.out.println("Balance: $" + balance);
                        break;

                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();

                        if (depositAmount > 0) {
                            balance += depositAmount;
                            System.out.println("New balance: $" + balance);
                        } else {
                            System.out.println("Invalid deposit amount.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();

                        if (withdrawAmount > 0 && withdrawAmount <= balance) {
                            balance -= withdrawAmount;
                            System.out.println("New balance: $" + balance);
                        } else {
                            System.out.println("Invalid withdrawal amount.");
                        }
                        break;

                    case 4:
                        System.out.println("Balance: $" + balance);

                        if (balance >= 5000) {
                            System.out.println("VIP Customer");
                        } else if (balance >= 1000) {
                            System.out.println("Regular Customer");
                        } else {
                            System.out.println("Balance below $1000.");
                        }
                        break;

                    case 5:
                        System.out.println("Thank you for using the ATM!");
                        break;

                    default:
                        System.out.println("Invalid option.");
                }

            } while (option != 5);
        }

        scanner.close();

    }

        }

