package app;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);



        boolean isRunning = true;
        System.out.println("Welcome to the Back Of Imagination");
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
            }
        }

    }
}
