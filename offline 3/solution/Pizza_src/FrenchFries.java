package com.company;

public class FrenchFries extends AppetizerDecorator
{
    private static int cost = 100;

    public FrenchFries(Order order)
    {
        super(order);
    }

    public static void setCost(int newCost)
    {
        cost = newCost;
    }

    @Override
    public String description()
    {
        return super.description() + ", French Fries";
    }

    @Override
    public int getCost()
    {
        return super.getCost() + cost;
    }
}
