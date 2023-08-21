package bankingApp;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Otabek", "220104");
        acc1.showMenu();
    }
}

class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String customerName, String customerId){
        this.customerName = customerName;
        this.customerId = customerId;
    }

    void deposit(int amount) {
        if(amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if(amount != 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction > 0) {
            System.out.println("Deposit: " + previousTransaction);
        }
        else if(previousTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(previousTransaction));
        }
        else {
            System.out.println("No transaction accured");
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID: " + customerId);
        System.out.println("\nA. Check balance"
                + "\nB. Deposit"
                + "\nC. Withdraw"
                + "\nD. Previous Transaction"
                + "\nE. Exit");
        do {
            System.out.println("=======================================================================");
            System.out.println("Enter an option: ");
            System.out.println("=======================================================================");
            option = sc.next().charAt(0);
            System.out.println();

            switch (option) {
                case 'A': {
                    System.out.println("----------------------------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("----------------------------------------------");
                    System.out.println();
                    break;
                }
                case 'B': {
                    System.out.println("----------------------------------------------");
                    System.out.println("Enter an amount to deposit: ");
                    System.out.println("----------------------------------------------");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                }
                case 'C': {
                    System.out.println("----------------------------------------------");
                    System.out.println("Enter an amount to withdraw: ");
                    System.out.println("----------------------------------------------");
                    int amount = sc.nextInt();
                    withdraw(amount);
                    System.out.println();
                    break;			}
                case 'D': {
                    System.out.println("----------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("----------------------------------------------");
                    System.out.println();
                    break;
                }
                case 'E': {
                    System.out.println("***********************************************");
                    break;
                }
                default:
                    System.out.println("Invalid option, please enter again: ");
                    break;
            }
        } while (option != 'E');
        System.out.println("Thank you for using our service!");
    }
}
