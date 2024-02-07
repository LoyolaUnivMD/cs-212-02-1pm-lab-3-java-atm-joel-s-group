// Programmers:  Dina Quevedo + Joel Robinson
// Course:  CS 212
// Due Date: 2/11/24
// Lab Assignment: 3
// Problem Statement: Create an ATM with various actions to display changed balance when deposited and withdrawn money.
// Data In: user_name, action selection, deposit amount, withdraw amount
// Data Out: welcome message, balance checks, email or printed receipt.
// Credits: Lab 4 Prompt

// imports Scanner and Decimal Format
import java.util.Scanner;
import java.text.DecimalFormat;

class Lab3 {
    //Initializes static variables used in each method
    static Scanner input = new Scanner(System.in);
    static DecimalFormat baldcft = new DecimalFormat("$###,###,###,###.##");
    static double balance = 212.90;

    //initialize deposit method that will take output and input
    static void deposit(){
        double depositamt = 0;
        System.out.println("Please select an amount to deposit: ");
        //error checking do while loop
        do {
            while (!input.hasNextDouble()) {
                System.out.println("Please choose a valid number.");
                input.next();
            }
            depositamt = input.nextDouble();
        } while(depositamt <= 0);

        //print amount deposited.
        System.out.println("The amount you are depositing is: " + baldcft.format(depositamt));
        balance += depositamt;
        System.out.println("Your new balance is: " + baldcft.format(balance));

    }
    //initialize withdraw  method that will take output and input
    static void withdrawal(){
        double withdrawamt = 0;
        System.out.println("Please select an amount to deposit: ");
        //error checking do while loop
        do {
            while (!input.hasNextDouble()) {
                System.out.println("Please choose a valid number.");
                input.next();
            }
            withdrawamt = input.nextDouble();
        } while(withdrawamt <= 0 && withdrawamt <= balance);

        //print amount withdrawing.
        System.out.println("The amount you are withdrawing is: " + baldcft.format(withdrawamt));
        balance -= withdrawamt;
        System.out.println("Your new balance is: " + baldcft.format(balance));
    }
    //initialize leave method that will take output and input
    static void leave(){
        System.out.println("Would you like email or printed receipt?");
        String email_or_receipt = input.nextLine();
        //error checking do while loop
        while(!email_or_receipt.equals("email") && !email_or_receipt.equals("receipt")) {
            System.out.println("Please choose a valid option.");
            email_or_receipt = input.nextLine();
        }
            if(email_or_receipt.equals("email")){
                System.out.println("You have chosen an email receipt. Make sure to check your email.");
            } else{
                System.out.println("You have chosen a physical receipt, make sure to take your receipt!");
            }
            System.out.println("Thank you for using this ATM");
            System.out.println("Your final balance is: " + baldcft.format(balance));


    }
    //initialize check balance method that will take output and input
    static void checkBalance(){
        //print current balance.
        System.out.println("Your current balance is : " + baldcft.format(balance));
    }
    public static void main(String[] args) {
       System.out.println("What is your name? ");
       String user_name = input.nextLine();
       String[] names = user_name.strip().split(" ");

       System.out.println("Welcome to Lab 3, "+ names[0]);
       System.out.print("\n");
        //initial prompting for a menu service.
       System.out.print("What action would you like to do? (deposit/withdraw/check balance/leave) ");
       String action_selection = input.nextLine();

       //looping menu while it doesnt equal leave
       while (!action_selection.equals("leave")){
           if (action_selection.equals("deposit")){
               deposit();
           } else if (action_selection.equals("withdraw")) {
               withdrawal();
           } else if (action_selection.equals("check balance")) {
               checkBalance();
           }
           System.out.print("What action would you like to do? (deposit/withdraw/check balance/leave) ");
           action_selection = input.nextLine();
       }
       leave();

    }
}
