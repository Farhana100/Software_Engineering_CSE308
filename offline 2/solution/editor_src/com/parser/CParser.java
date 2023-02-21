package com.parser;

public class CParser implements Parser
{
    @Override
    public void parse(String fileName)
    {
        System.out.println("Parsing C file: " + fileName);
    }
}
