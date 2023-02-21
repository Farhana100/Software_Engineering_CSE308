package com.components;

public class Ethernet implements InternetConnection
{
    @Override
    public void connectToInternet()
    {
        System.out.println("Connecting via Ethernet.");
    }

    @Override
    public String toString()
    {
        return "Ethernet";
    }
}
