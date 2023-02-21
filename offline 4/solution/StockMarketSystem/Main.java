package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException
    {
        int choice;
        int portNumber = 6666;

        System.out.println("Run as:");
        System.out.println("1 Admin");
        System.out.println("2 User");

        Scanner scanner = new Scanner(System.in);

        choice = scanner.nextInt();

        if (choice == 1)
        {
            // running as the admin

            File stockInfoFile = new File("input.txt");
            StockMarket stockMarket = new Stock(stockInfoFile);
            Server server = new Server(portNumber);
            System.out.println("Server created");

            // accept connections in different thread
            server.RunServer(stockMarket);

            // take trigger input

            while(true){
                stockMarket.setState(scanner.nextLine());
            }

        } else if (choice == 2)
        {
            // running as a user
            Socket clientSocket = new Socket("localhost", portNumber);
            System.out.println("connection established");

            Thread receiver = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    try{
                        synchronized (this){
                            while(true){
                                DataInputStream din = new DataInputStream(clientSocket.getInputStream());
                                String rmsg = din.readUTF();

                                if(rmsg != null){
                                    System.out.println(rmsg);
                                }
                            }
                        }
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            receiver.start();

            try{

                while(true){

                    String smsg = scanner.nextLine();

                    DataOutputStream dout = new DataOutputStream(clientSocket.getOutputStream());
                    dout.writeUTF(smsg);
                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }
            clientSocket.close();

        }
        else{
            System.out.println("Wrong Input");
        }

        scanner.close();
    }

}
