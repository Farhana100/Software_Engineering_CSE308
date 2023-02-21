package com.company;

public class BeefPizza implements Order
{
    private static int cost = 1500;

    @Override
    public String description()
    {
        return "Beef Pizza";
    }

    @Override
    public int getCost()
    {
        return cost;
    }

    public static void setCost(int newCost)
    {
        cost = newCost;
    }
}
