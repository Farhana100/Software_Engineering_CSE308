package com.components;

public class ATMega32 implements MicroController
{
    @Override
    public void runMiController()
    {
        System.out.println("Running Microcontroller ATMega32.");
    }


    @Override
    public String toString()
    {
        return "ATMega32";
    }
}
