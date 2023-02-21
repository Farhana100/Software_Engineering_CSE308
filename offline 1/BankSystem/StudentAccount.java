package com.company;

public class StudentAccount extends Account
{
    private static final float maxWithdraw = 10000 ; // A student account cannot withdraw more than 10,000$ in one transaction.
    private static final float maxLoan = 1000;
    private static float interestRate = 5;

    public StudentAccount(String name, float init_depo)
    {
        super(name, init_depo);
    }

    @Override
    public String withdraw(float amount)
    {
        if(amount > maxWithdraw) return "Invalid transaction; current balance " + this.getDeposit() + "$";
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

    @Override
    public void deductServiceCharge(){}

}
