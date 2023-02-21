package com.components;

public class CardRFID implements Id
{
    @Override
    public void scanId()
    {
        System.out.println("Scanning RFID card.");
    }

    @Override
    public String toString()
    {
        return "RFID Card";
    }
}
