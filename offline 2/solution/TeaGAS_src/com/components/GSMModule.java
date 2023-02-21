package com.components;

public class GSMModule implements InternetConnection
{
    @Override
    public void connectToInternet()
    {
        System.out.println("Connecting via GSM module.");
    }

    @Override
    public String toString()
    {
        return "SIM Card";
    }
}
