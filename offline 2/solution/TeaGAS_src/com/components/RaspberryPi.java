package com.components;

public class RaspberryPi implements MicroController, Storage
{
    @Override
    public void runMiController()
    {
        System.out.println("Running Microcontroller Raspberry Pi.");
    }

    @Override
    public void store()
    {
        System.out.println("Storing data in built-in storage of Raspberry Pi.");
    }

    @Override
    public String toString()
    {
        return "Raspberry Pi";
    }
}
