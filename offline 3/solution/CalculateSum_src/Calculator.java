package com.company;

import java.io.File;
import java.io.FileNotFoundException;

public interface Calculator
{
    int getSum(File file) throws FileNotFoundException;
}
