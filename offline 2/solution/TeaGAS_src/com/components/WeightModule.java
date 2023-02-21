package com.components;

public class WeightModule implements WeightMeasurement
{
    @Override
    public void measureWeight()
    {

        System.out.println("Measuring weight with weight module.");
    }

    @Override
    public String toString()
    {
        return "Weight Module";
    }
}
