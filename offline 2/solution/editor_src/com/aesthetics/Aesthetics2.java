package com.aesthetics;

public class Aesthetics2 implements Aesthetics
{
    private final String font = "Monaco";
    private final String style = "Normal";
    private final String color = "Blue";

    @Override
    public void use()
    {
        System.out.println("Using font: " + font + ", style: " + style + ", color: " + color);
    }
}
