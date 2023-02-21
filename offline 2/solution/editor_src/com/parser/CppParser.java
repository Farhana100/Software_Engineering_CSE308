package com.parser;

public class CppParser implements Parser
{
    @Override
    public void parse(String fileName)
    {
        System.out.println("Parsing Cpp file: " + fileName);
    }
}
