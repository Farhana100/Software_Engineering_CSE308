package com.company;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Bank bank = new Bank();

        Scanner scanner = new Scanner(System.in);


        String[] operation;

        while(true){
            operation = scanner.nextLine().strip().split("\\s+");
            switch (operation[0].toLowerCase()){
                case "create":
                    System.out.println(bank.createAccount(operation[1], operation[2], Float.parseFloat(operation[3])));
                    break;
                case "open":
                    System.out.println(bank.open(operation[1]));
                    break;
                case "deposit":
                    System.out.println(bank.depositMoney(Float.parseFloat(operation[1])));
                    break;
                case "withdraw":
                    System.out.println(bank.withdrawMoney(Float.parseFloat(operation[1])));
                    break;
                case "query":
                    System.out.println(bank.queryDeposit());
                    break;
                case "request":
                    System.out.println(bank.requestLoan(Float.parseFloat(operation[1])));
                    break;
                case "approve":
                    bank.approveLoan();
                    break;
                case "change":
                    System.out.println(bank.changeInterestRate(operation[1], Float.parseFloat(operation[2])));
                    break;
                case "lookup":
                    System.out.println(bank.lookUp(operation[1]));
                    break;
                case "see":
                    System.out.println(bank.seeInternalFund());
                    break;
                case "inc":
                    System.out.println(bank.increaseClockCount());
                    break;
                case "close":
                    System.out.println(bank.closeAccount());
                    break;
                default:
            }

            if(operation[0].equalsIgnoreCase("exit")) break;
        }
    }
}
