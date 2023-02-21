package com.components;

public class WiFiModule implements InternetConnection
{
    @Override
    public void connectToInternet()
    {
        System.out.println("Connecting via WiFi module.");
    }

    @Override
    public String toString()
    {
        return "WiFi";
    }
}
