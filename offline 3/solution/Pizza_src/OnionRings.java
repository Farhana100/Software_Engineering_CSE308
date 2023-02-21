package com.company;

public class OnionRings extends AppetizerDecorator
{
    private static int cost = 100;

    public OnionRings(Order order)
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
        return super.description() + ", Onion Rings";
    }

    @Override
    public int getCost()
    {
        return super.getCost() + cost;
    }
}
