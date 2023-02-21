package com.components;

public class Button implements Controller
{
    @Override
    public void runController()
    {
        System.out.println("Buttons are controlling.");
    }

    @Override
    public String toString()
    {
        return "Button";
    }
}
