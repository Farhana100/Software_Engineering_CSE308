package com.components;

public class SDcard implements Storage
{
    @Override
    public void store()
    {
        System.out.println("Storing data in SD card.");
    }

    @Override
    public String toString()
    {
        return "SD Card";
    }
}
