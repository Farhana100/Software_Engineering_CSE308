package com.company;

public class VeggiPizza implements Order
{
    private static int cost = 1200;

    @Override
    public String description()
    {
        return "Veggi Pizza";
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
