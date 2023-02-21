package com.webserver;

public class WebServerDjango implements WebServer
{
    @Override
    public void runServer()
    {
        System.out.println("Django web server running.");
    }

    @Override
    public String toString()
    {
        return "Web Server Django";
    }
}
