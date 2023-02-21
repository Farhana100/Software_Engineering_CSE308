package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sum implements Calculator
{
    @Override
    public int getSum(File file) throws FileNotFoundException
    {
        int sum = 0, num;

        Scanner scanner = new Scanner(file);

        while(scanner.hasNextInt()){
            num = scanner.nextInt();
            System.out.println(num);
            sum = sum + num;
        }

        return sum;
    }
}
