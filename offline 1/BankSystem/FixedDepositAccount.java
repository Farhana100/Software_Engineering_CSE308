package com.company;

public class FixedDepositAccount  extends Account
{
    private static final float minDepositAmount = 50000; // The deposit amount must not be less than 50,000$
    private static final float maxLoan = 100000;
    private static float interestRate = 15;

    private boolean isMature;

    public FixedDepositAccount(String name, float init_depo)
    {
        super(name, init_depo);
        this.isMature = false;
    }

    @Override
    public String depositMoney(float amount)
    {
        if(amount < minDepositAmount) return "Deposit unsuccessful; current balance " + this.getDeposit() + "$";

        return super.depositMoney(amount);
    }

    @Override
    public String withdraw(float amount)
    {
        if(!isMature) return "Invalid transaction; current balance " + this.getDeposit() + "$";
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

    public void makeMature()
    {
        isMature = true;
    }


    public static void updateInterestRate(float newInterestRate)
    {
        interestRate = newInterestRate;
    }
}
