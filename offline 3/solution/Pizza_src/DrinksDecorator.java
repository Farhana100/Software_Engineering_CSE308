package com.company;

public abstract class DrinksDecorator implements Order
{
    private Order order;

    public DrinksDecorator(Order order)
    {
        this.order = order;
    }

    @Override
    public String description(){
        return order.description();
    }

    @Override
    public int getCost()
    {
        return order.getCost();
    }
}
