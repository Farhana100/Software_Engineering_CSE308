package com.company;

public class Coffee extends DrinksDecorator
{
    private static int cost = 150;

    public Coffee(Order order)
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
        return super.description() + ", Coffee";
    }

    @Override
    public int getCost()
    {
        return super.getCost() + cost;
    }
}
