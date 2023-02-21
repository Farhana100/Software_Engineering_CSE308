package com.company;

import java.io.*;

public class ASCIIadapter implements ASCIIsum
{
    private Calculator calculator;

    ASCIIadapter(Calculator calculator)
    {
        this.calculator = calculator;
    }

    @Override
    public int calc(File file)
    {
        // convert file

        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt", true));
            BufferedReader reader = new BufferedReader(new FileReader(file));

            int ch;
            while((ch = reader.read()) != -1){
                if(ch == (int)' '){
                    writer.append(' ');
                }
                else
                {
                    writer.append(Integer.toString(ch));
                }
            }

            writer.close();
            reader.close();

            File tempFile = new File("temp.txt");

            int sum = calculator.getSum(tempFile);

            tempFile.delete();

            return sum;

        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return 0;
    }
}
