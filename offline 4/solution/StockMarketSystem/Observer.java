package com.company;

public interface Observer
{
    String getStockName();
    String getUserName();
    void update(String updateMsg);
}
