package com.company;

public abstract class AppetizerDecorator implements Order
{
    private Order order;

    public AppetizerDecorator(Order order)
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
