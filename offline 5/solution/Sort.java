package com.company;

import java.util.ArrayList;

public class Sort
{
    public static ArrayList<Integer> sort(ArrayList <Integer>input, String order)
    {
        if(input == null) return null;  // null test

        if(order.equalsIgnoreCase("ascending")) return ascendingSort(input);
        if(order.equalsIgnoreCase("descending")) return descendingSort(input);
        return input;
    }

    public static ArrayList <Integer> ascendingSort(ArrayList<Integer> input)
    {
        int n = input.size();
        for (int i = 0; i < n; i++)
        {
            for (int j = i; j > 0; j--)
            {
                if (input.get(j) >= input.get(j-1))break;

                // swap
                Integer temp = input.get(j);
                input.set(j, input.get(j-1));
                input.set(j-1, temp);

            }
        }

        return input;
    }

    public static ArrayList <Integer> descendingSort(ArrayList<Integer> input)
    {

        int n = input.size();
        for (int i = 0; i < n; i++)
        {
            for (int j = i; j > 0; j--)
            {
                if (input.get(j) <= input.get(j-1))break;

                // swap
                Integer temp = input.get(j);
                input.set(j, input.get(j-1));
                input.set(j-1, temp);
            }
        }

        return input;
    }

}
