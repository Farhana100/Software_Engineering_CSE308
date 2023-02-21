package com.company;

public interface StockMarket
{
    String getState();                      // gets the current state of the stock prices
    void setState(String cmd);            // updates the current state of the stock prices
    boolean attach(Observer observer);      // attaches an observer for a newly registered client
    boolean detach(String userName, String stockName);      // detaches the observer for an unregistered client
    void notifyAllObservers(String stockName, String updateMsg);           // notifies all attached observers
}
