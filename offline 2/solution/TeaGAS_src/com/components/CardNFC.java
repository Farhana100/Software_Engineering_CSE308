package com.components;

public class CardNFC implements Id
{
    @Override
    public void scanId()
    {
        System.out.println("Scanning NFC card.");
    }

    @Override
    public String toString()
    {
        return "NFC Card";
    }
}
