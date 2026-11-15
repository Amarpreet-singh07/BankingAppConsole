package app;

import domain.Account;
import services.BankServices;
import services.services.impl.BankConsoleServicesImplementation;

import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        System.out.println("Welcome to the Back Of Imagination");

        BankServices bankServices = new BankConsoleServicesImplementation();

        while(isRunning)
        {
            System.out.println(
              """
              1.Open Account
              2.Deposit Money
              3.Withdraw Money
              4.Transfer Money
              5.Account Statements
              6.List Accounts
              7.Search Account with name
              0.Exit
              """);

            System.out.print("Please select from above options ");

            String userChoice = scanner.nextLine().trim();

            System.out.println("User choice " + userChoice);
            switch (userChoice)
            {
                case "0" -> isRunning = false;
                case "1" -> openAccount(scanner,bankServices);
                case "6" -> listAllAccounts(scanner,bankServices);
            }
        }

    }


    private static void openAccount(Scanner scanner, BankServices bankServices)
    {
        System.out.print("Tell the account type (SAVING/CURRENT)");
        String accountType = scanner.nextLine().trim();
        System.out.print("Enter your name ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter your email ");
        String email = scanner.nextLine().trim();
        System.out.print("Enter your mobileNumber ");
        String mobileNumber = scanner.nextLine().trim();
        System.out.print("Enter your age ");
        Integer age = scanner.nextInt();
        System.out.print("Enter amount you want to deposite ");
        Double moneyInitial = scanner.nextDouble();
        scanner.nextLine(); // Clear the remaining newline character
        bankServices.openAccount(name,accountType,(double)0,mobileNumber,age,email);

    }
    private static void listAllAccounts(Scanner scanner, BankServices bankServices)
    {


        System.out.println("**** Account Database **** ");

        bankServices.listOfAccounts().forEach(account -> System.out.println("Account number : " + account.getAccountNumber()));
//bankServices.listOfAccounts.forEach( account-> System.out.println("Account Number -" + account.getAccountNumber()));
    }

}
