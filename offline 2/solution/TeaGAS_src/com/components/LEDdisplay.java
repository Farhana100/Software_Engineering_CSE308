package com.components;

public class LEDdisplay implements Display
{
    @Override
    public void runDisplay()
    {
        System.out.println("Displaying in LED display.");
    }

    @Override
    public String toString()
    {
        return "LED Display";
    }
}
