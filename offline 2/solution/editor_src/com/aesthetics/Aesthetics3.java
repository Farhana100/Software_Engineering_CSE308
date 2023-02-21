package com.aesthetics;

public class Aesthetics3 implements Aesthetics
{
    private final String font = "Consolas";
    private final String style = "Normal";
    private final String color = "Blue";

    @Override
    public void use()
    {
        System.out.println("Using font: " + font + ", style: " + style + ", color: " + color);
    }
}
