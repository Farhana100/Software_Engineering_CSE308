package com.parser;

public class PythonParser implements Parser
{
    @Override
    public void parse(String fileName)
    {
        System.out.println("Parsing Python file: " + fileName);
    }
}
