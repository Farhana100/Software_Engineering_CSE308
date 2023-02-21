package com.company;

public class ManagingDirector extends Employee
{
    public ManagingDirector(String name)
    {
        super(name);
    }

    @Override
    public String changeInterestRate(String accountType, float newInterestRate)
    {
        switch (accountType)
        {
            case "student" -> StudentAccount.updateInterestRate(newInterestRate);
            case "savings" -> SavingsAccount.updateInterestRate(newInterestRate);
            case "fixed" -> FixedDepositAccount.updateInterestRate(newInterestRate);
        }

        return "Interest rate of " + accountType + " was changed to " + newInterestRate;
    }

    @Override
    public String seeInternalFund(Bank bank)
    {
        return "Internal fund is " + bank.getInternalFund();
    }
}
