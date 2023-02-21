package com.company;

public class SavingsAccount extends Account
{
    private static final float minDeposit = 1000;  // A savings account cannot withdraw if the withdrawal results in a deposit of less than 1,000$.
    private static final float maxLoan = 10000;
    private static float interestRate = 10;

    public SavingsAccount(String name, float init_depo)
    {
        super(name, init_depo);
    }

    @Override
    public String withdraw(float amount)
    {
        if(this.getDeposit() - amount < minDeposit) return "Invalid transaction; current balance " + this.getDeposit() + "$";

        return super.withdraw(amount);
    }


    @Override
    public float getInterestRate()
    {
        return interestRate;
    }

    @Override
    public float getMaxAllowableLoan()
    {
        return maxLoan;
    }

    public static void updateInterestRate(float newInterestRate)
    {
        interestRate = newInterestRate;
    }
}
