package com.example.bank;

import java.util.*;

class Account {
    private int accNumber;
    private String holderName;
    private double balance;

    public Account(int accNumber, String holderName, double balance) {
        this.accNumber = accNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accNumber);
        System.out.println("Holder Name   : " + holderName);
        System.out.println("Balance       : " + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

public class BankManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Bank Account Management ---");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewAccount();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();  // consume newline
        System.out.print("Enter Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ₹");
        double bal = sc.nextDouble();

        Account acc = new Account(accNo, name, bal);
        accounts.put(accNo, acc);
        System.out.println("Account Created Successfully.");
    }

    static void viewAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        Account acc = accounts.get(accNo);
        if (acc != null) {
            acc.displayDetails();
        } else {
            System.out.println("Account not found!");
        }
    }

    static void deposit() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter Amount to Deposit: ₹");
        double amount = sc.nextDouble();
        Account acc = accounts.get(accNo);
        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    static void withdraw() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter Amount to Withdraw: ₹");
        double amount = sc.nextDouble();
        Account acc = accounts.get(accNo);
        if (acc != null) {
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
    }
}