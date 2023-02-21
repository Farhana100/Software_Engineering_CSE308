package com.company;

import java.util.EnumMap;
import java.util.Vector;

public class Bank
{
    private Object user;
    private Vector <Employee> employees;
    private Vector <Account> accounts;
    private Vector <String> pendingLoans;     // stores the account names with pending loan requests
    private float totalPendingLoan;
    private float internalFund;
    private int clock;


    private static final float initDepositFixedAccount = 100000;
    private static final float initInternalFund = 1000000;

    public Bank()
    {
        employees = new Vector<Employee>();
        accounts = new Vector<Account>();
        pendingLoans = new Vector<String>();
        internalFund = initInternalFund;
        totalPendingLoan = 0;

        user = null;

        clock = 0;

        // create MD
        createManagingDirector("MD");
        closeAccount();

        // create officer
        createOfficer("S1");
        closeAccount();

        createOfficer("S2");
        closeAccount();

        // create cashier
        createCashier("C1");
        closeAccount();
        createCashier("C2");
        closeAccount();
        createCashier("C3");
        closeAccount();
        createCashier("C4");
        closeAccount();
        createCashier("C5");
        closeAccount();

        System.out.println("Bank Created; MD,S1,S2,C1,C2,C3,C4,C5 created");
    }

    // getters


    public float getInternalFund()
    {
        return internalFund;
    }

    public float getTotalPendingLoan()
    {
        return totalPendingLoan;
    }

    // setters


    public void setInternalFund(float internalFund)
    {
        this.internalFund = internalFund;
    }

    public void setTotalPendingLoan(float totalPendingLoan)
    {
        this.totalPendingLoan = totalPendingLoan;
    }

    // others

    public String  createEmployee(String type, String name)
    {
        if(user != null) return "Invalid operation";

        switch (type.toLowerCase()){
            case "md":
                return createManagingDirector(name);
            case "cashier":
                return createCashier(name);
            case "officer":
                return createOfficer(name);

        }
        return type + " type employee does not exist.";
    }

    public String createAccount(String name, String type, float initDeposit )
    {
        if(user != null) return "Invalid operation";

        for (Account acc: accounts)
        {
            if(acc.getName().equalsIgnoreCase(name)){
                return "Account already exists.";
            }
        }

        switch (type.toLowerCase())
        {
            case "student" -> accounts.add(new StudentAccount(name, initDeposit));
            case "savings" -> accounts.add(new SavingsAccount(name, initDeposit));
            case "fixed" -> {
                if (initDeposit < initDepositFixedAccount)
                    return "Account creation unsuccessful; Initial Deposit is not enough.";
                accounts.add(new FixedDepositAccount(name, initDeposit));
            }
        }

        user = accounts.lastElement();

        return type + " account for " + name + " Created; initial balance " + initDeposit + '$';
    }

    // Open

    public String open(String name)
    {
        if(user != null) return "Invalid operation";

        for (Account acc: accounts)
        {
            if(acc.getName().equalsIgnoreCase(name)){
                user = acc;
                return "Welcome back, " + ((Account) user).getName();
            }
        }

        for(Employee emp: employees){

            if(emp.getName().equalsIgnoreCase(name)){
                user = emp;
                return ((Employee) user).getName() + " active" + (pendingLoans.isEmpty() ? " " : ", there are loan approvals pending");
            }
        }

        return "Invalid information";
    }

    //<<-------------------------------------------- for Account start ------------------------------------------------>>

    public String depositMoney(float amount)
    {
        if(user instanceof Account){
            return ((Account) user).depositMoney(amount);
        }

        return "Invalid operation";
    }

    public String withdrawMoney(float amount)
    {
        if(user instanceof Account){
            return ((Account) user).withdraw(amount);
        }

        return "Invalid operation";
    }


    public String requestLoan(float amount)
    {
        if(user instanceof Account){
            if(amount + totalPendingLoan > internalFund){
                return "Not enough fund left";
            }
            if(((Account) user).requestLoan(amount)){
                pendingLoans.add(((Account) user).getName());
                totalPendingLoan += amount;

                return "Loan request successful,sent for approval";
            }

            return "Loan request unsuccessful.";
        }

        return "Invalid operation";
    }

    public String queryDeposit()
    {
        if(user instanceof Account){
            return "Current balance " +  ((Account) user).getDeposit() + "$"
                    + (((Account) user).getCurrentLoan() == 0 ? "" : ", Loan " + ((Account) user).getCurrentLoan() + "$");
        }

        return "Invalid operation";
    }

    //<<-------------------------------------------- for Account end ------------------------------------------------>>


    //<<------------------------------------------ for Employee start ------------------------------------------------>>

    public String createManagingDirector(String name)
    {
        if(user != null) return "Invalid operation";

        for(Employee emp: employees){
            if(emp.getName().equalsIgnoreCase(name)){
                return "Already exists";
            }
        }

        employees.add(new ManagingDirector(name));
        user = employees.lastElement();

        return name;
    }

    public String createCashier(String name)
    {
        if(user != null) return "Invalid operation";

        for(Employee emp: employees){
            if(emp.getName().equalsIgnoreCase(name)){
                return "Already exists";
            }
        }

        employees.add(new Cashier(name));
        user = employees.lastElement();

        return name;
    }
    public String createOfficer(String name)
    {
        if(user != null) return "Invalid operation";

        for(Employee emp: employees){
            if(emp.getName().equalsIgnoreCase(name)){
                return "Already exists";
            }
        }

        employees.add(new Officer(name));
        user = employees.lastElement();

        return name;
    }

    public String lookUp(String accountName)
    {
        if(user instanceof Employee){
            for(Account acc: accounts){
                if(acc.getName().equalsIgnoreCase(accountName)){
                    return ((Employee) user).lookUp(acc);
                }
            }

            return "No such account";
        }

        return "Invalid operation";
    }

    public void approveLoan()
    {
        if(user instanceof Employee){
            for (String loan: pendingLoans)
            {
                for (Account acc: accounts){
                    if(acc.getName().equalsIgnoreCase(loan)){
                        System.out.println(((Employee) user).approveLoan(this, acc));
                        break;
                    }
                }
            }

            pendingLoans.clear();
        }
    }

    public String changeInterestRate(String accountType, float newInterestRate)
    {
        if(user instanceof Employee){
            return ((Employee) user).changeInterestRate(accountType, newInterestRate);
        }

        return "Invalid operation";
    }

    public String seeInternalFund()
    {
        if(user instanceof Employee){
            return ((Employee) user).seeInternalFund(this);
        }

        return "Invalid operation";
    }

    //<<-------------------------------------------- for Employee end ------------------------------------------------>>


    public String closeAccount()
    {
        String msg = "Invalid operation";
        if(user instanceof Account){
            msg = "Transaction Closed for " + ((Account)user).getName();
        }
        else if(user instanceof Employee){
            msg = "Operations for " + ((Employee) user).getName() + " closed";
        }

        user = null;
        return msg;
    }

    public String increaseClockCount()
    {
        clock++;

        for(Account acc: accounts){
            // disburse Interest
            acc.disburseInterest();

            // deduct service charge
            acc.deductServiceCharge();

            // deduct loan interest
            acc.deductLoanInterest();

            // mature Fixed Deposit account
            if(acc instanceof FixedDepositAccount)((FixedDepositAccount) acc).makeMature();
        }

        return clock + " year passed";
    }

}
