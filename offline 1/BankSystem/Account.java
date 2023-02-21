package com.company;

public abstract class Account
{
    private final String name;
    private float deposit;
    private float currentLoan;
    private float loanRequest;

    private static final float loanInterestRate = 10; // All loans have a xed 10% interest rate

    // constructor
    public Account(String name, float init_depo)
    {
        this.name  = name;
        this.deposit = init_depo;
        this.currentLoan = 0;
        this.loanRequest = 0;

    }

    // getters
    public String getName()
    {
        return name;
    }

    public float getDeposit()
    {
        return deposit;
    }

    public float getCurrentLoan()
    {
        return currentLoan;
    }

    public float getLoanRequest()
    {
        return loanRequest;
    }

    // setters
    public void setCurrentLoan(float currentLoan)
    {
        this.currentLoan = currentLoan;
    }

    public void setDeposit(float deposit)
    {
        this.deposit = deposit;
    }

    public void setLoanRequest(float loanRequest)
    {
        this.loanRequest = loanRequest;
    }

    // abstract methods
    public abstract float getInterestRate();
    public abstract float getMaxAllowableLoan();

    // others
    public String depositMoney(float amount)
    {
        deposit += amount;

        return amount + "$ deposited; current balance " + deposit + "$";
    }

    public String withdraw(float amount)
    {
        if(deposit < amount){
            return "Invalid transaction; current balance " + deposit + "$";
        }

        this.deposit -= amount;

        return "Withdrawal successful; current balance " + deposit + "$";
    }

    public boolean requestLoan(float loanAmount)
    {
        if(currentLoan + loanRequest + loanAmount > getMaxAllowableLoan()) return false;
        loanRequest += loanAmount;
        return true;
    }

    public void deductLoanInterest()
    {
        deposit -= currentLoan * loanInterestRate / 100.0;
    }

    public void disburseInterest()
    {
        deposit += deposit * getInterestRate() / 100.0;
    }

    public void deductServiceCharge()
    {
        deposit -= 500;
    }


}
