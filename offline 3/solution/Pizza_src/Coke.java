package com.company;

public class Coke extends DrinksDecorator
{
    private static int cost = 50;

    public Coke(Order order)
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
        return super.description() + ", Coke";
    }

    @Override
    public int getCost()
    {
        return super.getCost() + cost;
    }
}
