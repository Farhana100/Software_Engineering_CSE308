package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Stock implements StockMarket
{
    // synchronizer for multi-thread safety
    private final Object synchronizer = new Object();

    private Vector<Vector> stockInfo;
    private HashMap<String, Vector<Observer>> observers;

    public Stock(File infoFIle)
    {
        stockInfo = new Vector<Vector>();
        observers = new HashMap<String, Vector<Observer>>();

        try
        {
            Scanner scanner = new Scanner(infoFIle);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);

                String[] str = data.strip().split("\\s+");
                Vector temp = new Vector<>();
                temp.add(str[0]);
                temp.add(Integer.parseInt(str[1]));
                temp.add(Float.parseFloat(str[2]));
                stockInfo.add(temp);

                observers.put(str[0], new Vector<Observer>());
            }
            scanner.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String getState()
    {
        String stockReport = "";

        for (Vector vec:
                stockInfo
        )
        {
            stockReport += vec.toString() + "\n";
        }


        return stockReport;
    }

    @Override
    public void setState(String cmd)
    {
        /*
            updates the stock information and notifies all about the update
        */

        String[] str = cmd.strip().split("\\s+");

        assert str.length == 3;

        if(str[0].equals("I")){


            for (Vector vec:
                    stockInfo
            )
            {
                if(vec.elementAt(0).equals(str[1])){
                    float newVal = (float)vec.elementAt(2) + Float.parseFloat(str[2]);
                    vec.set(2, newVal);
                    notifyAllObservers(str[1], "Price of stock " + str[1] + " increased to " + newVal);
                    System.out.println("Price of stock " + str[1] + " increased to " + newVal);
                    break;
                }
            }
        }
        else if(str[0].equals("D")){

            for (Vector vec:
                    stockInfo
            )
            {
                if(vec.elementAt(0).equals(str[1])){
                    float newVal = (float)vec.elementAt(2) - Float.parseFloat(str[2]);
                    vec.set(2, newVal);
                    notifyAllObservers(str[1], "Price of stock " + str[1] + " decreased to " + newVal);
                    System.out.println("Price of stock " + str[1] + " decreased to " + newVal);
                    break;
                }
            }
        }
        else if(str[0].equals("C")){

            for (Vector vec:
                    stockInfo
            )
            {
                if(vec.elementAt(0).equals(str[1])){
                    int newVal = (int)vec.elementAt(1) + Integer.parseInt(str[2]);
                    vec.set(1, newVal);
                    notifyAllObservers(str[1], "Count of stock " + str[1] + " changed to " + newVal);
                    System.out.println("Count of stock " + str[1] + " changed to " + newVal);
                    break;
                }
            }
        }
        else{
            //System.out.println("Wrong trigger command");
        }
    }

    @Override
    public boolean attach(Observer observer)
    {
        synchronized(synchronizer) {
            Vector<Observer> thisStockObservers = observers.get(observer.getStockName());

            if(thisStockObservers == null) return false;

            // check if already exists
            for (Observer obs:
                    thisStockObservers
            )
            {
                if(obs.getUserName().equals(observer.getUserName()))return false;
            }
            thisStockObservers.add(observer);
            return true;
        }

    }

    @Override
    public boolean detach(String userName, String stockName)
    {

        synchronized(synchronizer) {
            Vector <Observer> thisStockObservers = observers.get(stockName);
            Observer rem = null;

            for (Observer observer:
                    thisStockObservers)
            {
                if(observer.getUserName().equals(userName)){
                    rem = observer;
                    break;
                }
            }

            if(thisStockObservers == null) return false;
            thisStockObservers.remove(rem);
            return  true;
        }
    }

    @Override
    public void notifyAllObservers(String stockName, String updateMsg)
    {
        /*
            -> this function is called when a state change is done
            -> calls the update function of all observers to notify about the changes made
         */

        Vector <Observer> thisStockObservers = null;

        synchronized(synchronizer) {
            thisStockObservers = observers.get(stockName);
        }

        if(thisStockObservers == null) return;
        for (Observer observer:
                thisStockObservers)
        {
            observer.update(updateMsg);
        }
    }
}
