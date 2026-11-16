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
                case "2" -> depositMoney(scanner,bankServices);
                case "3" -> withdrawMoney(scanner,bankServices);
                case "4" -> transferMoney(scanner,bankServices);

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

        scanner.nextLine(); // Clear the remaining newline character
        String accountNumber = bankServices.openAccount(name,accountType,(double)0,mobileNumber,age,email);

        System.out.println("Your account is created A/c number is : "  + accountNumber);



    }


    private static void depositMoney(Scanner scanner, BankServices bankServices) {
        System.out.print("Enter your account number");
        String accountNum = scanner.nextLine().trim();
        System.out.print("Enter amount you want to deposite ");
        Double moneyDeposit = scanner.nextDouble();
        System.out.print("Add a note for the transaction");
        String note = scanner.nextLine();

        bankServices.depositMoney(accountNum,moneyDeposit,note);

        System.out.println("Money Deposited");
    }


    private static void withdrawMoney(Scanner scanner, BankServices bankServices)
    {
        System.out.print("Enter your account number : ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter amount to withdraw : ");
        Double amount = scanner.nextDouble();
        System.out.print("Enter note for the transaction : ");
        String note = scanner.nextLine();

        bankServices.withdrawMoney(accountNumber,amount,note);

        System.out.println("Money Withdrawed ");
    }

    private static void transferMoney(Scanner scanner, BankServices bankServices)
    {
        System.out.print("Enter From Acc number : ");
        String fromAcc = scanner.nextLine();
        System.out.print("Enter To Acc number : ");
        String toAcc = scanner.nextLine();
        System.out.print("Enter amounnt to transfer ");
        Double amount = scanner.nextDouble();
        System.out.print("Enter note for the transaction ");
        String note = scanner.nextLine();

        bankServices.transferAmount(fromAcc,toAcc,amount,note);

        System.out.println("Money Transfered");
    }

    private static void listAllAccounts(Scanner scanner, BankServices bankServices)
    {


        System.out.println("**** Account Database **** ");

        bankServices.listOfAccounts().forEach(account -> System.out.println("Account number : " + account.getAccountNumber()+ " || Account Type " + account.getAccountType() + " | Money" + account.getMoney()));
    }



}
