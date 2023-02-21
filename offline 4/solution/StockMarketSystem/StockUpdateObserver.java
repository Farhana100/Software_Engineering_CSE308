package com.company;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class StockUpdateObserver implements Observer
{
    private String userName;
    private String stockName;
    private StockMarket stockMarket;
    private Socket clientSocket;        // for communication with the client, accepted by the server

    public StockUpdateObserver(String userName, String stockName, StockMarket stockMarket, Socket clientSocket)
    {
        this.userName = userName;
        this.stockName = stockName;
        this.stockMarket = stockMarket;
        this.clientSocket = clientSocket;

        // attach observer
        stockMarket.attach(this);
    }

    public String getStockName()
    {
        return stockName;
    }

    @Override
    public String getUserName()
    {
        return this.userName;
    }

    @Override
    public void update(String updateMsg)
    {
        // send the updated data to client socket

        try
        {
            DataOutputStream dout = new DataOutputStream(clientSocket.getOutputStream());
            dout.writeUTF(updateMsg);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
