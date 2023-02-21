package com.company;

public class Employee
{
    private String name;

    public Employee(String name)
    {
        this.name = name;
    }

    // getters


    public String getName()
    {
        return name;
    }

    public String lookUp(Account account)
    {
        return account.getName() + "'s current balance " + account.getDeposit() + "$";
    }

    public String approveLoan(Bank bank, Account account)
    {
        bank.setInternalFund(bank.getInternalFund() - account.getLoanRequest());
        bank.setTotalPendingLoan(bank.getTotalPendingLoan() - account.getLoanRequest());
        account.setCurrentLoan(account.getCurrentLoan() + account.getLoanRequest());
        account.setDeposit(account.getDeposit() + account.getLoanRequest());
        account.setLoanRequest(0);

        return "Loan for " + account.getName() + " approved";
    }

    public String changeInterestRate(String accountType, float newInterestRate)
    {
        return "You don't have permission for this operation";
    }

    public String seeInternalFund(Bank bank)
    {
        return "You don't have permission for this operation";
    }

}

