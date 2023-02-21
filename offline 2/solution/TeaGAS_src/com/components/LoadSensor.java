package com.components;

public class LoadSensor implements WeightMeasurement
{
    @Override
    public void measureWeight()
    {
        System.out.println("Measuring weight with Load Sensor.");
    }

    @Override
    public String toString()
    {
        return "Load Sensor";
    }
}
