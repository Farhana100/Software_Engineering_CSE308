package com.components;

public class LCDdisplay implements Display
{
    @Override
    public void runDisplay()
    {
        System.out.println("Displaying in LCD display.");
    }

    @Override
    public String toString()
    {
        return "LCD Display";
    }
}
