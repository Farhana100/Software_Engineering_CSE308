package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    private int portNumber;
    ServerSocket serverSocket = null;
    private int clientCount;

    public Server(int portNumber)
    {
        this.clientCount = 0;
        this.portNumber = portNumber;
        try
        {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void RunServer(StockMarket stockMarket)
    {
        /*
            -> creates a new thread
            -> waits for new connection requests and creates multithreaded client connection
         */
        new Thread(()->{
            while (true){
                try
                {
                    Socket clientSocket = serverSocket.accept();
                    clientCount++;

                    ClientHandler clientHandler = new ClientHandler("User "+ clientCount, clientSocket, stockMarket);
                    new Thread(clientHandler).start();
                    System.out.println("User " + clientCount + " connected");

                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void StopServer(){
        try
        {
            serverSocket.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
