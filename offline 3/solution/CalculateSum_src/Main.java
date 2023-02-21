package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
	    Calculator calc = new Sum();
	    ASCIIsum asciIsum = new ASCIIadapter(calc);

        File file = new File("test_number_file.txt");

        try
        {
            System.out.println(calc.getSum(file));
        } catch (FileNotFoundException e)
        {
            System.out.println("file not found");
        }

        System.out.println(asciIsum.calc(file));

    }
}
