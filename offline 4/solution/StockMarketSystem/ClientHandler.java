package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable
{
    private String userName;
    private StockMarket stockMarket;
    private final Socket clientSocket;

    public ClientHandler(String userName, Socket clientSocket, StockMarket stockMarket)
    {
        this.userName = userName;
        this.stockMarket = stockMarket;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run()
    {

        DataOutputStream dout = null;   // reads query
        DataInputStream din = null;     // responds to query

        try
        {
            dout = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            din = new DataInputStream(clientSocket.getInputStream());
        } catch (IOException e)
        {
            e.printStackTrace();
        }


        // inform new user stock market's current state
        try
        {
            dout.writeUTF("" + stockMarket.getState());
        } catch (IOException e)
        {
            e.printStackTrace();
        }


        // waits for queries or requests and sends response
        while(true){
            String query = null;
            try
            {
                query = din.readUTF();
            } catch (IOException e)
            {
                e.printStackTrace();
            }

            assert query != null;

            if(query.equals("")){continue;}

            System.out.println(userName + ": " + query);

            // processing user command
            // if S attach observer
            // if U detach observer

            String[] cmd = query.strip().split("\\s+");

            if(cmd[0].equals("S")){
                new StockUpdateObserver(userName, cmd[1], stockMarket, clientSocket);
                try
                {
                    dout.writeUTF("Subscribed to Stock " + cmd[1]);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                System.out.println(userName + " subscribed to stock " + cmd[1]);
            }
            else if(cmd[0].equals("U")){
                if(stockMarket.detach(userName, cmd[1])){
                    try
                    {
                        dout.writeUTF("Unsubscribed from Stock " + cmd[1]);
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    System.out.println(userName + " unsubscribed from stock " + cmd[1]);
                }
            }else{
                try
                {
                    dout.writeUTF("Wrong command from client");
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

        }
    }
}
