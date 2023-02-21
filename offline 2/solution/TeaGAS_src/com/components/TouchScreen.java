package com.components;

public class TouchScreen implements Controller, Display
{
    @Override
    public void runController()
    {
        System.out.println("Touch Screen is controlling.");
    }

    @Override
    public void runDisplay()
    {
        System.out.println("Displaying in Touch Screen.");
    }

    @Override
    public String toString()
    {
        return "Touch Screen";
    }
}
