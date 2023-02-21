package com.company;

public class Cashier extends Employee
{
    public Cashier(String name)
    {
        super(name);
    }

    @Override
    public String approveLoan(Bank bank, Account account)
    {
        return "You don't have permission for this operation";
    }
}
