package com.aesthetics;

public class Aesthetics1 implements Aesthetics
{
    private final String font = "Courier New";
    private final String style = "Normal";
    private final String color = "Blue";

    @Override
    public void use()
    {
        System.out.println("Using font: " + font + ", style: " + style + ", color: " + color);
    }
}
