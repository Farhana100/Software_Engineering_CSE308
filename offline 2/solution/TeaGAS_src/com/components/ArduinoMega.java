package com.components;

public class ArduinoMega implements MicroController
{
    @Override
    public void runMiController()
    {
        System.out.println("Running Microcontroller Arduino Mega.");
    }

    @Override
    public String toString()
    {
        return "ArduinoMega";
    }
}
