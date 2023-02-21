package com.webserver;

public class WebServerLaravel implements WebServer
{
    @Override
    public void runServer()
    {
        System.out.println("Laravel web server running.");
    }

    @Override
    public String toString()
    {
        return "Web Server Laravel";
    }
}
